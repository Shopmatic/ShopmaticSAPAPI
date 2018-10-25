package categories;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FindCategoryNodesById {
	
	String url = "https://api.myshopmaticbeta.com/find-category-nodes";
	String id="6919de33-6b47-4161-9b26-2bde6f60dae0";
	
	@Test
	public void testFindCategoryNodeById() {
		Response response = given().
				get(url+"/"+id);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		if(response.getStatusCode() == 200) {
			jsonPathEvaluator.get("id").toString().contains(id);
		}
		else {
			jsonPathEvaluator.get("message").toString().contains("record not found");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
	}

}
