package env

import org.openqa.selenium.OutputType

import static cucumber.api.groovy.Hooks.*

import geb.Browser
import geb.binding.BindingUpdater


def bindingUpdater
def theBrowser

Before { scenario ->
	if(!binding.hasVariable('browser')) {
		theBrowser = new Browser()
		bindingUpdater = new BindingUpdater(binding, theBrowser)
		bindingUpdater.initialize()
	}
}

After { scenario ->
	if(scenario.failed) {
		def driver = page.driver
		scenario.write(driver.currentUrl)
		scenario.embed(driver.getScreenshotAs(OutputType.BYTES), "image/png")
	}
	bindingUpdater?.remove()
}