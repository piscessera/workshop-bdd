package com.workshop.bdd;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

//Todo 4
public class DisplayIONflixSectionStepDefs {
    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

    private ContentService contentService;
    private ContentDao contentDao;
    private DbConnectorSpy dbConnectorSpy;
    private UserRequest userRequest;
    private List<ContentModel> actualResult;

    @Given("I logged in")
    public void i_logged_in() {
        contentService = new ContentService();
        contentDao = new ContentDaoMock();
        dbConnectorSpy = new DbConnectorSpy();
        contentDao.setDbConnector(dbConnectorSpy);
        contentService.setContentDao(contentDao);
    }

    @And("The existing contents data")
    public void the_existing_contents_data(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        data.forEach((map) -> {
            ContentModel content = new ContentModel();
            content.setId(map.get("movie_id"));
            content.setTitle(map.get("title"));
            content.setTotalChapter(Integer.parseInt(map.get("total_chapter")));
            content.setViewStat(Integer.parseInt(map.get("view_stat")));
            content.setTag(map.get("tag").split(","));

            try {
                Date date = formatter.parse(map.get("created_date"));
                content.setCreatedDate(date);
            } catch (ParseException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            contentDao.add(content);
        });
    }

    @And("I watching the iONflix at (.*?)")
    public void i_watching_the_ionflix_at(String watchingDate) {
        userRequest = new UserRequest();
        try {
            Date date = formatter.parse(watchingDate);
            userRequest.setWatchingDate(date);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @When("I open home of iONflix page")
    public void i_open_home_of_ionflix_page() {
        actualResult = contentService.findIONFlixContents(userRequest);
    }

    @Then("I will see (.*?) in iONflix section")
    public void i_will_see_in_ionflix_section(String result) {
        String[] titles = result.split(",");
        assertThat(dbConnectorSpy.isConnectDbCalled(), is(true));
        for (int index = 0; index < titles.length; index++) {
            assertThat(actualResult.get(index).getTitle(), is(titles[index]));
        }
    }
}
