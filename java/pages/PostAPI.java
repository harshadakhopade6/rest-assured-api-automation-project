package pages;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;
import models.Post;

public class PostAPI {

    // GET - Single post
    public Response getPostById(int id) {

        return given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/" + id);
    }

    // GET - All posts
    public Response getAllPosts() {

        return given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts");
    }

    // POST - Create post
    public Response createPost(Post post) {

        return given()
                .header("Content-Type", "application/json")
                .body(post)
                .when()
                .post("https://jsonplaceholder.typicode.com/posts");
    }

    // PUT - Update complete post
    public Response updatePost(int id, Post post) {

        return given()
                .header("Content-Type", "application/json")
                .body(post)
                .when()
                .put("https://jsonplaceholder.typicode.com/posts/" + id);
    }

    // PATCH - Update part of post
    public Response patchPost(int id, Post post) {

        return given()
                .header("Content-Type", "application/json")
                .body(post)
                .when()
                .patch("https://jsonplaceholder.typicode.com/posts/" + id);
    }

    // DELETE - Delete post
    public Response deletePost(int id) {

        return given()
                .when()
                .delete("https://jsonplaceholder.typicode.com/posts/" + id);
    }
}