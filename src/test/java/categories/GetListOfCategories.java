package categories;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetListOfCategories {
	
	String path = "/categories";
	
	@Test
	public void testGetListOfCategories() throws IOException {
		Response response = given().
				get(GetURL.readToken()+path);
		
		response.getBody().prettyPrint();
		Assert.assertTrue(response.getStatusCode()==200, "API is failing");
	}
	
	

}
