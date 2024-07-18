
package cr.com.gm.movies.service;


public interface IMoviesCatalog {
    
    String NAME_RESOURCE = "movies.txt";
    
    void addMovie(String movieName);
    
    void listMovies();
    
    void searchMovies(String search);
    
    void initiateMoviesCatalog();
}
