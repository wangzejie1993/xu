package com.wangsocial.app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.jayway.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest2 {

    @LocalServerPort
    int port;

    @Test
    public void getUserBySql() throws Exception {
        given().port(port).
                when().log().all().
                get("/user/selectsql").jsonPath().prettyPrint();
    }

}