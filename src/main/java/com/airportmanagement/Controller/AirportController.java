package com.airportmanagement.Controller;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.RequestType;
import com.airportmanagement.ProjectUtilities.InputOutput.ResponseService;
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
        return managerAirport.initRequest(new Request<>(RequestType.POST, airport, null));
    }

    @PutMapping
    public ResponseService<Airport> updateAirport(@Valid @NonNull @RequestBody Airport airport) {
        return managerAirport.initRequest(new Request<>(RequestType.PUT, airport, null));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseService<Airport> deleteAirport(@PathVariable("id") Integer id) {
        return managerAirport.initRequest(new Request<>(RequestType.DELETE, null, id));
    }

    @GetMapping(path = "/{id}")
    public ResponseService<Airport> getAirport(@PathVariable("id") Integer id) {
        return managerAirport.initRequest(new Request<>(RequestType.GET, null, id));
    }
}
