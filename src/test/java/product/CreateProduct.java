package product;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateProduct {
	
	String path="/v1/products";
	
	String json_file_path="./src/test/resources/json/products.json";
	
	@Test
	public void testCreateProduct() throws IOException {
		
		Response response = given().header("content_language", "en-US").contentType("application/json").body(Files.readAllBytes(Paths.get(json_file_path))).when().post(GetURL.readToken()+path);
		JsonPath jsonPathEvaluator = response.jsonPath();
		response.getBody().prettyPrint();
		System.out.println(response.getStatusCode());
		if(response.getStatusCode() == 201) {
			
		}
		else if(response.getStatusCode() == 422){
			jsonPathEvaluator.get("name").toString().contains("can't be blank");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
			
	}

}
