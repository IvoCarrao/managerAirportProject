package com.airportmanagement.Controller;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.RequestType;
import com.airportmanagement.ProjectUtilities.InputOutput.ResponseService;
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
        return managerAirplane.initRequest(new Request<>(RequestType.POST, airplane, null));
    }

    @PutMapping
    public ResponseService<Airplane> updateAirplane(@Valid @NonNull @RequestBody Airplane airplane) {
        return managerAirplane.initRequest(new Request<>(RequestType.PUT, airplane, null));
    }


    @DeleteMapping(path = "/{id}")
    public ResponseService<Airplane> deleteAirplane(@PathVariable("id") Integer id) {
        return managerAirplane.initRequest(new Request<>(RequestType.DELETE, null, id));
    }

    @GetMapping(path = "/{id}")
    public ResponseService<Airplane> getAirplane(@PathVariable("id") Integer id) {
        return managerAirplane.initRequest(new Request<>(RequestType.GET, null, id));
    }
}
