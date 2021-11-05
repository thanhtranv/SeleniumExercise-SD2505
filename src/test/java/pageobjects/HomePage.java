package pageobjects;

import constant.Constant;

public class HomePage extends GeneralPage {
	public void open() {
		Constant.WEBDRIVER.get(Constant.APPLICATION_URL);
	}
}
