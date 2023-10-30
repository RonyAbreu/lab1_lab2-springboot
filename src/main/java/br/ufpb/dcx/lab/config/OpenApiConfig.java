package br.ufpb.dcx.lab.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
        @Bean
        public OpenAPI openAPI(){
                return new OpenAPI()
                        .info(info())
                        .addSecurityItem(new SecurityRequirement()
                                .addList("Bearer Authentication"))
                        .components(new Components().addSecuritySchemes("Bearer Authentication",securityScheme()));
        }

        private SecurityScheme securityScheme(){
                return new SecurityScheme()
                        .type(SecurityScheme.Type.HTTP)
                        .bearerFormat("JWT")
                        .scheme("bearer");
        }

        private Info info(){
                return new Info()
                        .title("API RESTful sobre uma Rede social de Disciplinas")
                        .description("API feita em Java 17 e Spring Boot 3")
                        .version("V1")
                        .termsOfService("terms")
                        .license(new License()
                                .name("License")
                                .url("license.com"));
        }


}
