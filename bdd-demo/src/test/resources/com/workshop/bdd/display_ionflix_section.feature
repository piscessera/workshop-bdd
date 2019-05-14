# Todo 3
Feature: Display iONflix section

  Scenario Outline: Display 5 popular and added no more than 1 month of iONflix contents on iONflix section
    Given I logged in
    And The existing contents data
      | movie_id  | title                         | total_chapter | view_stat | tag                 | created_date  |
      | 1         | Somebody Feed Phil            | 10            | 59        | ionflix,food        | 2018-10-23    |
      | 2         | The Society                   | 1             | 30        | drama,young,ionflix | 2018-11-02    |
      | 3         | Fate/Apocrypha                | 24            | 9         | ionflix,anime       | 2018-10-14    |
      | 4         | Zohan                         | 1             | 999       | comedy,ionflix      | 2019-01-15    |
      | 5         | Million Yen Women             | 12            | 40        | drama,ionflix       | 2018-10-10    |
      | 6         | Midnight Diner: Tokyo Stories | 30            | 19        | drama,ionflix       | 2018-09-28    |
    And I watching the iONflix at <watching_date>
    When I open home of iONflix page
    Then I will see <result> in iONflix section

    Examples:
      | watching_date | result                                              |
      | 2018-11-01    | Somebody Feed Phil,Million Yen Women,Fate/Apocrypha |
      | 2019-01-15    | Zohan                                               |