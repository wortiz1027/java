package co.edu.javeriana.external.services.avianca.infraestructure.controller;

import co.edu.javeriana.external.services.avianca.application.FlightsServices;
import co.edu.javeriana.external.services.avianca.domain.StatusEnum;
import co.edu.javeriana.external.services.avianca.dtos.Request;
import co.edu.javeriana.external.services.avianca.dtos.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(value="Gestion de vuelos con el servicio que expone el proveedor avianca airlines")
public class AviancaQueryController {

    private final FlightsServices service;

    @ApiOperation(value = "Consulta de los vuelos de avianca airline", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa de los vuelos disponibles de avianca"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion de los vuelos"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @PostMapping("/flights")
    public ResponseEntity<CompletableFuture<Response>> getFlights(@RequestBody(required = true) Request request) throws ExecutionException, InterruptedException {

        if (request == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CompletableFuture<Response> rs = CompletableFuture.completedFuture(service.getFlights(request));

        if (rs.get().getStatus().getCode().equalsIgnoreCase(StatusEnum.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(StatusEnum.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.OK);
    }
}
