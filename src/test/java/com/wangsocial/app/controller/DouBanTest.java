package com.wangsocial.app.controller;

import static com.jayway.restassured.RestAssured.get;

import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

/**
 * Created by Lenovo on 2017/6/20.
 */
public class DouBanTest {
    @Before
    public void setUP() {
        //指定 URL 和端口号
        RestAssured.baseURI = "http://api.douban.com/v2/book";
        RestAssured.port = 80;
    }

    @Test
    public void testGETBook() {
//        get("/1220562").then().body("title", equalTo("满月之夜白鲸现"));
        get("/1220562").jsonPath().prettyPrint();
    }

}
