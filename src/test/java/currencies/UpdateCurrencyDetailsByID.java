package currencies;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateCurrencyDetailsByID {
	
	String path = "/currencies";
	String json_file_path="./src/test/resources/json/currency.json";
	String id="c9f9a388-0802-46ab-b715-196655d52b33";
	
	@Test
	public void testUpdateCurrencyDetailsByID() throws IOException {
		Response response = given().header("content_language", "en-US").contentType("application/json").body(Files.readAllBytes(Paths.get(json_file_path))).when().put(GetURL.readToken()+path+"/"+id);
		JsonPath jsonPathEvaluator = response.jsonPath();
		if(response.getStatusCode() == 200) {
			
		}
		else if(response.getStatusCode() == 422){
			jsonPathEvaluator.get("name").toString().contains("can't be blank");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
			
	}

}
