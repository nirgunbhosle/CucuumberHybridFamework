Feature: Search Functionality

Scenario: User Search For Valid Product
Given User opens the appliction
When User enters valid product "HP" into the search box field
And User click on search button
Then User should get valid product displayed in search results

Scenario: User Search For Inalid Product
Given User opens the appliction
When User enters invalid product "honda" into the search box field
And User click on search button
Then User should get a messege about no product found

Scenario: User Search Without any Product
Given User opens the appliction
When User dont enters any product into the search box field
And User click on search button
Then User should get a messege about no product found


