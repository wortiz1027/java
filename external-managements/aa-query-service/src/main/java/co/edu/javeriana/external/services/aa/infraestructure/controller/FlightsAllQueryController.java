package co.edu.javeriana.external.services.aa.infraestructure.controller;

import co.edu.javeriana.external.services.aa.application.FlightsServices;
import co.edu.javeriana.external.services.aa.domain.Status;
import co.edu.javeriana.external.services.aa.dtos.all.Request;
import co.edu.javeriana.external.services.aa.dtos.all.Response;
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
@Api(value="Consulta de vuelos con el servicio que expone el proveedor american airlines")
public class FlightsAllQueryController {

    private final FlightsServices service;

    @ApiOperation(value = "Consulta de los vuelos disponibles de american airline", response = co.edu.javeriana.external.services.aa.dtos.flight.Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa de los vuelos de american airlines"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio el request"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion de los vuelos disponibles"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @GetMapping(value = "/flights/{availables}")
    public ResponseEntity<CompletableFuture<Response>> all(@PathVariable String availables) throws ExecutionException, InterruptedException, UnknownHostException {

        if (availables == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (availables.isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Request data = new Request();
        data.setAvailable(availables);

        CompletableFuture<Response> rs = service.getAllFlights(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

}
