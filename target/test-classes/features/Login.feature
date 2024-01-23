Feature: Login functionality

Scenario: Login With Valid Credentials
Given User navigate to login page 
When User enters the valid email address "govind@gmail.com" into email field
And User enters the valid password "Gchavan@123" into the password field
And User click on Login button
Then User should get successfull logged in

Scenario: Login With Invalid Credentials
Given User navigate to login page 
When User enters the invalid email address into email field
And User enters the invalid password "Nbhavan@123" into the password field
And User click on Login button
Then User should get proper warning message about credenials mismatch

Scenario: Login With Valid Email and Invalid Password
Given User navigate to login page 
When User enters the valid email address "govind@gmail.com" into email field
And User enters the invalid password "Nb@7410120202" into the password field
And User click on Login button
Then User should get proper warning message about credenials mismatch

Scenario: Login With Invalid Email and Valid Password
Given User navigate to login page 
When User enters the invalid email address into email field
And User enters the valid password "Gchavan@123" into the password field
And User click on Login button
Then User should get proper warning message about credenials mismatch

Scenario: Login Without Providing any Credentials	
Given User navigate to login page 
When User dont enters the email address into email field
And User dont enters the password into the password field
And User click on Login button
Then User should get proper warning message about credenials mismatch