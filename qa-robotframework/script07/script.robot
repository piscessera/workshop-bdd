*** Settings ***
Library             SearchPage.py  Chrome

*** Test Cases ***
The user search google
    Open
    input value info field  input[name='q']  Cucumber BDD
    click element  input[name='btnK']
    ${actual}=  find element value  input[name='q']
    Keyword should be found  ${actual}  Cucumber BDD
    [Teardown]  close browser

*** Keywords ***
Open
    open browser
    
Keyword should be found
    [Arguments]  ${actual}  ${expected}
    Should Be Equal  ${actual}  ${expected}