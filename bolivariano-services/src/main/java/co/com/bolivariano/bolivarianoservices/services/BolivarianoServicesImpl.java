package co.com.bolivariano.bolivarianoservices.services;

import co.com.bolivariano.bolivarianoservices.domain.Status;
import co.com.bolivariano.bolivarianoservices.domain.xsd.Passenger;
import co.com.bolivariano.bolivarianoservices.domain.xsd.GetJourneyResponse;
import co.com.bolivariano.bolivarianoservices.domain.xsd.Header;
import co.com.bolivariano.bolivarianoservices.domain.xsd.JourneyList;
import co.com.bolivariano.bolivarianoservices.exceptions.ErrorMessage;
import co.com.bolivariano.bolivarianoservices.exceptions.FTPErrors;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;


@Service
@RequiredArgsConstructor
public class BolivarianoServicesImpl implements BolivarianoServices {

    @Value("${bolivariano.ftp.server.host}")
    private String host;

    @Value("${bolivariano.ftp.server.port}")
    private String port;

    @Value("${bolivariano.ftp.server.username}")
    private String user;

    @Value("${bolivariano.ftp.server.password}")
    private String pass;

    @Value("${bolivariano.local.path}")
    private String local;

    @Value("${bolivariano.ftp.server.remote}")
    private String remote;

    private FTPClient client;

    private Logger logger = LoggerFactory.getLogger(BolivarianoServicesImpl.class);

    @Override
    public void connect() throws FTPErrors {
        client = new FTPClient();
        client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
        int reply;

        try {
            client.connect(host, Integer.parseInt(port));
        } catch (IOException e) {
            ErrorMessage errorMessage = new ErrorMessage(-1, "No fue posible conectarse al FTP a traves del host=" + host);
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }

        reply = client.getReplyCode();

        if (!FTPReply.isPositiveCompletion(reply)) {

            try {
                client.disconnect();
            } catch (IOException e) {
                ErrorMessage errorMessage = new ErrorMessage(-2, "No fue posible conectarse al FTP, el host=" + host + " entregó la respuesta=" + reply);
                logger.error(errorMessage.toString());
                throw new FTPErrors(errorMessage);
            }
        }

        try {
            client.login(user, pass);
        } catch (IOException e) {
            ErrorMessage errorMessage = new ErrorMessage(-3, "El usuario=" + user + ", y el pass=**** no fueron válidos para la autenticación.");
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }

        try {
            client.setFileType(FTP.BINARY_FILE_TYPE);
        } catch (IOException e) {
            ErrorMessage errorMessage = new ErrorMessage(-4, "El tipo de dato para la transferencia no es valido.");
            logger.error(errorMessage.toString());
            throw new FTPErrors(errorMessage);
        }
        client.enterLocalPassiveMode();
    }

    @Override
    public CompletableFuture<GetJourneyResponse> download() throws FTPErrors {
        FileOutputStream fos;
        GetJourneyResponse response = new GetJourneyResponse();
        Header header = new Header();
        JourneyList lista = new JourneyList();
        try {
            connect();
            fos = new FileOutputStream(local);
        } catch (FileNotFoundException e) {
            logger.error("Error getting ftp connections!", e);
            header.setCode(Status.ERROR.name());
            header.setDescription(String.format("No se pudo obtener la referencia a la carpeta relativa donde guardar, verifique la ruta y los permisos. %s", e.getMessage()));

            response.setHeader(header);

            return CompletableFuture.completedFuture(response);
        }

        try {
            //this.client.retrieveFile(remote, fos);

            //CSVReader reader = new CSVReader(new FileReader(local));
            CSVReader reader = new CSVReaderBuilder(new FileReader(local)).withSkipLines(1).build();
            String[] line;

            while ((line = reader.readNext()) != null) {
                System.out.println("Pasajero [nombre= " + line[0] + ", apellidos= " + line[1] + " , tipo=" + line[2] + "]");
                Passenger pasajero = new Passenger();
                pasajero.setNombres(line[0]);
                pasajero.setApellidos(line[1]);
                pasajero.setTipoDocumento(line[2]);
                pasajero.setNumeroDocumento(line[3]);
                pasajero.setFecha(line[4]);
                pasajero.setHora(line[5]);
                pasajero.setOrigen(line[6]);
                pasajero.setDestino(line[7]);

                lista.getJourneys().add(pasajero);
            }
        } catch (IOException | CsvValidationException e) {
            logger.error("Error getting passenger informations!", e);
            header.setCode(Status.ERROR.name());
            header.setDescription(String.format("No se pudo descargar el archivo. %s", e.getMessage()));

            response.setHeader(header);
            return CompletableFuture.completedFuture(response);
        }

        disconnect();

        header.setCode(Status.SUCCESS.name());
        header.setDescription("Informacion de pasajeros recuperada exitosamente");

        if (lista.getJourneys().size() == 0) {
            header.setCode(Status.EMPTY.name());
            header.setDescription("No se encontro informacion de los pasajeros de bolivariano");
        }

        response.setHeader(header);
        response.setInformation(lista);
        return CompletableFuture.completedFuture(response);
    }

    @Override
    public void disconnect() throws FTPErrors {
        if (this.client.isConnected()) {
            try {
                this.client.logout();
                this.client.disconnect();
            } catch (IOException f) {
                // do nothing as file is already downloaded from FTP server
            }
        }
    }
}
