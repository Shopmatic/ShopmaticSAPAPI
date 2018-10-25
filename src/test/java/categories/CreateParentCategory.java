package categories;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.response.Response;

public class CreateParentCategory {
	
	String path = "/categories";
	String json_file_path="./src/test/resources/json/parentcategory.json";
	
	@Test
	public void testCreateParentCategory() throws IOException {
		Response response = given().header("content_language", "en-US").contentType("application/json").body(Files.readAllBytes(Paths.get(json_file_path))).when().post(GetURL.readToken()+path);
		response.getBody().prettyPrint();
		if(response.getStatusCode() == 422){
			response.getBody().toString().contains("can't be blank");
		}			
	}
	
	

}
