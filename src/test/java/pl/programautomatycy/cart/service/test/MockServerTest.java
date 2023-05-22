package pl.programautomatycy.cart.service.test;

import static io.restassured.RestAssured.given;
import static org.mockserver.integration.ClientAndServer.startClientAndServer;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Tag;
import org.mockserver.client.MockServerClient;
import pl.programautomatycy.cart.service.test.categories.ImportantTest;
import pl.programautomatycy.cart.service.test.categories.IntegrationTest;

//before execution you can start standalone WireMock server on http://localhost:8080
//according description -> C:\Users\arkadiusz_toczek\OneDrive - Refinitiv\Desktop\Test_frameworks\Wiremock\readme.txt
public class MockServerTest {
  private static MockServerClient mockServerClient;

  @BeforeClass
  public static void startServer()  {
    mockServerClient = startClientAndServer(1080);
    System.out.println(mockServerClient.hasStarted());
  }

  @Test
  @Category(ImportantTest.class)
  public void mockitoTest() {

    System.out.println("Execute runTest1 - ImportantTest");
    System.out.println("Started :" + mockServerClient.hasStarted());
    System.out.println("Port :" + mockServerClient.getPort());

    mockServerClient.when(
            request()
                .withMethod("GET")
                .withPath("/user/1"))
            .respond(
              response()
                .withStatusCode(200)
                .withBody("Hello, world!"));

    mockServerClient.when(
            request()
                .withMethod("GET")
                .withPath("/user/2"))
        .respond(
            response()
                .withStatusCode(200)
                //.withBody("{\"name\": \"Arek\",\"age\": 35}"));
                .withBody("{\"name\": \"Arek\",\"age\": 35, \"positions\":[1,58,9]}"));


    Response response = given()
       .baseUri("http://localhost:1080")
       .get("/user/1");

    response.getBody().prettyPrint();
    System.out.println(response.getStatusCode());


    Response response2 = given()
        .baseUri("http://localhost:1080")
        .get("/user/2");

    System.out.println(response2.getBody().asString());
    System.out.println(response2.getStatusCode());
    JSONObject j = new JSONObject(response2.getBody().asString());
    System.out.println("Name:" + j.get("name"));
    System.out.println("Age:" + j.get("age"));
    System.out.println("positions:" + j.getJSONArray("positions"));
    System.out.println("positions(2):" + j.getJSONArray("positions").get(1));
  }


  @Test
  @Tag("search")
  public void runTest2() {
    System.out.println("Execute runTest2");
  }

  @Test
  @Category(ImportantTest.class)
  public void runTest3() {
    System.out.println("Execute runTest3 - ImportantTest");
  }

  @Test
  @Category(IntegrationTest.class)
  public void runTest4() {
    System.out.println("Execute runTest4 - IntegrationTest");
  }

  @AfterClass
  public static void stopServer()  {
    System.out.println("Running before close: " + mockServerClient.hasStarted());
    mockServerClient.stop();
    System.out.println("Running after close: " + mockServerClient.hasStarted());
  }

}



