*** Settings ***
Library             SeleniumLibrary

*** Variables ***
${URL}                 http://google.com
${BROWSER}             Chrome
${KEYWORD}             Cucumber BDD

*** Test Cases ***
The user can search google
    [Tags]          seraching
    Open web page
    Searching with keyword  ${KEYWORD}
    There should be found keyword  ${KEYWORD}
    Close

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