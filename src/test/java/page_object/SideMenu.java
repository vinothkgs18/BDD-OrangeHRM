package page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideMenu {

	private static SideMenu sideMenu;

	private SideMenu() {
	}

	public static SideMenu getInstance() {
		if (sideMenu == null) {
			sideMenu = new SideMenu();
		}
		return sideMenu;
	}
	
	//----------------------------------------------------------------------
	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	private List<WebElement> sideMenuLink;
	
	//-----------------------------------------------------------------------------
	
	public void clickSideMenuLink(int i) {
		try {
		Base.highLightElement(sideMenuLink.get(i));
		sideMenuLink.get(i).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
