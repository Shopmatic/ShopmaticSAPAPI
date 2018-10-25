package categories;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.response.Response;

public class FindCategoryNodesById {
	
	String path = "/find-category-nodes";
	String id="6919de33-6b47-4161-9b26-2bde6f60dae0";
	
	@Test
	public void testFindCategoryNodeById() throws IOException {
		System.out.println(GetURL.readToken()+path+"/"+id);
		Response response = given().
				get(GetURL.readToken()+path+"/"+id);
		response.getBody().prettyPrint();
		Assert.assertTrue(response.getStatusCode()==200);
		}

}
