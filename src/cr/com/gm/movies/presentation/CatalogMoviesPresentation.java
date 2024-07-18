
package cr.com.gm.movies.presentation;

import cr.com.gm.movies.service.*;
import java.util.Scanner;


public class CatalogMoviesPresentation {
    public static void main(String[] args) {
        var option = -1;
        var scanner = new Scanner(System.in);
        IMoviesCatalog catalog = new MoviesCatalogImpl();
        
        while(option != 0){
            System.out.println("Choose an option: \n"
                    + "1. Start movies catalog\n"
                    + "2. Add movie\n"
                    + "3. List movies\n"
                    + "4. Search movie\n"
                    + "0. Exit");
            option = Integer.parseInt(scanner.nextLine());
            
            switch(option){
                case 1:
                    catalog.initiateMoviesCatalog();
                    break;
                case 2:
                    System.out.println("Enter the name of the movie: ");
                    var movieName = scanner.nextLine();
                    catalog.addMovie(movieName);
                    break;
                            
                case 3: 
                    catalog.listMovies();
                    break;
                case 4:
                    System.out.println("Enter a movie to search");
                    var search = scanner.nextLine();
                    catalog.searchMovies(search);
                    break;
                    
                case 0: 
                    System.out.println("See ya soon!");
                    break;
                default:
                    System.out.println("Option not recognized");
                    break;
            }
        }
    }
}
