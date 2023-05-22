package pl.programautomatycy.cart.service.test;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import pl.programautomatycy.cart.service.test.categories.ImportantTest;
import pl.programautomatycy.cart.service.test.categories.IntegrationTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.instanceOf;



public class A_FirstTest {


    @Test
    @Category(IntegrationTest.class)
    public void myFirstTest() {
        System.out.println("Execute test1 - IntegrationTest");
        assertThat(RestAssured.config(), instanceOf(RestAssuredConfig.class));
    }

    @Test
    @Category(ImportantTest.class)
    public void my2Test() {
        System.out.println("Execute test2 - ImportantTest");
    }

    @Test
    public void my3Test() {
        System.out.println("Execute test3");
        String imie = "Ala";
        Integer wiek = 22;
        String nazwisko = "Toczek";
        // assert
        Assertions.assertAll(
            () -> Assertions.assertTrue(imie.equals("Ala")),
            () -> Assertions.assertTrue(wiek.equals(22)),
            () -> Assertions.assertTrue(nazwisko.equals("Toczek"))
        );
    }

}
