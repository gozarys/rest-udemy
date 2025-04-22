package org.agoncal.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;


@QuarkusTest
class BookResourceTest {

    @Test
    public void testgetAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON).
        when()
            .get("/api/books").
        then()
            .statusCode(200)
            .body("size()", is(4));
    }

    @Test
    public void testcountAllBooks() {
        given().header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
        when()
            .get("/api/books/count").
        then()
            .statusCode(200)
            .body(is("4"));
    }

    @Test
    public void testgetBookById() {
        given().header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .pathParam("id", 1).
        when()
            .get("/api/books/{id}").
        then()
            .statusCode(200)
            .body("id", is(1))
            .body("title", is("quarkus"))
            .body("author", is("Antonio"))
            .body("yearOfPublication", is(2020))
            .body("genre", is("IT"));
    }

}