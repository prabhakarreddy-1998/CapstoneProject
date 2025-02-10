import pytest
import os
from pages.home_page import HomePage
from pages.file_upload_page import FileUploadPage

def test_file_upload(browser):
    # Navigate to the homepage
    browser.get("http://the-internet.herokuapp.com/")
    home_page = HomePage(browser)

    # Go to the File Upload page
    home_page.go_to_file_upload_page()
    file_upload_page = FileUploadPage(browser)

    # Capture the Title
    page_title = file_upload_page.get_title()
    print(f"Page Title of File Upload Page: {page_title}")

    # Verify the title on the File Upload page
    assert file_upload_page.get_title() == "File Uploader", "Title mismatch on File Upload page"
    
    # Upload a file and verify the upload process
    file_path = os.path.abspath("test_file.txt")  # Create a test file if it doesn't exist
    with open(file_path, "w") as file:
        file.write("This is a test file for upload.")
    
    file_upload_page.upload_file(file_path)
