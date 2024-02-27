package co.edu.javeriana.bpm.infraestructure.controller;

import co.edu.javeriana.bpm.application.BPMServices;
import co.edu.javeriana.bpm.domain.Status;
import co.edu.javeriana.bpm.dtos.Request;
import co.edu.javeriana.bpm.dtos.Response;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(value="Controlador que se encargará de los inicios de instancia del proceso de gestión de ordenes de TouresBalon.")
public class BPMQueryController {
    private final BPMServices service;

    @PostMapping(value = "/instance")
    @ApiOperation(value = "Esta operación se encargaráa de invocar al punto de inicio del proceso de gestión de ordenes del BPM.", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La instancia fue lanzada satisfactoriamente"),
            @ApiResponse(code = 404, message = "Error no se pudo lanzar una instancia de gestión de ordenes"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    public ResponseEntity<CompletableFuture<Response>> init(@ApiParam("Información requerida para un inicio de instancia de proceso.")
                                                            @RequestBody(required = true) Request data) throws ExecutionException, InterruptedException, UnknownHostException {

        if (data == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (data.getNumeroSolicitud().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CompletableFuture<Response> rs = service.getInstanciaBPM(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/cancel")
    @ApiOperation(value = "Esta operación se encargará de cancelar la orden correspondiente.", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "La instancia fue cancelada satisfactoriamente"),
            @ApiResponse(code = 404, message = "Error no se pudo cancelar una instancia de gestión de ordenes"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    public ResponseEntity<CompletableFuture<Response>> cancel(@ApiParam("Información requerida para cacelar una instancia de proceso.")
                                                              @RequestBody(required = true) Request data) throws ExecutionException, InterruptedException, UnknownHostException {

        if (data == null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (data.getNumeroSolicitud().isEmpty())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CompletableFuture<Response> rs = service.getCancelarBPM(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

}
