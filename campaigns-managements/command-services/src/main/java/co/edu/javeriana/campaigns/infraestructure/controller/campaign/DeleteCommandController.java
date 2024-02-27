package co.edu.javeriana.campaigns.infraestructure.controller.campaign;

import co.edu.javeriana.campaigns.application.campaigns.CampaignCommandService;
import co.edu.javeriana.campaigns.domain.Campaigns;
import co.edu.javeriana.campaigns.domain.Status;
import co.edu.javeriana.campaigns.domain.dtos.campaign.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Api(value="Eliminacion de campanias ofrecidos por toures balon")
public class DeleteCommandController {

    private final CampaignCommandService service;

    @ApiOperation(value = "Eliminacion de campanias en el sistema", response = Response.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Eliminacion exitosa de la campania"),
            @ApiResponse(code = 400, message = "Error en los datos de entrada no se envio informacion de la campania"),
            @ApiResponse(code = 500, message = "Error interno en el servidor, contacte y reporte con el administrador")
    })
    @DeleteMapping("/campaigns")
    public ResponseEntity<CompletableFuture<Response>> handle(@RequestBody Campaigns data) throws ExecutionException, InterruptedException {
        if (data == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        CompletableFuture<Response> rs = service.deleteCampaigns(data);

        if (rs.get().getStatus().equalsIgnoreCase(Status.DELETED.name()))
            return new ResponseEntity<>(rs, HttpStatus.OK);

        if (rs.get().getStatus().equalsIgnoreCase(Status.ERROR.name()))
            return new ResponseEntity<>(rs, HttpStatus.INTERNAL_SERVER_ERROR);

        return new ResponseEntity<>(rs, HttpStatus.CONFLICT);
    }

}
