package merchant;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.response.Response;

public class GetListOfMerchants {
	
	String path="/v1/merchants";
	
	@Test
	public void testGetListOfMerchants() throws IOException {
		Response response = given().get(GetURL.readToken()+path);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
	}

}
