package pages

import geb.Page

class HomePage extends Page {

	static at = {
		logo.displayed
		topBar.displayed
		queryField.displayed
		calendar.displayed
		languageDropdown.displayed
		countriesMenu.displayed
		linkToHousingPage.displayed
	}

	static content = {
		logo(wait: true) { $("#logo") }
		topBar(wait: true) { $("#topban") }
		queryField(wait: true) { $("#query") }
		calendar(wait: true) { $(".cal") }
		languageDropdown(wait: true) { $("#chlang") }
		languageText(wait:true) { language -> $("#chlang option", text: language) }
		countriesMenu(wait: true) { $(".menu.collapsible") }
		linkToHousingPage(wait: true) { $(".housing #hhh") }
	}

	void clickHousingLink() {
		linkToHousingPage.displayed
		linkToHousingPage.click()
	}

	void chooseLanguage(lang) {
		countriesMenu.click()
		languageText(lang).click()
	}
}
