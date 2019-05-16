import { Before, Given, Then, When } from 'cucumber';
import { expect } from 'chai';

import { DashboardComponent } from '../../../src/app/dashboard/dashboard.component';

import { DashboardPage } from '../pages/dashboard_popular.po';

let page: DashboardPage;
let component: DashboardComponent;

Before(() => {
  page = new DashboardPage();
});

Given(/^I logged in to the dashboard$/, async () => {
  await page.navigateTo();
});

Given(/^Existing popular data$/, (table, callback) => {
  var data = table.hashes();
  for (var i = 0; i < data.length; i++) {
    var movieName = data[i].movie_name;
    var viewStat = data[i].view_stat;
    var item = {
      movieName: movieName,
      viewStat: viewStat
    };
    component.movies.push(item);
    // component.
      // inputData = data[i].field;
      // fieldEl = getVariable[inputData.replace(/s+/g, '')];
      // fieldEl.clear();
      // var p = fieldEl.sendKeys(data[i].content);
      // if (i === data.length - 1) {
      //     p.then(callback);
      // }
  }
  component.mostPopular.movieName = 'hello';
});

// When(/^When I view (*.?) for (*.?) times$/, (movie_title, movie_click) => {
//   component.mostPopular.movieName = 'hello';
// });

Then(/^Then I will see the first movie is (*.?)$/, async (first_movie) => {
  expect(await page.getMostPopularMovieTitle()).to.equal('test');
});

// Scenario Outline: Display the most popular movie by view statistic
//   Given I logged in
//   And Existing data
//     | movie_name 	  | view_stat |
//     | Zohan       	| 100       |
//     | The Society  	| 50        |
//     | Dororo        | 80        |
//   When I view <movie> for <movie_click> times
//   Then I will see the first movie is <first_movie>

//   Examples:
//     | movie_title | movie_click	| first_movie 	|
//     | Zohan		    | 10			    | Zohan		      |
//     | Dragonball	| 200			    | Dragonball	  |
//     | Naruto		  | 20			    | Zohan		      |
