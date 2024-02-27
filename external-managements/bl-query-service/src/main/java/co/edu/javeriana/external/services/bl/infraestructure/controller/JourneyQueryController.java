package co.edu.javeriana.external.services.bl.infraestructure.controller;

import co.edu.javeriana.external.services.bl.application.JourneyServices;
import co.edu.javeriana.external.services.bl.domain.Codes;
import co.edu.javeriana.external.services.bl.dtos.Request;
import co.edu.javeriana.external.services.bl.dtos.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(value="Gestion de sillas de bolivariano express")
public class JourneyQueryController {

    private static final Logger LOG = LoggerFactory.getLogger(JourneyQueryController.class);
    private final JourneyServices service;

    @ApiOperation(value = "Consulta de las sillas disponibles en viajes de bolivariano express", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa de sillas disponibles de bolivariano"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion de sillas disponibles de bolivariano"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @PostMapping(value = "/journeys")
    public ResponseEntity<CompletableFuture<Response>> journeys(@RequestBody(required = true) Request data) throws ExecutionException, InterruptedException, UnknownHostException {

        if (data == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (data.getKey().isEmpty()) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CompletableFuture<Response> rs = this.service.getJourneys(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

}
