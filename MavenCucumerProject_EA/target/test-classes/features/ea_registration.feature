#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios 
#<> (placeholder)
#""
## (Comments)

#Sample Feature Definition Template
@tag
Feature: Testing on Execute Automation Demo site
	I want to use this template for my feature file

#Feature: Login Action
 
Scenario: Successful Login with Valid Credentials
	Given User is on Registration Page
	And User Selects Titile
	And User Selects Initial
	And User Enters FirstName
	And User Enters MiddleName
	And User Selects Gender
	And User Selects Language
	And User Click on Save