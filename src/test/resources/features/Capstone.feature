Feature: Automate the-internet.herokuapp.com

Scenario: Validate website functionality
  Given User launches the application
  When User clicks on AB Testing and verifies the text
  And User navigates back to home and clicks dropdown
  Then User selects Option 1 and verifies selection
  And User navigates back to home and clicks Frames
  Then User verifies Nested Frames and iFrame links
