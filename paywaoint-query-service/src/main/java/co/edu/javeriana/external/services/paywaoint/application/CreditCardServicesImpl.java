package co.edu.javeriana.external.services.paywaoint.application;

import co.edu.javeriana.external.services.paywaoint.dtos.Request;
import co.edu.javeriana.external.services.paywaoint.dtos.Response;
import co.edu.javeriana.external.services.paywaoint.dtos.Status;
import co.edu.javeriana.external.services.paywaoint.infraestructure.client.CreditCardWsClient;
import co.edu.javeriana.external.services.paywaoint.infraestructure.wsdl.model.ChargeCreditCardResponseElement;
import co.edu.javeriana.external.services.paywaoint.infraestructure.wsdl.model.VerifyCreditCardResponseElement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CreditCardServicesImpl implements CreditCardServices {

    private final CreditCardWsClient service;
    
    @Override
    public CompletableFuture<Response> getCreditCardValidation(Request request) {
        Response response = new Response();
        Status status = new Status();

        try {
            VerifyCreditCardResponseElement rs = this.service.getVerifyCreditCard(request);

            if (rs == null) {
                status.setCode(co.edu.javeriana.external.services.paywaoint.domain.Status.ERROR.name());
                status.setDescription("Error! there is an error getting validation informations");
                response.setStatus(status);
                
                return CompletableFuture.completedFuture(response);
            }
            status.setCode(co.edu.javeriana.external.services.paywaoint.domain.Status.SUCCESS.name());
            status.setDescription("CreditCardValidation query has been success");
            response.setStatus(status);

            response.setResult(rs.isResult());

            return CompletableFuture.completedFuture(response);

        }catch(Exception e) {
            e.printStackTrace();
            status.setCode(co.edu.javeriana.external.services.paywaoint.domain.Status.ERROR.name());
            status.setDescription(String.format("There is an error getting CreditCard Validation : %s", e.getMessage()));
            response.setStatus(status);

            return CompletableFuture.completedFuture(response);
        }

    }

    @Override
    public CompletableFuture<Response> setChargeCreditCard(Request request) {
        Response response = new Response();
        Status status = new Status();

        try {
            ChargeCreditCardResponseElement rs = this.service.setChargeCreditCard(request);

            if (rs == null) {
                status.setCode(co.edu.javeriana.external.services.paywaoint.domain.Status.ERROR.name());
                status.setDescription("Error! there is an error setting charge creditcard dates");
                response.setStatus(status);

                return CompletableFuture.completedFuture(response);
            }
            status.setCode(co.edu.javeriana.external.services.paywaoint.domain.Status.SUCCESS.name());
            status.setDescription("ChargeCreditCard query has been success");
            response.setStatus(status);
            response.setResult(rs.isResult());

            return CompletableFuture.completedFuture(response);

        }catch(Exception e) {
            e.printStackTrace();
            status.setCode(co.edu.javeriana.external.services.paywaoint.domain.Status.ERROR.name());
            status.setDescription(String.format("There is an error getting CreditCard Validation : %s", e.getMessage()));
            response.setStatus(status);

            return CompletableFuture.completedFuture(response);
        }
    }
}
