package com.qa.apitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetapiBDDframeworkTest {
	@Test
	public void pagedata() {
		given().
		when().
			get("http://ergast.com/api/f1/2017/circuits.json").
		then().
		assertThat().
		statusCode(200).
		
		and().
		
		body("MRData.CircuitTable.Circuits.circuitId", hasSize(20)).
		and().
		header("Content-Length",equalTo("4551"));
		
	}

}
