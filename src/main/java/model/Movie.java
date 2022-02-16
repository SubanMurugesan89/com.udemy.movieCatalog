package model;

public class Movie {

    private String title;
    private String director;
    private int year;

    public Movie(String title,String director, int year) {
        this.title = title;
        this.director= director;
        this.year= year;
    }

    public String title() {
        return title;
    }

    public String toString(){
        return title;
    }

    public String director() {
        return director;
    }

    public int year() {
        return year;
    }
}
