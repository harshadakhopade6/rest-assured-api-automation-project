package base;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseAPI {

    protected RequestSpecification requestSpec;

    public BaseAPI() {

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(ConfigReader.getProperty("baseURI"))
                .setContentType("application/json")
                .build();
    }
}