package com.airportmanagement.Controller;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.InputOutput.Response;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Services.AirportVerifier;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("airport")
@RestController
public class AirportController {

    @PostMapping
    public Response addAirport(@Valid @NonNull @RequestBody Airport airport) {

        Request request = new Request(RequestType.POST, airport, null);
        return new AirportVerifier(request).verifier();
    }

    @PutMapping
    public Response updateAirport(@Valid @NonNull @RequestBody Airport airport) {

        Request request = new Request(RequestType.PUT, airport, null);
        return new AirportVerifier(request).verifier();
    }

    @DeleteMapping(path = "/{id}")
    public Response deleteAirport(@PathVariable("id") Integer id) {

        Request request = new Request(RequestType.DELETE, null, id);
        return new AirportVerifier(request).verifier();
    }

    @GetMapping(path = "/{id}")
    public Response getAirport(@PathVariable("id") Integer id) {

        Request request = new Request(RequestType.GET, null, id);
        return new AirportVerifier(request).verifier();
    }
}
