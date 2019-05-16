*** Settings ***
Library             SeleniumLibrary

*** Variables ***
${URL}                 http://google.com
${BROWSER}             Chrome

*** Test Cases ***
Search
    Given keyword "Cucumber BDD"
    When I want to search
    Then I will see "Cucumber BDD" in search box

*** Keywords ***
Given keyword "Cucumber BDD"
    Open Browser  ${URL}  ${BROWSER}

When I want to search
    Click Element  css:input[name='q']
    Press Keys  None  Cucumber BDD
    Wait Until Element Is Visible  css:input[name='btnK']
    Click Element  css:input[name='btnK']

Then I will see "Cucumber BDD" in search box
    Wait Until Element Is Visible  css:input[name='q']
    Textfield Value Should Be  css:input[name='q']  Cucumber BDD
    Close Browser

