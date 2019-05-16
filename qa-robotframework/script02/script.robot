*** Settings ***
Library             SeleniumLibrary

*** Variables ***
${URL}                 http://google.com
${BROWSER}             Chrome
${KEYWORD}             Cucumber BDD

*** Test Cases ***
The user can search google
    [Tags]          seraching
    Open Browser    ${URL}   ${BROWSER}
    Click Element   css:input[name='q']
    Press Keys      None    ${KEYWORD}
    Wait Until Element Is Visible   css:input[name='btnK']
    Click Element   css:input[name='btnK']
    Wait Until Element Is Visible   css:input[name='q']
    Textfield Value Should Be  css:input[name='q']     ${KEYWORD}
    [Teardown]  Close Browser