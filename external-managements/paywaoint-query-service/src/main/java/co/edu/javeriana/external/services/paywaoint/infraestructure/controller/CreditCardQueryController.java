package co.edu.javeriana.external.services.paywaoint.infraestructure.controller;

import co.edu.javeriana.external.services.paywaoint.application.CreditCardServices;
import co.edu.javeriana.external.services.paywaoint.domain.Status;
import co.edu.javeriana.external.services.paywaoint.dtos.Request;
import co.edu.javeriana.external.services.paywaoint.dtos.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(value="Gestion de pasarela de pagos")
public class CreditCardQueryController {

    private final CreditCardServices service;

    @ApiOperation(value = "Consulta informacion de disponibilidad de pagos", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa de validacion de pagos"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion de pagos"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @PostMapping(value = "/validations")
    public ResponseEntity<Response> creditCardValidationByNumber(@RequestBody(required = true) Request data) throws ExecutionException, InterruptedException, UnknownHostException {

        if (data == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (data.getCreditCard().getNumber().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CompletableFuture<Response> rs = service.getCreditCardValidation(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs.get(), HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs.get(), HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs.get(), HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs.get(), HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Realizar pago", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Efectuar pago de productos toures balon"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion de pagos"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @PostMapping(value = "/charge")
    public ResponseEntity<Response> chargeCreditCard(@RequestBody(required = true) Request data) throws ExecutionException, InterruptedException, UnknownHostException {

        if (data == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (data.getCreditCard().getNumber().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (data.getCreditCard().getMount() == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (data.getCreditCard().getType().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CompletableFuture<Response> rs = service.setChargeCreditCard(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs.get(), HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs.get(), HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs.get(), HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs.get(), HttpStatus.ACCEPTED);
    }
}

