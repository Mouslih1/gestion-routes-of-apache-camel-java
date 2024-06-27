package org.example.gestionroutesofapachecamel.controllers;

import lombok.RequiredArgsConstructor;
import org.example.gestionroutesofapachecamel.dtos.RouteDto;
import org.example.gestionroutesofapachecamel.services.IRouteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/routes")
@RequiredArgsConstructor
public class RouteController {

    private final IRouteService iRouteService;

    @PostMapping
    public ResponseEntity<RouteDto> save(@RequestBody RouteDto routeDto)
    {
        return new ResponseEntity<>(iRouteService.saveRoute(routeDto), HttpStatus.CREATED);
    }

    @PostMapping("/start/{routeId}")
    public ResponseEntity<Void> start(@PathVariable Long routeId) throws Exception
    {
        iRouteService.startRoute(routeId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<String> delete(@PathVariable Long routeId)
    {
        iRouteService.deleteRoute(routeId);
        return new ResponseEntity<>("Route deleted successfully", HttpStatus.OK);
    }

    @PostMapping("/stop/{routeId}")
    public ResponseEntity<Void> stop(@PathVariable Long routeId) throws Exception
    {
        System.out.println("Controller stop method : " + routeId);
        iRouteService.stopRoute(routeId);
        return ResponseEntity.ok().build();
    }
}
