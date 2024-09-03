package page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {
	
	private static Header header;
	
	private Header() {
		
	}
	public static Header getInstance() {
		if (header== null) {
			header= new Header();
		}
		return header;
	}
	
	//------------------------------------------------------------
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement ProfileName;

	
	
	//------------------------------------------------------------

	public boolean verifyNameInProfile(String name) {
		String text = ProfileName.getText();
		if(text.equals(name)) {
			return true;
		}
		return false;
		
	}
	
	
	

}
