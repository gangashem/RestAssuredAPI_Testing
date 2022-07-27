@UserEmailValidation_Feature
Feature: User email validation
  @EmailValidation_Scenario @Regression
  Scenario: Verify if the emails in the comment section are in proper format
    Given Search for user with username "getDelphineAPI" with "GET" http request
    When Search for post written by "getUsername" with "GET" http request
    Then Fetch the comments for each "getUserPostsAPI" with "GET" http request
    And Get all "getCommentsAPI" for each user post with "GET" http request
    When Validate if the "emails" in comment section are in the proper email "format".
    Then the API call is success with status code 200