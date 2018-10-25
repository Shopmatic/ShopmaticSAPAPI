package merchanttags;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.response.Response;

public class FetchAllMerchantCategorizedIntoSpecificTags {
	
	String path="/v1/fetch-by-tag";
	String tag="artisanal";
	
	@Test
	public void testFetchAllMerchantCategorizedIntoSpecificTags() throws IOException {
		Response response = given().get(GetURL.readToken()+path+"/"+tag);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.prettyPrint();
		response.getBody().toString().contains(tag);
	}

}
