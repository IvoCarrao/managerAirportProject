package com.airportmanagement.Services;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.ResponseService;
import com.airportmanagement.Model.Airplane;

public interface InterfaceManagerAirplane {

    void setRequest(Request<Airplane> request);

    ResponseService<Airplane> start();
}
