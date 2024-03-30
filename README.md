# Welcome to R3 Tech Assignment Project
Test framework in Java with BDD to test APIs with RestAssured

# Installations Required:
postman (to test API responses)
IntelliJ IDE (or any other editor)
maven dependencies and plugins

## About the framework

Its a basic API testing framework written in Java using with BDD approach. RestAssured is used for testing the endpoints and validations.

## Use Case and Acceptance Criteria

This framework is validating API responses for currency rates returned by endpoint. 

• API call is successful and returns valid price.
• Check the status code and status retuned by the API response.
• Fetch the USD price against the AED and make sure the prices are in range on 3.6 –
3.7.
• Make sure API response time is not less then 3 seconds then current time in second.
• Verify that 162 currency pairs are retuned by the API.
• Make sure API response matches the Json schema.

## Files

This framework is validating API responses for currency rates returned by endpoint. There are two feature files included:
1. currencyRates.feature: for basic validations
2. schemaValidation.feature: for schema validations and response count verification
> **Note:** This could be done in single feature file too. The segregation is done for simplicity, based on complexity of validations.

## Author
Jyoti Kadam

