package steps

import io.cucumber.datatable.DataTable
import pages.HomePage
import pages.HousingPage

import static cucumber.api.groovy.EN.*


Given(~'^guest is on Home page$') { ->
	to HomePage
}

When(~'^guest clicks on Housings link$') { ->
	page.clickHousingLink()
}

Then(~'^Housing page should open$') { ->
	at HousingPage
}

Then(~'^the following sorting types are available:$') { DataTable dataTable->
	page.checkSortingTypes(dataTable.asList(String))
}

When(~'^guest chooses an (.*) as UI language$') { String language ->
	page.chooseLanguage(language)
}

When(~'^guest searches for Housing offers by (.*)$') { String param ->
	page.searchHousingsByParam(param)
}

When(~'^guest enables sorting by (.*)$') { String type ->
	page.sortRecordsBySortingType(type)
}

Then(~'^all records are sorted by (.*)$') { String type ->
	page.checkRecordsSortedByType(type)
}