package categories;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetCategoryById {
	
	String path = "/categories";
	String id="53ce2b7e-4713-4d24-bfb8-14cd872c2d1e";
	
	@Test
	public void testFindCategoryId() throws IOException {
		Response response = given().
				get(GetURL.readToken()+path+"/"+id);
		response.getBody().prettyPrint();
		
		if(response.getStatusCode() == 200) {
			response.getBody().toString().contains(id);
		}
		else {
			response.getBody().toString().contains("record not found");
		}
	}

}
