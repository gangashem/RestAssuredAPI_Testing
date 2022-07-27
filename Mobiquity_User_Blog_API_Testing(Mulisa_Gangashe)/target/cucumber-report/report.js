$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/feature/emailValidations.feature");
formatter.feature({
  "line": 2,
  "name": "User email validation",
  "description": "",
  "id": "user-email-validation",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@UserEmailValidation_Feature"
    }
  ]
});
formatter.scenario({
  "line": 4,
  "name": "Verify if the emails in the comment section are in proper format",
  "description": "",
  "id": "user-email-validation;verify-if-the-emails-in-the-comment-section-are-in-proper-format",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@EmailValidation_Scenario"
    },
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "Search for user with username \"getDelphineAPI\" with \"GET\" http request",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "Search for post written by \"getUsername\" with \"GET\" http request",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "Fetch the comments for each \"getUserPostsAPI\" with \"GET\" http request",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "Get all \"getCommentsAPI\" for each user post with \"GET\" http request",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "Validate if the \"emails\" in comment section are in the proper email \"format\".",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "the API call is success with status code 200",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "getDelphineAPI",
      "offset": 31
    },
    {
      "val": "GET",
      "offset": 53
    }
  ],
  "location": "emailValidations.searchForUserWithUsernameWithHttpRequest(String,String)"
});
formatter.result({
  "duration": 7571614700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "getUsername",
      "offset": 28
    },
    {
      "val": "GET",
      "offset": 47
    }
  ],
  "location": "emailValidations.searchForPostWrittenByWithHttpRequest(String,String)"
});
formatter.result({
  "duration": 198161900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "getUserPostsAPI",
      "offset": 29
    },
    {
      "val": "GET",
      "offset": 52
    }
  ],
  "location": "emailValidations.fetchTheCommentsForEachWithHttpRequest(String,String)"
});
formatter.result({
  "duration": 242790600,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "getCommentsAPI",
      "offset": 9
    },
    {
      "val": "GET",
      "offset": 50
    }
  ],
  "location": "emailValidations.getAllForEachUserPostWithHttpRequest(String,String)"
});
formatter.result({
  "duration": 148369100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "emails",
      "offset": 17
    },
    {
      "val": "format",
      "offset": 69
    }
  ],
  "location": "emailValidations.validateIfTheInCommentSectionAreInTheProperEmail(String,String)"
});
formatter.result({
  "duration": 84499200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 41
    }
  ],
  "location": "emailValidations.the_api_call_is_success_with_status_code(Integer)"
});
formatter.result({
  "duration": 3976500,
  "status": "passed"
});
});