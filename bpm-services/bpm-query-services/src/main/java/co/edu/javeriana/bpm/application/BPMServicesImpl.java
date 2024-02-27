package co.edu.javeriana.bpm.application;

import co.edu.javeriana.bpm.dtos.Request;
import co.edu.javeriana.bpm.dtos.Response;
import co.edu.javeriana.bpm.dtos.Status;
import co.edu.javeriana.bpm.infraestructure.client.BPMWsClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class BPMServicesImpl implements BPMServices{

    private final BPMWsClient service;

    @Override
    public CompletableFuture<Response> getInstanciaBPM(Request data) {
        Response response = new Response();
        Status status = new Status();

        try{
            String rs = this.service.getInstanciaBPM(data);

            if (rs == null) {
                status.setCode(co.edu.javeriana.bpm.domain.Status.ERROR.name());
                status.setDescription("Error! there is an error getting instance BPM");

                response.setStatus(status);
                response.setRespuesta("");

                return CompletableFuture.completedFuture(response);
            }

            status.setCode(co.edu.javeriana.bpm.domain.Status.SUCCESS.name());
            status.setDescription("BPM query has been success");
            response.setStatus(status);
            response.setRespuesta("OK");

            return CompletableFuture.completedFuture(response);

        }catch(Exception e) {
            e.printStackTrace();
            status.setCode(co.edu.javeriana.bpm.domain.Status.ERROR.name());
            status.setDescription(String.format("There is an error getting instance BPM : %s", e.getMessage()));
            response.setStatus(status);

            return CompletableFuture.completedFuture(response);
        }

    }
}
