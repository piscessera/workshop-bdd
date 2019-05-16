import { browser, by, element } from 'protractor';

export class DashboardPage {
  navigateTo() {
    return browser.get('/dashboard');
  }

  getMostPopularMovieTitle() {
    return element(by.css('most-popular movie-title')).getText();
  }
}