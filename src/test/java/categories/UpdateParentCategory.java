package categories;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UpdateParentCategory {
	
	String path = "/categories";
	String json_file_path="./src/test/resources/json/parentcategory.json";
	String id = "0d24664b-ce50-4424-84f4-bd162f15b29e";
	
	@Test
	public void testUpdateParentCategory() throws IOException {
		Response response = given().header("content_language", "en-US").contentType("application/json").body(Files.readAllBytes(Paths.get(json_file_path))).when().put(GetURL.readToken()+path+"/"+id);
		
		if(response.getStatusCode() == 200) {
			response.getBody().prettyPrint();
		}
		else if(response.getStatusCode() == 422){
			response.getBody().toString().contains("can't be blank");
		}
			
	}
	
	

}
