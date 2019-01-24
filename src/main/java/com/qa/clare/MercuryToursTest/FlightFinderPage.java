package com.qa.clare.MercuryToursTest;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightFinderPage {

	
	
	@FindBy(xpath = "/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[1]/td/font/font/b/font/font")
	private WebElement flightDetails;

	
	public String flightPageConfirmation() {
		
		
		return flightDetails.getText();
		
	}
	
	
}
