package product_assets;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AddAsset {
	
	String path="/v1/product_assets";
	String id="ccadbbfa-92d2-49b0-ace2-d79c76ac23f1";
	String path_1="/add_asset";
	
	String json_file_path="./src/test/resources/json/addasset.json";
	
	@Test
	public void testAddAsset() throws IOException {
		
		Response response = given().header("content_language", "en-US").contentType("application/json").body(Files.readAllBytes(Paths.get(json_file_path))).when().post(GetURL.readToken()+path+"/"+id+path_1);
		JsonPath jsonPathEvaluator = response.jsonPath();
		response.getBody().prettyPrint();
		System.out.println(response.getStatusCode());
		if(response.getStatusCode() == 200) {
			
		}
		else if(response.getStatusCode() == 422){
			jsonPathEvaluator.get("name").toString().contains("can't be blank");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
			
	}


}
