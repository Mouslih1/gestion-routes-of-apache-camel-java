package org.example.gestionroutesofapachecamel.services.impls;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.example.gestionroutesofapachecamel.dtos.RouteDto;
import org.example.gestionroutesofapachecamel.entities.Route;
import org.example.gestionroutesofapachecamel.repositories.IRouteRepository;
import org.example.gestionroutesofapachecamel.services.IRouteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class RouteService implements IRouteService {

    private final IRouteRepository iRouteRepository;
    private CamelContext camelContext;
    private final ModelMapper modelMapper;
    private static final String NOT_FOUNT_ROUTE = "Route not found with this id : ";

    @Override
    public RouteDto saveRoute(RouteDto routeDto)
    {
        Route route =  iRouteRepository.save(modelMapper.map(routeDto, Route.class));
        return modelMapper.map(route, RouteDto.class);
    }

    @Override
    public void deleteRoute(Long id)
    {
        iRouteRepository.deleteById(id);
    }

    @Override
    public void startRoute(Long id) throws Exception
    {
        Route route = iRouteRepository.findById(id).orElseThrow(() -> new RuntimeException(NOT_FOUNT_ROUTE + id));
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure()
            {
                from(route.getFromType() + ":" + route.getFromUrl())
                        .transform()
                        .constant(route.getMessage())
                        .to(route.getToType()+ ":" + route.getToUrl());
            }
        });
        camelContext.getRouteController().startRoute(String.valueOf(route.getId()));
    }
}
