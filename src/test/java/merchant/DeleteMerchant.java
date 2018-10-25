package merchant;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteMerchant {
	String path="/v1/merchants";
	String id="e4ee440e-7afe-4fae-af71-99071e575efc";
	
	@Test
	public void testDeleteMerchant() throws IOException {
		Response response = given().
				header("content_language", "en-US").contentType("application/json").when().delete(GetURL.readToken()+path+"/"+id);
				
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		if(response.getStatusCode() == 200) {
			jsonPathEvaluator.get("message").toString().contains("successfully deactivated");
		}
		else {
			jsonPathEvaluator.get("message").toString().contains("record not found");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
	}

}
