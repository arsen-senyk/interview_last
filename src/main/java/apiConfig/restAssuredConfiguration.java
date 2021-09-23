package apiConfig;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

public abstract class restAssuredConfiguration {

    public static RequestSpecification requestSpecification;

    public static void setUp() {
        requestSpecification = new RequestSpecBuilder()
                .setContentType("application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();


        RestAssured.requestSpecification = requestSpecification;
    }
}