package org.workshop.starter.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.workshop.starter.autoconfigure.EncoderProperties;
import org.workshop.starter.objects.Message;
import org.workshop.starter.objects.Response;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClientEncoderService implements IClientEncoder {

    private final EncoderProperties properties;

    @Override
    public String communicate(Message message) {
        try{
            Socket socket = new Socket(properties.getHost(), properties.getPort());

            ObjectInputStream ois  = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            Response response;

            oos.writeObject(message);
            oos.flush();

            response = (Response) ois.readObject();

            oos.writeObject("exit");
            oos.flush();

            oos.close();
            ois.close();
            socket.close();

            return response.getPassword();
        }catch(Exception e){
            log.error("Error client", e);
            return "Error encoding your password";
        }

    }
}