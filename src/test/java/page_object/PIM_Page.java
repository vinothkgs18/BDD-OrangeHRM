package page_object;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.DriverManager;

public class PIM_Page {
	private static PIM_Page pim_Page;

	private PIM_Page() {
	}

	public static PIM_Page getInstance() {
		if (pim_Page == null) {
			pim_Page = new PIM_Page();
		}
		return pim_Page;
	}

	// --------------------------------------------------------------------------------------

	@FindBy(xpath = "//*[@class='oxd-topbar-body-nav-tab-item']")
	private List<WebElement> topmenu;

	@FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")
	private List<WebElement> personDetailLabel;

	@FindBy(xpath = "//p[text()='Successfully Saved']")
	public WebElement successTostMessage;

	@FindBy(xpath = "//div[@class='oxd-loading-spinner-container']")
	public WebElement loadingIcon;

	// ----------------------------------------------------------------------------------------
	public void clickTopMenu(int i) {
		try {
			
		topmenu.get(i).click();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void clickAddEmployeetab() {
		WebDriverWait wait=new WebDriverWait(DriverManager.getDriver(),10);
		
	WebElement until = wait.until(ExpectedConditions.elementToBeClickable(topmenu.get(2)));
	Base.highLightElement(until);
	until.click();
	}

}
