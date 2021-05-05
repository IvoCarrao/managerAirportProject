package com.airportmanagement.Services;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.ResponseService;
import com.airportmanagement.Model.Airport;


public interface InterfaceManagerAirport {
    ResponseService<Airport> initRequest(Request<Airport> request);
}
