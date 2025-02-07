from selenium.webdriver.common.by import By

class CheckboxesPage:
    def __init__(self, driver):
        self.driver = driver
        self.title = (By.TAG_NAME, "h3")
        self.checkbox1 = (By.XPATH, "//input[@type='checkbox'][1]")
        self.checkbox2 = (By.XPATH, "//input[@type='checkbox'][2]")

    def get_title(self):
        return self.driver.find_element(*self.title).text

    def is_checkbox1_selected(self):
        return self.driver.find_element(*self.checkbox1).is_selected()

    def is_checkbox2_selected(self):
        return self.driver.find_element(*self.checkbox2).is_selected()
