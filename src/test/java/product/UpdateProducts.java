package product;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateProducts {
	
	String path="/v1/products";
	String id="ccadbbfa-92d2-49b0-ace2-d79c76ac23f1";
	String json_file_path="./src/test/resources/json/updateproduct.json";
	
	@Test
	public void testUpdateProductDetails() throws IOException {
		
		Response response = given().header("content_language", "en-US").contentType("application/json").body(Files.readAllBytes(Paths.get(json_file_path))).when().put(GetURL.readToken()+path+"/"+id);
		JsonPath jsonPathEvaluator = response.jsonPath();
		System.out.println(response.getStatusCode());
		response.getBody().prettyPrint();
		if(response.getStatusCode() == 201) {
			response.getBody().toString().contains(id);
		}
		else if(response.getStatusCode() == 422){
			jsonPathEvaluator.get("name").toString().contains("can't be blank");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
			
	}

}
