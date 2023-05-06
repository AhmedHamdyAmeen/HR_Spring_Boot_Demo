package com.CashCall.HR;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
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
 *
 *
 *
 *
 *
 * */