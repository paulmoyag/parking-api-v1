package api.parking;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "parking-api",
                version = "1.0",
                description = "Parking API"))
public class Main {

    public static void main(String[] args) {
        Micronaut.run(Main.class, args);
    }
}
