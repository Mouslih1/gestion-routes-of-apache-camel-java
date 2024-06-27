package org.example.gestionroutesofapachecamel.repositories;

import org.example.gestionroutesofapachecamel.entities.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRouteRepository extends JpaRepository<Route, Long> {

    Route findByRouteUuid(String routeUuid);
}
