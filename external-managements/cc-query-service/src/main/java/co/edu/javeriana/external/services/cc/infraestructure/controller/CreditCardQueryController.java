package co.edu.javeriana.external.services.cc.infraestructure.controller;

import co.edu.javeriana.external.services.cc.application.CreditCardServices;
import co.edu.javeriana.external.services.cc.domain.Status;
import co.edu.javeriana.external.services.cc.dtos.Request;
import co.edu.javeriana.external.services.cc.dtos.Response;
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
@Api(value="Gestion de tarjetas de credito de los clientes de toures balon")
public class CreditCardQueryController {

    private final CreditCardServices service;

    @ApiOperation(value = "Consulta informacion de la tarjeta de credito reportada por los clientes de toures balon", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa de tarjeta de credito"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion de la tarjeta de credito reportada"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @GetMapping(value = "/validation/{number}")
    public ResponseEntity<CompletableFuture<Response>> creditCardValidation(@PathVariable String number) throws ExecutionException, InterruptedException, UnknownHostException {

        if (number == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (number.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Request data = new Request();
        data.setNumber(number);

        CompletableFuture<Response> rs = service.getCreditCardValidation(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }
}
