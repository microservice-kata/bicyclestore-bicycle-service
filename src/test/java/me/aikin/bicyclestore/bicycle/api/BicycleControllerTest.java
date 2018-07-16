package me.aikin.bicyclestore.bicycle.api;


import org.junit.jupiter.api.Test;

public class BicycleControllerTest extends ApiBaseTest {

    @Test
    public void should_can_get_bicycles() {
        given().
        when()
            .get("/api/bicycles")
        .then()
            .statusCode(200);
    }

}
