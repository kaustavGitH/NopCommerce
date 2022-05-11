Feature: Log into NopCommerce Application

Scenario: Log into application with valid credential
Given Launch Chrome browser
When User open url "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
And User provides username as "admin@yourstore.com" and password as "admin"
And User clicks on Log In button
Then Page Title should be "Dashboard / nopCommerce administration"
When User clicks on Logout button
Then Page Title should be "Your store. Login"
And Close the browser