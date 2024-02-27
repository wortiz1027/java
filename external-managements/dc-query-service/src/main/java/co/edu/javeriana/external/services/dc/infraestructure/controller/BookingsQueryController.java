package co.edu.javeriana.external.services.dc.infraestructure.controller;

import co.edu.javeriana.external.services.dc.application.BookingServices;
import co.edu.javeriana.external.services.dc.domain.Codes;
import co.edu.javeriana.external.services.dc.dtos.all.Request;
import co.edu.javeriana.external.services.dc.dtos.all.Response;
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
@Api(value="Gestion de habitaciones dan carlton")
public class BookingsQueryController {

    private static final Logger LOG = LoggerFactory.getLogger(BookingsQueryController.class);
    private final BookingServices service;

    @ApiOperation(value = "Consulta informacion y gestion de habitaciones del hotel dan carlton por descripcion", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa de habitaciones"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion de habitaciones"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @GetMapping(value = "/bookings/{text}")
    public ResponseEntity<CompletableFuture<Response>> reservas(@PathVariable(required = true) String text) throws ExecutionException, InterruptedException, UnknownHostException {

        Request data = new Request();
        data.setKey(text);

        if (data == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (data.getKey().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CompletableFuture<Response> rs = this.service.getAllBookings(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

    @ApiOperation(value = "Consulta informacion y gestion de habitaciones del hotel dan carlton por codigo", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa de la habitacione"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion"),
            @ApiResponse(code = 404, message = "Error no se encontro informacion de la habitacion"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @PostMapping(value = "/bookings/code")
    public ResponseEntity<CompletableFuture<co.edu.javeriana.external.services.dc.dtos.code.Response>> codigo(@RequestBody(required = true) co.edu.javeriana.external.services.dc.dtos.code.Request data) throws ExecutionException, InterruptedException, UnknownHostException {

        if (data == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (data.getCode().isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        CompletableFuture<co.edu.javeriana.external.services.dc.dtos.code.Response> rs = this.service.getBookingsByCode(data);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.SUCCESS.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.EMPTY.name()))
            return new ResponseEntity<>(rs, HttpStatus.NOT_FOUND);

        if (rs.get().getStatus().getCode().equalsIgnoreCase(Codes.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.ACCEPTED);
    }

}
