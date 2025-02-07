import pytest
from selenium import webdriver
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.chrome.service import Service

@pytest.fixture(scope="function")
def browser():
    # Setup WebDriver using WebDriverManager
    service = Service(ChromeDriverManager().install())  # Use Service to specify the driver path
    driver = webdriver.Chrome(service=service)
    driver.maximize_window()  # Maximize the window
    driver.implicitly_wait(10)  # Apply an implicit wait for elements to load
    yield driver
    driver.quit()
