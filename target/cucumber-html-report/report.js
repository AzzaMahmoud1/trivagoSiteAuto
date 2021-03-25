$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("E2EFeature.feature");
formatter.feature({
  "line": 1,
  "name": "Automated End2End Tests",
  "description": "Description: The purpose of this feature is to test End 2 End integration.",
  "id": "automated-end2end-tests",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Customer View Booking Deals through all the possible ways as real flow",
  "description": "",
  "id": "automated-end2end-tests;customer-view-booking-deals-through-all-the-possible-ways-as-real-flow",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "The User on Discover Page",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I Search with the Data",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I View hotels From Discover page through images and close it",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I view Hotels from discover page through view Deal withough expanding the View",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I view the hotels through see more stays then filter the search results",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "website is redirected to the corresponding page",
  "keyword": "Then "
});
formatter.match({
  "location": "E2E.the_User_on_Discover_Page()"
});
formatter.result({
  "duration": 4949161600,
  "status": "passed"
});
formatter.match({
  "location": "E2E.i_Search_with_the_Data()"
});
