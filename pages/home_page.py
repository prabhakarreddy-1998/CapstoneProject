from selenium.webdriver.common.by import By

class HomePage:
    def __init__(self, driver):
        self.driver = driver
        self.checkbox_link = (By.LINK_TEXT, "Checkboxes")
        self.file_upload_link = (By.LINK_TEXT, "File Upload")

    def go_to_checkboxes_page(self):
        self.driver.find_element(*self.checkbox_link).click()

    def go_to_file_upload_page(self):
        self.driver.find_element(*self.file_upload_link).click()
