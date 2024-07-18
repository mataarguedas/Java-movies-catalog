package cr.com.gm.movies.service;

import cr.com.gm.movies.data.DataAccessImpl;
import cr.com.gm.movies.data.IDataAccess;
import cr.com.gm.movies.domain.Movie;
import cr.com.gm.movies.exceptions.DataAccessEx;
import cr.com.gm.movies.exceptions.LectureDataEx;

public class MoviesCatalogImpl implements IMoviesCatalog {

    private final IDataAccess data;

    public MoviesCatalogImpl() {
        this.data = new DataAccessImpl();

    }

    @Override
    public void addMovie(String movieName) {
        Movie movie = new Movie(movieName);
        boolean append = false;
        try {
            append = data.exists(NAME_RESOURCE);
            data.write(movie, NAME_RESOURCE, append);
        } catch (DataAccessEx ex) {
            System.out.println("Error data access");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listMovies() {
        try {
            var movies = this.data.toList(NAME_RESOURCE);
            for (var movie : movies) {
                System.out.println("movie = " + movie);
            }
        } catch (LectureDataEx ex) {
            System.out.println("Error data access");
            ex.printStackTrace(System.out);
        }

    }

    @Override
    public void searchMovies(String search) {
        String result = null;
        try {
            result = this.data.search(NAME_RESOURCE, search);
        } catch (LectureDataEx ex) {
            System.out.println("Error data access");
            ex.printStackTrace(System.out);
        }
        System.out.println("result = " + result);
    }

    @Override
    public void initiateMoviesCatalog() {
        try {
            if (this.data.exists(NAME_RESOURCE)) {
                data.erase(NAME_RESOURCE);
                data.create(NAME_RESOURCE);
            } else {
                data.create(NAME_RESOURCE);
            }
        } catch (DataAccessEx ex) {
            System.out.println("Error initiating catalog of movies");
            ex.printStackTrace(System.out);
        }
    }

}
