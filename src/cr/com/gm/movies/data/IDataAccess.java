
package cr.com.gm.movies.data;

import cr.com.gm.movies.domain.Movie;
import cr.com.gm.movies.exceptions.*;
import java.util.List;


public interface IDataAccess {
    boolean exists(String fileName) throws DataAccessEx;
    
    List<Movie> toList(String fileName) throws LectureDataEx;
    
    void write(Movie movie, String fileName, boolean append)throws WritingDataEx;
    
    String search(String fileName, String search) throws LectureDataEx;
    
    void create(String fileName) throws DataAccessEx;
    
    void erase(String fileName) throws DataAccessEx;
}
