package product;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.response.Response;

public class GetListOfProductsOfASpecificCategory {
	
	String path="/v1/products";
	String id="53ce2b7e-4713-4d24-bfb8-14cd872c2d1e";
	String path_1="/fetch_products_by_category";
	
	@Test
	public void testGetListOfProductsOfASpecificCategory() throws IOException {
		Response response = given().get(GetURL.readToken()+path+"/"+id+path_1);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		response.getBody().toString().contains(id);
	}

}
