$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ea.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: your.email@your.domain.com"
    },
    {
      "line": 2,
      "value": "#Keywords Summary :"
    },
    {
      "line": 3,
      "value": "#Feature: List of scenarios."
    },
    {
      "line": 4,
      "value": "#Scenario: Business rule through list of steps with arguments."
    },
    {
      "line": 5,
      "value": "#Given: Some precondition step"
    },
    {
      "line": 6,
      "value": "#When: Some key actions"
    },
    {
      "line": 7,
      "value": "#Then: To observe outcomes or validation"
    },
    {
      "line": 8,
      "value": "#And,But: To enumerate more Given,When,Then steps"
    },
    {
      "line": 9,
      "value": "#Scenario Outline: List of steps for data-driven as an Examples and \u003cplaceholder\u003e"
    },
    {
      "line": 10,
      "value": "#Examples: Container for s table"
    },
    {
      "line": 11,
      "value": "#Background: List of steps run before each of the scenarios"
    },
    {
      "line": 12,
      "value": "#\"\"\" (Doc Strings)"
    },
    {
      "line": 13,
      "value": "#| (Data Tables)"
    },
    {
      "line": 14,
      "value": "#@ (Tags/Labels):To group Scenarios"
    },
    {
      "line": 15,
      "value": "#\u003c\u003e (placeholder)"
    },
    {
      "line": 16,
      "value": "#\"\""
    },
    {
      "line": 17,
      "value": "## (Comments)"
    },
    {
      "line": 19,
      "value": "#Sample Feature Definition Template"
    }
  ],
  "line": 21,
  "name": "Testing on Execute Automation Demo site",
  "description": "I want to use this template for my feature file",
  "id": "testing-on-execute-automation-demo-site",
  "keyword": "Feature",
  "tags": [
    {
      "line": 20,
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "comments": [
    {
      "line": 24,
      "value": "#Feature: Login Action"
    }
  ],
  "line": 26,
  "name": "Successful Login with Valid Credentials",
  "description": "",
  "id": "testing-on-execute-automation-demo-site;successful-login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 27,
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.step({
  "line": 28,
  "name": "User Navigate to LogIn Page then verify it",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "User enters UserName and Password",
  "keyword": "And "
});
formatter.step({
  "line": 30,
  "name": "Verify Login is Successful",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "User Selects Title",
  "keyword": "And "
});
formatter.step({
  "line": 32,
  "name": "User Selects Initial",
  "keyword": "And "
});
formatter.step({
  "line": 33,
  "name": "User Enters FirstName",
  "keyword": "And "
});
formatter.step({
  "line": 34,
  "name": "User Enters MiddleName",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "User Selects Gender",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "User Selects Language",
  "keyword": "And "
});
formatter.step({
  "line": 37,
  "name": "User Click on Save",
  "keyword": "And "
});
formatter.match({
  "location": "EA_StepDef.user_is_on_Home_Page()"
});
formatter.result({
  "duration": 3346163722,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.user_Navigate_to_LogIn_Page()"
});
formatter.result({
  "duration": 2019766077,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.user_enters_UserName_and_Password()"
});
formatter.result({
  "duration": 1385719974,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.message_displayed_Login_Successfully()"
});
formatter.result({
  "duration": 5005953171,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.selectTitle()"
});
formatter.result({
  "duration": 5135406296,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.setInitial()"
});
formatter.result({
  "duration": 83129087,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.setFirstName()"
});
formatter.result({
  "duration": 69430749,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.setMiddleName()"
});
formatter.result({
  "duration": 98509594,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.selectSex()"
});
formatter.result({
  "duration": 82214916,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.selectLanguage()"
});
formatter.result({
  "duration": 65851498,
  "status": "passed"
});
formatter.match({
  "location": "EA_StepDef.clickSave()"
});
formatter.result({
  "duration": 65929720,
  "status": "passed"
});
});