package page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage {
	private static AdminPage adminPage;
	private AdminPage() {
		
	}
	
	public static AdminPage getInstance() {
		if (adminPage==null)
			adminPage=new AdminPage();
		return adminPage;
	}
	
	//-------------------------------------------------------------------
		
	
	@FindBy(xpath = "//*[@class='oxd-topbar-body-nav-tab-item']")
	private List<WebElement> topmenu;
	
	@FindBy(xpath="//li//li")
	private List<WebElement>subMenu;
	
	
	//-------------------Method-------------------------------------------------
	

	public void clickTopMenu(int i) {
		topmenu.get(i).click();
	}
	
	public void clickSubMenu(int i) {
		subMenu.get(i).click();
	}

}
