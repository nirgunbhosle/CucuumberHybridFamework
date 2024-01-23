Feature: Registration Functionality

Scenario: User Creates an Account Only With Mandatory Fields
Given User navigate to register account page
When User enters the details into below fields
|firstName |Nirgun            |
|lastName  |Bhosle            |
|telephone  |7410120202        |
|password   |DADA@4141         |
And User select privecy policy
And User click on continue button
Then User account should get created successfully

Scenario: User Creates an Account With All Fields
Given User navigate to register account page
When User enters the details into below fields
|firstName |Nirgun            |
|lastName  |Bhosle            |
|telephone  |7410120202        |
|password   |DADA@4141         |
And User select yes for newslatter
And User select privecy policy
And User click on continue button
Then User account should get created successfully

Scenario: User Creates an Dupicate Account
Given User navigate to register account page
When User enters the details into below fields with duplicate email
|firstName |Nirgun            |
|lastName  |Bhosle            |
|duplicateemail|nirgun01@gmail.com|
|telephone  |7410120202        |
|password   |DADA@4141         |
And User select yes for newslatter
And User select privecy policy
And User click on continue button
Then User should get proper warning message about duplicate email

Scenario: User Creates an Account Without Filling Any Details
Given User navigate to register account page
When User dont enters any details into fields
And User click on continue button
Then User should get proper warning message for every mandatory field


