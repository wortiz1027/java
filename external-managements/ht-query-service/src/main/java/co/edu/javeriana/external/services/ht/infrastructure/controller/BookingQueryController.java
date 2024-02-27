package co.edu.javeriana.external.services.ht.infrastructure.controller;

import co.edu.javeriana.external.services.ht.application.BookingService;
import co.edu.javeriana.external.services.ht.dtos.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(value="Gestion de habitaciones hotel hilton")
public class BookingQueryController {
    private final BookingService service;

    @ApiOperation(value = "Consulta informacion y gestion de habitaciones del hotel Hilton", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Consulta exitosa de habitaciones")
    })
    @GetMapping(value = "/bookings")
    public ResponseEntity<Response> get() {
        final Response response = service.booking();
        return new ResponseEntity<>(response, HttpStatus.OK) ;
    }
}
