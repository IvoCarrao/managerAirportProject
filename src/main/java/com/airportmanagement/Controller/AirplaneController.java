package com.airportmanagement.Controller;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.RequestType;
import com.airportmanagement.InputOutput.ResponseService;
import com.airportmanagement.Model.Airplane;
import com.airportmanagement.Services.InterfaceManagerAirplane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("airplane")
@RestController
public class AirplaneController {

    private final InterfaceManagerAirplane managerAirplane;

    @Autowired
    public AirplaneController(InterfaceManagerAirplane managerAirplane){
        this.managerAirplane = managerAirplane;
    }

    @PostMapping
    public ResponseService<Airplane> addAirplane(@Valid @NonNull @RequestBody Airplane airplane) {

        Request<Airplane> request = new Request<>(RequestType.POST, airplane, null);
        managerAirplane.setRequest(request);
        return managerAirplane.start();
    }

    @PutMapping
    public ResponseService<Airplane> updateAirplane(@Valid @NonNull @RequestBody Airplane airplane) {

        Request<Airplane> request = new Request<>(RequestType.PUT, airplane, null);
        managerAirplane.setRequest(request);
        return managerAirplane.start();
    }


    @DeleteMapping(path = "/{id}")
    public ResponseService<Airplane> deleteAirplane(@PathVariable("id") Integer id) {

        Request<Airplane> request = new Request<>(RequestType.DELETE, null, id);
        managerAirplane.setRequest(request);
        return managerAirplane.start();
    }

    @GetMapping(path = "/{id}")
    public ResponseService<Airplane> getAirplane(@PathVariable("id") Integer id) {

        Request<Airplane> request = new Request<>(RequestType.GET, null, id);
        managerAirplane.setRequest(request);
        return managerAirplane.start();
    }
}
