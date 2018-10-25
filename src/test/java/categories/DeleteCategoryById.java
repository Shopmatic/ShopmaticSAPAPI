package categories;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.response.Response;

public class DeleteCategoryById {
	
	String path = "/categories";
	String id="8ae4a96c-55f2-406e-993c-d20d95897c7a";
	
	@Test
	public void testDeleteCategoryById() throws IOException {
		Response response = given().
				header("content_language", "en-US").contentType("application/json").when().delete(GetURL.readToken()+path+"/"+id);
		response.getBody().prettyPrint();
		Assert.assertTrue(response.getStatusCode() == 200);		
		if(response.getStatusCode() == 200) {
			response.getBody().toString().contains("successfully deactivated");
		}
		else {
			response.getBody().toString().contains("record not found");
		}
	}

}
