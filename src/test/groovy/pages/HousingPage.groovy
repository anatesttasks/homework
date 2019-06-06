package pages

import geb.Page

class HousingPage extends Page {

    static at = {
        assert driver.getCurrentUrl().contains('housing/search')
        searchField.displayed
        searchButton.displayed
        resultViewModeDropdown.displayed
        sortingTypeDropdown.displayed
    }

    static content = {
        searchField(wait: true) { $("#query") }
        searchButton(wait: true) { $(".searchbtn") }
        resultViewModeDropdown(wait: true) { $(".search-view")[0] }
        sortingTypeDropdown(wait: true) { $(".search-sort")[0] }
        listOfsortingTypes(wait:true) { $(".dropdown-sort .dropdown-item") }
        sortingType(wait:true) { type -> $(".dropdown-sort .dropdown-item [data-selection='$type']") }
        listOfHousingRecordPrices(wait: true) { $(".result-hood").siblings(".result-price") }
    }

    void checkSortingTypes(List definedSortingTypes) {
        sortingTypeDropdown.click()

        definedSortingTypes.each{
            sortingType(it).displayed
        }

        assert listOfsortingTypes.size() == definedSortingTypes.size()
    }

    void searchHousingsByParam(param) {
        searchField.click()
        searchField << param
        searchButton.click()
    }

    void sortRecordsBySortingType(type) {
        sortingTypeDropdown.click()
        sortingType(type).click()
    }

    boolean checkRecordsSortedByType(type) {
        assert type == 'priceasc' ? checkRecordsSortedByPriceasc() : checkRecordsSortedByPricedsc()
    }

    boolean checkRecordsSortedByPriceasc() {
        def prices = getListWithPrices()
        prices.eachWithIndex{  it, int i ->
            assert i==0 ?: it >= prices[i-1]
        }
    }

    boolean checkRecordsSortedByPricedsc() {
        def prices = getListWithPrices()
        prices.eachWithIndex{  it, int i ->
            assert i==0 ?: it <= prices[i-1]
        }
    }

    List getListWithPrices() {
        listOfHousingRecordPrices.collectNested {
         it.text().replace('€','') as int
        }
    }
}