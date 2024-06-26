package org.example.gestionroutesofapachecamel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RouteDto {

    private Long id;
    private String fromType;
    private String toType;
    private String fromUrl;
    private String toUrl;
    private String message;
}
