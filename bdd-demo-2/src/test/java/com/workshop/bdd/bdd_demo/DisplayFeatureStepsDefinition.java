package com.workshop.bdd.bdd_demo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Map;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class DisplayFeatureStepsDefinition {
	private ContentDao contentDao;
	private ContentService contentService;

	@Given("I open link ionflix.com")
	public void i_open_link_ionflix_com() {
		contentService = new ContentService();
		contentDao = new ContentDao();
		contentService.setContentDao(contentDao);
	}
	@And("Existing data")
	public void existing_data(DataTable dataTable) {		
		List<Map<String, String>> datas = dataTable.asMaps();
		for (int index = 0; index < datas.size(); index++) {
			Map<String, String> row = datas.get(index);
			String movieName = row.get("movie_name");
			Integer viewStat = Integer.parseInt(row.get("view_stat"));
			Content content = new Content();
			
			content.setMovieName(movieName);
			content.setViewStat(viewStat);
			
			contentDao.add(content);
		}
	}
	@When("I view (.*?) for (.*?) times")
	public void when_i_view_for_times(String movieTitle, Integer movieClick) {
		for(int index = 0; index < movieClick; index++) {
			RequestEntity requestEntity = new RequestEntity();
			requestEntity.setMovieTitle(movieTitle);
			contentService.view(requestEntity);
		}
	}
	@Then("I will see the first movie is (.*?)")
	public void i_will_see_the_first_movie_is(String firstMovie) {
		Content result = contentService.findMostPopular();
		assertThat(result.getMovieName(), is(firstMovie));
	}
}