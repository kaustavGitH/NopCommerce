Feature: Validate Customers Page

Scenario: Search Customer in Customers page by CustomerName
Given Launch Chrome browser
When User open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User provides username as "admin@yourstore.com" and password as "admin"
And User clicks on Log In button
And User clicks on Customers dropdown and Customers option
And Customer page is displayed
And User provides firstname as "Victoria" and lastname as "Terces"
And User clicks on search button
Then Customer table is displayed with name
And Close the browser 
 

Scenario Outline: Add list of customers in Customers page
Given Launch Chrome browser
When User open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User provides username as "admin@yourstore.com" and password as "admin"
And User clicks on Log In button
And User clicks on Customers dropdown and Customers option
Then Customer page is displayed
And Close the browser
