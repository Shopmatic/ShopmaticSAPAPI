package product;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.testng.annotations.Test;

import Utils.GetURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteProduct {
	String path="/v1/products";
	String id="509a1cdf-5a43-4044-8c4a-e93bb699be4e";
	
	@Test
	public void testDeleteProduct() throws IOException {
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
