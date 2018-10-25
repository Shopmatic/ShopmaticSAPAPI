package product;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.response.Response;

public class GetProductsDetailsByPartnerId {
	
	String path="/v1/products";
	String id="373803";
	String path_1="/partner_product";
	
	@Test
	public void testGetProductsDetailsById() throws IOException {
		Response response = given().get(GetURL.readToken()+path+"/"+id+path_1);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);
		response.getBody().toString().contains(id);
	}

}
