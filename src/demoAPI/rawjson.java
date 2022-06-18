package demoAPI;
import io.restassured.path.json.JsonPath;

public class rawjson {

	public static JsonPath rawtojson(String aa) {
		 JsonPath js1 = new JsonPath(aa);
		return js1;
	}
}
