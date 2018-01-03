package java20;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java20.Movie.NameCompare;
import java20.Movie.RationgCompare;

class Movie implements Comparable<Movie> {

    private double rating;
    private String name;
    private int year;

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie [rating=" + rating + ", name=" + name + ", year=" + year + "]\n";
    }

    public Movie(double rating, String name, int year) {
        super();
        this.rating = rating;
        this.name = name;
        this.year = year;
    }

    public Movie() {
        super();
    }
    
    @Override
    public int compareTo(Movie o) {
        // year를 오름차순으로 정렬
        
        return this.year - o.year;
    }
    
    // rating으로 오름차순 정렬
    public static class RationgCompare implements Comparator<Movie> {
        
        int mode = 1;
        
        public RationgCompare() {
            super();
            mode = 1;
        }
        
        public RationgCompare(boolean desc) {
            super();
            if(desc == true) {
                this.mode = -1;
            }
        }

        @Override
        public int compare(Movie o1, Movie o2) {
            if(o1.getRating() < o2.getRating()) {
                return -1*mode; // 바꾸지않음
            }
            else if (o1.getRating() > o2.getRating()) {
                return 1*mode; // 바꿈
            }
            return 0*mode; // 바꾸지않음
        }
        
    }
    
    //name으로 오름차순 정렬
    public static class NameCompare implements Comparator<Movie> {
        
        private int mode = 1;
        
        public NameCompare() {
            super();
            mode = 1;
        }
        
        public NameCompare(boolean desc) {
            super();
            if(desc==true) {
            this.mode = -1;
            }
        }

        @Override
        public int compare(Movie o1, Movie o2) {
            return o1.getName().compareTo(o2.getName())*mode;
        }
        
    }

}

public class jv20_11_Comparator {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    public static void main(String[] args) {
        List<Movie> list = new ArrayList<>();
        list.add(new Movie( 8.3, "Force", 2015));
        list.add(new Movie( 8.7, "Star", 1977));
        list.add(new Movie( 8.8, "Empire", 1990));
        list.add(new Movie( 8.4, "Return", 2000));
        
        // year를 기준으로 정렬
        Collections.sort(list); // Movie.compareTo()를 사용하여 정렬
        
        System.out.println(list.toString());
        
        RationgCompare rCompare = new RationgCompare();
        Collections.sort(list, rCompare);
        System.out.println(list.toString());
        
        NameCompare nCompare = new NameCompare();
        Collections.sort(list, nCompare);
        System.out.println(list);
        
        RationgCompare rCompareReverse = new RationgCompare(true);
        Collections.sort(list, rCompareReverse);
        System.out.println(list.toString());
        
        NameCompare nCompareReverse = new NameCompare(true);
        Collections.sort(list, nCompareReverse);
        System.out.println(list);
        
        
    }
}
