*** Settings ***
Library             SeleniumLibrary
Test Setup          Open
Test Teardown       Close
Test Template       Searching

*** Variables ***
${URL}                 http://google.com
${BROWSER}             Chrome

*** Test Cases ***              Keyword         Expected
Search With One Word            Cucumber        Cucumber
Search with Two Word            BDD Cucumber    BDD Cucumber

*** Keywords ***
Open
    Open Browser  ${URL}  ${BROWSER}

Close
    Close Browser

Given keyword
    [Arguments]  ${keyword_value}
    Click Element  css:input[name='q']
    Press Keys  None  ${keyword_value}
    

When I want to search
    Wait Until Element Is Visible  css:input[name='btnK']
    Click Element  css:input[name='btnK']

Then I will see
    [Arguments]  ${searching_keyword}
    Wait Until Element Is Visible  css:input[name='q']
    Textfield Value Should Be  css:input[name='q']  ${searching_keyword}
    Close

Searching
    [Arguments]  ${keyword_value}  ${expected_keyword}
    Given keyword   ${keyword_value}
    When I want to search
    Then I will see   ${expected_keyword}
