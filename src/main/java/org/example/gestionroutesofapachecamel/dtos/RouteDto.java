package org.example.gestionroutesofapachecamel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private Long id;
    private String fromType;
    private String toType;
    private String routeUuid;
    private String fromUrl;
    private String toUrl;
    private String message;
    private LocalDateTime createdAt;
}
