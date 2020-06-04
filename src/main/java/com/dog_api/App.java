package com.dog_api;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static org.hamcrest.Matchers.*;

/**
 * Hello world!
 *
 */
public class App 
{
   @Test
    public void saveAnImgFavourite(){
       String url = "https://api.thedogapi.com/v1/favourites";
       String json = "{\"image_id\": \"CY4hi0izf\"}";
       String apiKey = "21c614d6-aafe-48f2-ba5b-7cd6b5b78ad6";

       Response response  = RestAssured
               .given().contentType(ContentType.JSON).header("x-api-key", apiKey).body(json)
               .when().post(url);
       System.out.println(response);
       System.out.println(response.body());
       System.out.println(response.body().asString());
       response.then().statusCode(200).body("message", containsString("SUCCESS"));
   }
}