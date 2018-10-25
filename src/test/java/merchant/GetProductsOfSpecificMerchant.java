package merchant;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.response.Response;

public class GetProductsOfSpecificMerchant {
	
	String path="/v1/merchants";
	String path_1="/merchant_products?page=1";
	String id="5d4b72cf-1d88-4e7b-a759-b02bb793ae98";
	
	@Test
	public void testGetProductsOfSpecificMerchant() throws IOException {
		Response response = given().get(GetURL.readToken()+path+"/"+id+path_1);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
		response.prettyPrint();
		response.getBody().toString().contains(id);
	}

}
