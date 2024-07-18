package cr.com.gm.movies.data;

import cr.com.gm.movies.domain.Movie;
import cr.com.gm.movies.exceptions.*;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;

public class DataAccessImpl implements IDataAccess {

    @Override
    public boolean exists(String fileName) {
        File file = new File(fileName);
        return file.exists();
    }

    @Override
    public List<Movie> toList(String fileName) throws LectureDataEx {
        var file = new File(fileName);
        List<Movie> movies = new ArrayList<>();
        try {
            BufferedReader input = new BufferedReader(new FileReader(file));
            String line = null;
            
            line = input.readLine();
            while (line != null) {
                var movie = new Movie(line);
                movies.add(movie);
                line = input.readLine();
            }
            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LectureDataEx("Exception while listing movies" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LectureDataEx("Exception while listing movies" + ex.getMessage());
        }
        return movies;

    }

    @Override
    public void write(Movie movie, String fileName, boolean append) throws WritingDataEx {
        var file = new File(fileName);
        try {
            var output = new PrintWriter(new FileWriter(file, append));
            output.println(movie.toString());
            output.close();
            System.out.println("Data has been written to the file: " + movie);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new WritingDataEx("Exception while listing movies" + ex.getMessage());
        }
    }

    @Override
    public String search(String fileName, String search) throws LectureDataEx {
        var file = new File(fileName);
        String result = null;
        try {
            var input = new BufferedReader(new FileReader(file));
            String line = null;
            line = input.readLine();
            var index = 1;
            while (line != null) {
                    if(search != null && search.equalsIgnoreCase(line)){
                        result = "Movie " + line + " found in the index " + index;
                        break;
                    }
                    line = input.readLine();
                    index++;
                          
            }
            input.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LectureDataEx("Exception while searching movies" + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LectureDataEx("Exception while searching movies" + ex.getMessage());
        }

        return result;
    }

    @Override
    public void create(String fileName) throws DataAccessEx {
        var file = new File(fileName);
        try {
            var output = new PrintWriter(new FileWriter(file));
            output.close();
            System.out.println("File has been created");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new DataAccessEx("Exception while creating file" + ex.getMessage());
        }
    }

    @Override
    public void erase(String fileName) {
        var file = new File(fileName);
        if(file.exists())
        file.delete();
        System.out.println("File has been erased");
    }

}
