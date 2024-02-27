package co.edu.javeriana.external.services.aa.infraestructure.controller;

import co.edu.javeriana.external.services.aa.application.FlightsServices;
import co.edu.javeriana.external.services.aa.domain.Status;
import co.edu.javeriana.external.services.aa.dtos.flight.Request;
import co.edu.javeriana.external.services.aa.dtos.flight.Response;
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
@Api(value="Gestion de vuelos con el servicio que expone el proveedor american airlines")
public class FlightQueryController {

    private final FlightsServices service;

    @ApiOperation(value = "Consulta detalle de un vuelo de american airline", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa del detalle de un vuelo segun la ciudad"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion de la ciudad"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion del vuelo consultado"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @PostMapping(value = "/flights")
    public ResponseEntity<CompletableFuture<Response>> flight(@RequestBody(required = true) Request data) throws ExecutionException, InterruptedException, UnknownHostException {

        if (data == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (data.getCity().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CompletableFuture<Response> rs = service.getDetailFlight(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

}
