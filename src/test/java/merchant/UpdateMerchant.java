package merchant;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateMerchant {
	
	String path="/v1/merchants";
	String id="5d4b72cf-1d88-4e7b-a759-b02bb793ae98";
	String json_file_path="./src/test/resources/json/updatemerchant.json";
	
	@Test
	public void testUpdateMerchantDetails() throws IOException {
		
		Response response = given().header("content_language", "en-US").contentType("application/json").body(Files.readAllBytes(Paths.get(json_file_path))).when().put(GetURL.readToken()+path+"/"+id);
		JsonPath jsonPathEvaluator = response.jsonPath();
		response.getBody().prettyPrint();
		if(response.getStatusCode() == 200) {
			response.getBody().toString().contains(id);
		}
		else if(response.getStatusCode() == 422){
			jsonPathEvaluator.get("name").toString().contains("can't be blank");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
			
	}

}
