package co.com.client.encoder.service;

import co.com.client.encoder.dtos.Request;
import co.com.client.encoder.dtos.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.workshop.starter.objects.Algorithm;
import org.workshop.starter.objects.Message;
import org.workshop.starter.service.IClientEncoder;

@Service
@RequiredArgsConstructor
public class SecurityService implements ISecurityService {

    private final IClientEncoder encoder;

    @Override
    public Response encrypt(Request request) {
        Message message = Message.builder().build();

        message.setAlgorithm(Algorithm.getEnumByString(request.getAlgotihm()));
        message.setPassword(request.getPassword());

        return Response.builder().encryptedPAssword(this.encoder.communicate(message)).build();
    }

}