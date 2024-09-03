package step_defination;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import util.ExcelUtils;

public class AppachePOI {
	
	@Given("User connected below excel file")
	public void userConnectedBelowExcelFile(io.cucumber.datatable.DataTable dataTable) throws IOException {
	    List<Map<String, String>> asMaps = dataTable.asMaps();
	    String string = asMaps.get(0).get("SheetUrl");
	    ExcelUtils eu= new ExcelUtils();
	    List<Map<String, String>> data = eu.getData(string, "Sheet1");
	    String string2 = data.get(0).get("UserName");
	    System.out.println(" Out put from excel======="+string2);
	}

}
