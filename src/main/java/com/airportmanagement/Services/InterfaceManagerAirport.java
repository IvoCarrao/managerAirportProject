package com.airportmanagement.Services;

import com.airportmanagement.InputOutput.Request;
import com.airportmanagement.InputOutput.ResponseService;
import com.airportmanagement.Model.Airport;


public interface InterfaceManagerAirport {
    void setRequest(Request<Airport> request);

    ResponseService<Airport> start();
}
