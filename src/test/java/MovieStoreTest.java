import model.Movie;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MovieStoreTest {

    private final Movie harryPorter = new Movie("Harry Porter","Tom",200);
    private final Movie spiderMan = new Movie("Spider MAN","Jerry",2001);
    private final Movie wonderMan = new Movie("Wonder Man","Suban",2002);
    private final Movie harryPorter2 = new Movie("Harry Porter2","Tom",2003);
    private final MovieStore movieStore = new MovieStore();

    @BeforeEach
    void setUp() {
        movieStore.add(harryPorter);
        movieStore.add(spiderMan);
        movieStore.add(wonderMan);
        movieStore.add(harryPorter2);
    }

    @Test
    @DisplayName("Return No Results When No Titles Partially Matches")
    public void returnNoResultsWhenNoTitlesPartiallyMatches(){
        MovieStore movieStore = new MovieStore();
        List<Movie> result = movieStore.findByPartialTitle("Harry");
        assertEquals(result.size(),0);
    }

    @Test
    @DisplayName("Return Movie when partially matches title with case sensitivity")
    public void returnMovieswhenitpartiallyMatcheswithCaseSensitivity(){
        List<Movie> result = movieStore.findByPartialTitle("man");
        assertThat(result.size(),is(2));
       assertThat(result,contains(spiderMan, wonderMan));
    }

    @Test
    @DisplayName("Return Movie when match Director Name")
    public void returnMoviesNamewithexactMatchDirectorName(){
        List<Movie> result = movieStore.findByDirector("Tom");
        assertThat(result.size(),is(2));
        assertThat(result,containsInAnyOrder(harryPorter,harryPorter2));
    }

    @Test
    @DisplayName("Return Movie when match Director Name")
    public void returnMovieNameBasedOnYears(){
        List<Movie> result = movieStore.findByYear(2000,2002);
        assertThat(result.size(),is(1));
        assertThat(result,containsInAnyOrder(spiderMan));
    }

}