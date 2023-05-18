package com.CashCall.HR;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Cashcall HR System",
                version = "1.0.0",
                description = "This Project is Only for Learning!",
                termsOfService = "AhmedAmeen",
                contact = @Contact(
                        name = "Ahmed Ameen",
                        email = "ahmed.ameen@cashcall.com.eg"
                ),
                license = @License(
                        name = "Licences",
                        url = "www.ameen.com"
                )
        )
)
//@ComponentScan("") // If you changed the default Path to the App Components, you must specify the new path.
public class HrApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrApplication.class, args);
    }

}



/*
 *
 * App Layers:
 * - Data Access Layer: Repository Layer
 * - Business logic Layer: Service Layer
 * - Presentational Layer: Controller
 *
 *
 * Controller => Service => Repository => Model (DB Representation).
 *
 * DB Representation
 *
 *  App Properties:
 * - Properties File => application.properties
 * - YAML File => application.yml
 * - Externalized Properties
 * (-Dspring.config.location=C:application.properties)
 * - Use of @Value
 * - Spring Boot Active profile:
 *      -- application.properties & application-prod.properties
 *      -- application-dev.properties & application-test.properties
 *      -- application-pre-prod.properties
 *
 *
 * */