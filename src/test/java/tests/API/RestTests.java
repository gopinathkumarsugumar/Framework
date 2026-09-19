package tests.API;

import api.Endpoints;
import api.Request;
import api.UserClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RestTests {
    @Test()
    public void testGetRequest() throws IOException {

        Request request = new Request(
                Endpoints.collections,
                "GET"
        );

        Response response = UserClient.sendRequest(request);
        System.out.println(response.prettyPrint());
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test()
    public void testPostRequest() throws IOException {

        Map<String, Object> data = new HashMap<>();
        data.put("year", 2019);
        data.put("price", 1849.99);
        data.put("CPU model", "Intel Core i9");
        data.put("Hard disk size", "1 TB");

        Map<String, Object> product = new HashMap<>();
        product.put("name", "Apple MacBook Pro 16");
        product.put("data", data);

        Request request = new Request(
                Endpoints.createNewCollectionName,
                "POST"
        ).body(data).pathParam("collectionName","AppleMBP16");

        Response response = UserClient.sendRequest(request);
        Assert.assertEquals(response.statusCode(), 200);

    }
}
