package com.airportmanagement.Services;

import com.airportmanagement.ProjectUtilities.InputOutput.Request;
import com.airportmanagement.ProjectUtilities.InputOutput.ResponseService;
import com.airportmanagement.Model.Airplane;

public interface InterfaceManagerAirplane {

    ResponseService<Airplane> initRequest(Request<Airplane> request);
}
