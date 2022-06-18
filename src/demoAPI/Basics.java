package demoAPI;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

/*Three principles of Rest Assured. 
  1. Given      // All Input detail
  2. When       // Submit the API  
  3. Then       // Validate response
*/		RestAssured.baseURI= "https://rahulshettyacademy.com";
		given().log().all().queryParam("Key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"President house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "").when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200);
	}

}
