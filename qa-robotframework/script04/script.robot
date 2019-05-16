*** Settings ***
Library             SeleniumLibrary
Resource            resource.txt

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