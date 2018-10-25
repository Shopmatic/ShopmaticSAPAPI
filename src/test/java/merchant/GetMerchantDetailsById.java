package merchant;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import io.restassured.response.Response;

public class GetMerchantDetailsById {
	
	String path="/v1/merchants";
	String id="41a66071-82fc-4866-b224-f4acbfb34d0d";
	
	@Test
	public void testGetListOfMerchants() throws IOException {
		Response response = given().get(GetURL.readToken()+path+"/"+id);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
		response.getBody().toString().contains(id);
	}

}
