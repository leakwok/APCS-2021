/*
 * Arrays of objects
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class moviesDriver {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("./mymoviedb.csv").load();
      ArrayList<movies> allMovies = ds.fetchList("movies", "Title", "Popularity",
             "Vote_Count", "Vote_Average");
      System.out.println("Total movies: " + allMovies.size());


      System.out.println("Here are some highly rated movies: ");
      for (movies m : allMovies) {
         if (m.getAvg() > 9) {
            System.out.println("  " + m.getName() + ": " + m.getAvg() + " out of 10");
         }
      }


      double mostPopular = allMovies.get(0).getPop();
      int loc = 0;
      for(int i = 0; i < allMovies.size(); i++){
        if(allMovies.get(i).getPop() > mostPopular){
          mostPopular = allMovies.get(i).getPop();
          loc = i;
        }
      }
      System.out.println("The most popular movie is: " + allMovies.get(loc).getName());
      System.out.println("It's rating was: " + allMovies.get(loc).getAvg() + " out of 10");

   }
}
