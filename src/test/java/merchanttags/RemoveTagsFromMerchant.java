package merchanttags;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RemoveTagsFromMerchant {
	
	String path="/v1/add-merchant-tag";
	String id="cd524adf-556a-4dbd-9007-b21334b0b09d";
	
	String json_file_path="./src/test/resources/json/tags.json";
	
	@Test
	public void testAddNewTagsToMerchant() throws IOException {
		
		Response response = given().header("content_language", "en-US").contentType("application/json").body(Files.readAllBytes(Paths.get(json_file_path))).when().delete(GetURL.readToken()+path+"/"+id);		
		if(response.getStatusCode() == 200) {
			response.getBody().prettyPrint();
		}
		
		
	}


}
