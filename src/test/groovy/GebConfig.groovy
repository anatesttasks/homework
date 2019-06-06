
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

driver = { return chromeDriver(false) }

environments {

	chrome {
		driver = { return chromeDriver(false) }
	}

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