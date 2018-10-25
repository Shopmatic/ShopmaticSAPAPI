package product;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.response.Response;

public class GetListOfProducts {
	
	String path="/v1/products";
	
	@Test
	public void testGetListOfProducts() throws IOException {
		Response response = given().get(GetURL.readToken()+path);
		response.prettyPrint();
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
