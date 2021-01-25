package com.airportmanagement.Controller;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.InputOutput.ResponseService;
import com.airportmanagement.Model.Airport;
import com.airportmanagement.Services.InterfaceManagerAirport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("airport")
@RestController
public class AirportController {

    private final InterfaceManagerAirport managerAirport;

    @Autowired
    public AirportController(InterfaceManagerAirport managerAirport) {
        this.managerAirport = managerAirport;
    }

    @PostMapping
    public ResponseService<Airport> addAirport(@Valid @NonNull @RequestBody Airport airport) {
        Request<Airport> request = new Request<>(RequestType.POST, airport, null);
        managerAirport.setRequest(request);
        return managerAirport.start();
    }

    @PutMapping
    public ResponseService<Airport> updateAirport(@Valid @NonNull @RequestBody Airport airport) {

        Request<Airport> request = new Request<>(RequestType.PUT, airport, null);
        managerAirport.setRequest(request);
        return managerAirport.start();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseService<Airport> deleteAirport(@PathVariable("id") Integer id) {

        Request<Airport> request = new Request<>(RequestType.DELETE, null, id);
        managerAirport.setRequest(request);
        return managerAirport.start();
    }

    @GetMapping(path = "/{id}")
    public ResponseService<Airport> getAirport(@PathVariable("id") Integer id) {

        Request<Airport> request = new Request<>(RequestType.GET, null, id);
        managerAirport.setRequest(request);
        return managerAirport.start();
    }
}
