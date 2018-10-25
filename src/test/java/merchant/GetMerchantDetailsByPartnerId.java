package merchant;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.response.Response;

public class GetMerchantDetailsByPartnerId {
	
	String path="/v1/merchants";
	String id="108920";
	String path_1="/partner_merchant";
	
	@Test
	public void testGetMerchantDetailsByPartnerId() throws IOException {
		Response response = given().get(GetURL.readToken()+path+"/"+id+path_1);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
		response.getBody().toString().contains(id);
	}

}
