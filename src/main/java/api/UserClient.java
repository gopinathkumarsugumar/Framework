package api;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ConfigReader;

import java.io.IOException;
import java.util.Map;

public class UserClient {

    public static Response sendRequest(Request requestData)
            throws IOException {

        String baseUri = ConfigReader.getProperty("baseUri");
        String token = ConfigReader.getProperty("token");

        RequestSpecification request = RestAssured
                .given()
                .baseUri(baseUri)
                .header("x-api-key", token)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON);

        // Add custom headers
        if (requestData.getHeaders() != null
                && !requestData.getHeaders().isEmpty()) {

            for (Map.Entry<String, Object> header :
                    requestData.getHeaders().entrySet()) {

                request.header(
                        header.getKey(),
                        header.getValue()
                );
            }
        }

        // Add path parameters
        if (requestData.getPathParams() != null
                && !requestData.getPathParams().isEmpty()) {

            request.pathParams(requestData.getPathParams());
        }

        // Add query parameters
        if (requestData.getQueryParams() != null
                && !requestData.getQueryParams().isEmpty()) {

            request.queryParams(requestData.getQueryParams());
        }

        // Add body
        if (requestData.getBody() != null) {
            request.body(requestData.getBody());
        }

        return request
                .when()
                .request(
                        requestData.getMethod(),
                        requestData.getEndpoint()
                )
                .then()
                .extract()
                .response();
    }
}

