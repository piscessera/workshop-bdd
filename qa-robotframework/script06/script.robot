*** Settings ***
Library             SeleniumLibrary
Test Setup          Open web page
Test Teardown       Close
Test Template       Searching

*** Variables ***
${URL}                 http://google.com
${BROWSER}             Chrome

*** Test Cases ***              Keyword         Expected
Search With One Word            Cucumber        Cucumber
Search with Two Word            BDD Cucumber    BDD Cucumber

*** Keywords ***
Open web page
    Open Browser  ${URL}  ${BROWSER}

Close
    Close Browser

Searching with keyword
    [Arguments]  ${keyword_value}
    Click Element  css:input[name='q']
    Press Keys  None  ${keyword_value}
    Wait Until Element Is Visible  css:input[name='btnK']
    Click Element  css:input[name='btnK']

There should be found keyword
    [Arguments]  ${searching_keyword}
    Wait Until Element Is Visible  css:input[name='q']
    Textfield Value Should Be  css:input[name='q']  ${searching_keyword}

Searching
    [Arguments]  ${keyword_value}  ${expected_keyword}
    Searching with keyword  ${keyword_value}
    There should be found keyword  ${expected_keyword}
