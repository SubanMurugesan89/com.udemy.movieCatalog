import model.Movie;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static java.util.Arrays.asList;

public class MovieStore {
    List<Movie> movies = new LinkedList<Movie>();

    private List<Movie> findBy(checkForValues check) {
        List<Movie> result = new LinkedList<Movie>();
        for (Movie movieList: movies){
            if(check.matches(movieList)){
                result.add(movieList);
            }
        }
        return result;
    }

    public void add(Movie movieName) {
        movies.add(movieName);
    }

    public List<Movie> findByPartialTitle(String partialTitle) {
        checkForValues check = movie -> movie.title().toUpperCase().contains(partialTitle.toUpperCase());
        return findBy(check);
    }

    public List<Movie> findByDirector(String director) {
        checkForValues check = movie -> movie.director().equals(director);

        return findBy(check);
    }

    public List<Movie> findByYear(int from, int to) {
        checkForValues check = movie -> movie.year() > from && movie.year() < to;

        return findBy(check);
    }

    interface checkForValues{
        boolean matches(Movie movie);
    }
}
