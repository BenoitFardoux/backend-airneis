package com.bav.airneisbackend.config.documentation


import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
// ajout la securité
@OpenAPIDefinition(
    info = Info(title = "API projet transversal ",
        version = "v1",
        description = "Documentation de lAPI projet transversal")
)
class SwaggerConfiguration {

    @Bean
    fun api(): GroupedOpenApi {
        return GroupedOpenApi.builder()
            .group("airneis")
            .pathsToMatch("/**")
            .packagesToScan("com.bav")
            .build()
    }
}