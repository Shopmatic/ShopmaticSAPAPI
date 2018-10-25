package categories;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FindCategoryNodesByName {
	
	String path = "/find-category-by-name";
	String name="materials";
	
	@Test
	public void testFindCategoryNodeByName() throws IOException {
		Response response = given().
				get(GetURL.readToken()+path+"/"+name);
		response.getBody().prettyPrint();
		
		Assert.assertTrue(response.getStatusCode()==200);
		if(response.getStatusCode() == 200) {
			response.getBody().toString().contains(name);
		}
		else {
			response.getBody().toString().contains("record not found");
		}
	}

}
