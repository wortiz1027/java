package co.edu.javeriana.external.services.cc.application;

import co.edu.javeriana.external.services.cc.domain.CreditCard;
import co.edu.javeriana.external.services.cc.dtos.Request;
import co.edu.javeriana.external.services.cc.dtos.Response;
import co.edu.javeriana.external.services.cc.dtos.Status;
import co.edu.javeriana.external.services.cc.infraestructure.client.CreditCardValidationWsClient;
import co.edu.javeriana.external.services.cc.infraestructure.wsdl.model.GetCreditCardValidationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CreditCardServicesImpl implements CreditCardServices {

    private final CreditCardValidationWsClient service;
    
    @Override
    public CompletableFuture<Response> getCreditCardValidation(Request request) {
        Response response = new Response();
        Status status = new Status();

        try {
            GetCreditCardValidationResponse rs = this.service.getCreditCardValidation(request);

            if (rs == null) {
                status.setCode(co.edu.javeriana.external.services.cc.domain.Status.ERROR.name());
                status.setDescription("Error! there is an error getting validation informations");
                response.setStatus(status);
                
                return CompletableFuture.completedFuture(response);
            }

            CreditCard creditCardValidation = new CreditCard();
            
            creditCardValidation.setEmisorTarjeta(rs.getIssuingNetwork());
            creditCardValidation.setNumero(rs.getNumber());
            creditCardValidation.setBalance(rs.getBalance());

            status.setCode(co.edu.javeriana.external.services.cc.domain.Status.SUCCESS.name());
            status.setDescription("CreditCardValidation query has been success");
            response.setStatus(status);
            response.setCreditCard(creditCardValidation);

            return CompletableFuture.completedFuture(response);

        }catch(Exception e) {
            e.printStackTrace();
            status.setCode(co.edu.javeriana.external.services.cc.domain.Status.ERROR.name());
            status.setDescription(String.format("There is an error getting CreditCard Validation : %s", e.getMessage()));
            response.setStatus(status);

            return CompletableFuture.completedFuture(response);
        }

    }
}
