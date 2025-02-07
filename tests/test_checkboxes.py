import pytest
from pages.home_page import HomePage
from pages.checkboxes_page import CheckboxesPage

def test_checkboxes(browser):
    # Navigate to the homepage
    browser.get("http://the-internet.herokuapp.com/")
    home_page = HomePage(browser)

    # Go to the checkboxes page
    home_page.go_to_checkboxes_page()
    checkboxes_page = CheckboxesPage(browser)

    # Capture the Title
    title = checkboxes_page.get_title()
    print(f"Page Title of Checkboxes page: {title}")

    # Verify the title on the Checkboxes page
    assert checkboxes_page.get_title() == "Checkboxes", "Title mismatch on Checkboxes page"
    
    # Verify checkbox 1 is not selected and checkbox 2 is selected
    assert not checkboxes_page.is_checkbox1_selected(), "Checkbox 1 should not be selected"
    assert checkboxes_page.is_checkbox2_selected(), "Checkbox 2 should be selected"
