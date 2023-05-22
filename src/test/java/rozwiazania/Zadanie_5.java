package rozwiazania;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pl.programautomatycy.cart.service.test.ServiceHelper;

public class Zadanie_5 {

    private final ServiceHelper serviceHelper = new ServiceHelper();

    @Test
    public void sampleSolution_1() {

        // Ad 1
        Boolean html = true;

        String endpoint = "/cocart/v1/totals";
        String parameters = "?html=" + html;

        Response response = serviceHelper.sendGetRequest(endpoint + parameters);

        // Ad 2
        response.getBody().prettyPrint();
    }

    @Test
    public void sampleSolution_2() {

        // Ad 1
        String endpoint = "/cocart/v1/totals?html=true";
        Response response = serviceHelper.sendGetRequest(endpoint);

        // Ad 2
        response.getBody().prettyPrint();
    }
}
