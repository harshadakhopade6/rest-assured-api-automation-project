
package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import models.Post;
import pages.PostAPI;

public class PostTests {

    private PostAPI postAPI;

    @BeforeClass
    public void setUp() {
        postAPI = new PostAPI();
    }

    // GET - Get post by ID
    @Test
    public void getPostByIdTest() {

        Response response = postAPI.getPostById(1);

        Assert.assertEquals(
                response.statusCode(), 200,
                "Failed to retrieve post by ID"
        );

        Assert.assertEquals(
                response.jsonPath().getInt("id"), 1,
                "Post ID does not match"
        );

        Assert.assertEquals(
                response.jsonPath().getInt("userId"), 1,
                "User ID does not match"
        );

        Assert.assertNotNull(
                response.jsonPath().getString("title"),
                "Post title should not be null"
        );
    }

    // GET - Get all posts
    @Test
    public void getAllPostsTest() {

        Response response = postAPI.getAllPosts();

        Assert.assertEquals(
                response.statusCode(), 200,
                "Failed to retrieve all posts"
        );

        Assert.assertTrue(
                response.jsonPath().getList("$").size() > 0,
                "Posts list should not be empty"
        );
    }

    // POST - Create a new post
    @Test
    public void createPostTest() {

        Post post = new Post();

        post.setUserId(1);
        post.setTitle("API Automation");
        post.setBody("Creating API automation framework");

        Response response = postAPI.createPost(post);

        Assert.assertEquals(
                response.statusCode(), 201,
                "Post creation failed"
        );

        Assert.assertEquals(
                response.jsonPath().getInt("userId"), 1
        );

        Assert.assertEquals(
                response.jsonPath().getString("title"),
                "API Automation"
        );

        Assert.assertEquals(
                response.jsonPath().getString("body"),
                "Creating API automation framework"
        );
    }

    // PUT - Update the complete post
    @Test
    public void updatePostTest() {

        Post post = new Post();

        post.setUserId(1);
        post.setTitle("Updated API Automation");
        post.setBody("Updated complete post");

        Response response = postAPI.updatePost(1, post);

        Assert.assertEquals(
                response.statusCode(), 200,
                "Post update failed"
        );

        Assert.assertEquals(
                response.jsonPath().getString("title"),
                "Updated API Automation"
        );

        Assert.assertEquals(
                response.jsonPath().getString("body"),
                "Updated complete post"
        );
    }

    // PATCH - Update part of the post
    @Test
    public void patchPostTest() {

        Post post = new Post();

        post.setTitle("Patched API Automation");

        Response response = postAPI.patchPost(1, post);

        Assert.assertEquals(
                response.statusCode(), 200,
                "Partial post update failed"
        );

        Assert.assertEquals(
                response.jsonPath().getString("title"),
                "Patched API Automation"
        );
    }

    // DELETE - Delete a post
    @Test
    public void deletePostTest() {

        Response response = postAPI.deletePost(1);

        Assert.assertEquals(
                response.statusCode(), 200,
                "Post deletion failed"
        );
    }
}