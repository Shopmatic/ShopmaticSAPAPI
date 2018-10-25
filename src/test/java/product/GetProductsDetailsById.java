package product;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.response.Response;

public class GetProductsDetailsById {
	
	String path="/v1/products";
	String id="509a1cdf-5a43-4044-8c4a-e93bb699be4e";
	
	@Test
	public void testGetProductsDetailsById() throws IOException {
		Response response = given().get(GetURL.readToken()+path+"/"+id);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		response.getBody().toString().contains(id);
	}

}
