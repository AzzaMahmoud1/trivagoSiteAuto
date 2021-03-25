Feature: Automated End2End Tests
  Description: The purpose of this feature is to test End 2 End integration.
	
	Scenario: Customer View Booking Deals through all the possible ways as real flow
	Given The User on Discover Page
	When I Search with the Data 
	And I View hotels From Discover page through images and close it
	And I view Hotels from discover page through view Deal withough expanding the View
	And  I view the hotels through see more stays then filter the search results
	Then website is redirected to the corresponding page  
	
