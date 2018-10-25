package partner;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeletePartner {
	
	String path="/v1/partners";
	String id="574312ca-bf76-4ab3-bd4a-5dedcdb5dc28";
	
	@Test
	public void testDeletePartner() throws IOException {
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
