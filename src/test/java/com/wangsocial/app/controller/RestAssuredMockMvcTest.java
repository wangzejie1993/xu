package com.wangsocial.app.controller;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.wangsocial.app.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletResponse;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;

/**
 * Created by Lenovo on 2017/6/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class RestAssuredMockMvcTest {

    private static final String HELLO = "/user/selectsql";

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        RestAssuredMockMvc.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void
    getHello() {
        given().
                log().params().
        when().
                get(HELLO).
        then().
                log().all().
                statusCode(HttpServletResponse.SC_OK).
                contentType("application/json");
    }
}
