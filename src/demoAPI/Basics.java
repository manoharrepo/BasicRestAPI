package demoAPI;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import files.payload;

public class Basics {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Three principles of Rest Assured. 1. Given // All Input detail 2. When //
		 * Submit the API 3. Then // Validate response
		 */ RestAssured.baseURI = "https://rahulshettyacademy.com";
		String res = given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
				.body(payload.AddPlace()).when().post("maps/api/place/add/json").then().assertThat().statusCode(200)
				.body("scope", equalTo("APP")).header("Server", "Apache/2.4.41 (Ubuntu)").extract().response()
				.asString();
		System.out.println(res);
		JsonPath js = new JsonPath(res); // parse json
		String placeid = js.getString("place_id");
		System.out.println(placeid);

		String newadd = "70 Summer walk, USA";
		given().log().all().queryParam("Key", "qaclick123").header("Content-Type", "application/json")
				.body("{\r\n" + "\"place_id\":\"" + placeid + "\",\r\n" + "\"address\":\"" + newadd + "\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.when().put("maps/api/place/update/json").then().log().all().assertThat().statusCode(200)
				.body("msg", equalTo("Address successfully updated"));

		String aa = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeid).when()
				.get("maps/api/place/get/json").then().log().all().extract().response().body().asString();
		System.out.println(aa);
		JsonPath js1 = rawjson.rawtojson(aa); // parse json
		String actualaddress = js1.getString("address");
		System.out.println(actualaddress);
		Assert.assertEquals(actualaddress, newadd);
	}

}
