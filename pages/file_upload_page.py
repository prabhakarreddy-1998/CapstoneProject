import os
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys

class FileUploadPage:
    def __init__(self, driver):
        self.driver = driver
        self.title = (By.TAG_NAME, "h3")
        self.choose_file_button = (By.ID, "file-upload")
        self.upload_button = (By.ID, "file-submit")

    def get_title(self):
        return self.driver.find_element(*self.title).text

    def upload_file(self, file_path):
        self.driver.find_element(*self.choose_file_button).send_keys(file_path)
        self.driver.find_element(*self.upload_button).click()
