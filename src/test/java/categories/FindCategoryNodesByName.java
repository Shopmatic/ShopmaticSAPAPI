package categories;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FindCategoryNodesByName {
	
	String url = "https://api.myshopmaticbeta.com/find-category-by-name";
	String name="materials";
	
	@Test
	public void testFindCategoryNodeByName() {
		Response response = given().
				get(url+"/"+name);
		
		JsonPath jsonPathEvaluator = response.jsonPath();
		if(response.getStatusCode() == 200) {
			jsonPathEvaluator.get("name").toString().contains(name);
		}
		else {
			jsonPathEvaluator.get("message").toString().contains("record not found");
		}
		System.out.println("------------------- JSON Response -------------------\n"+jsonPathEvaluator.get("")+"\n-------------------  -------------------\n");
	}

}
