package com.airportmanagement.Controller;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.InputOutput.Response;
import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Services.AirplaneVerifier;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("airplane")
@RestController
public class AirplaneController {

    @PostMapping
    public Response addAirplane(@Valid @NonNull @RequestBody Airplane airplane) {

        Request request = new Request(RequestType.POST, airplane, null);
        return new AirplaneVerifier(request).verifier();
    }

    @PutMapping
    public Response updateAirplane(@Valid @NonNull @RequestBody Airplane airplane) {

        Request request = new Request(RequestType.PUT, airplane, null);
        return new AirplaneVerifier(request).verifier();
    }


    @DeleteMapping(path = "/{id}")
    public Response deleteAirplane(@PathVariable("id") Integer id) {

        Request request = new Request(RequestType.DELETE, null, id);
        return new AirplaneVerifier(request).verifier();
    }

    @GetMapping(path = "/{id}")
    public Response getAirplane(@PathVariable("id") Integer id) {

        Request request = new Request(RequestType.GET, null, id);
        return new AirplaneVerifier(request).verifier();
    }
}
