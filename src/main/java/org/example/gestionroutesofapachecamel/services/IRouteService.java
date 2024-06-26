package org.example.gestionroutesofapachecamel.services;

import org.example.gestionroutesofapachecamel.dtos.RouteDto;

public interface IRouteService {

    RouteDto saveRoute(RouteDto routeDto);
    void deleteRoute(Long id);
    void startRoute(Long id) throws Exception;
}
