/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

driver = { return chromeDriver(false) }

environments {

	// run as “./gradlew -Dgeb.env=chrome cucumber”
	chrome {
		driver = { return chromeDriver(false) }
	}

	// run as “./gradlew -Dgeb.env=chromeHeadless cucumber”
	chromeHeadless {
		driver = { return chromeDriver(true) }
	}

}

def chromeDriver(boolean headless) {
	ChromeOptions chromeOptions = new ChromeOptions()
	if (headless) chromeOptions.addArguments("--headless")
	new ChromeDriver(chromeOptions)
}

baseUrl = "https://helsinki.craigslist.org/"

baseNavigatorWaiting = true
atCheckWaiting = true