Feature: App Popular Dashboard
  As a user, 
  I want to see most popular movie, 
  So that I will see only popular on the Dashboard

Scenario Outline: Display the most popular movie by view statistic
  Given I logged in to the dashboard component
  And Existing popular data
    | movie_name 	  | view_stat |
    | Zohan       	| 100       |
    | The Society  	| 50        |
    | Dororo        | 80        |
  When I view <movie_title> for <movie_click> times
  Then I will see the first movie is <first_movie>

  Examples:
    | movie_title | movie_click	| first_movie 	|
    | Zohan		    | 10			    | Zohan		      |
    | Dragonball	| 200			    | Dragonball	  |
    | Naruto		  | 20			    | Zohan		      |
