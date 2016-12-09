package cn.techpi.fupintest;

import java.util.List;

/**
 * Created by Lenovo on 2016/12/8.
 */

public class Movie {
    public String getTitle() {
        return title;
    }

    public String getSubtype() {
        return subtype;
    }

    private String title;
    private String subtype;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    private String year;


    public MovieImage getImages() {
        return images;
    }

    public void setImages(MovieImage images) {
        this.images = images;
    }

    private MovieImage images;

    @Override
    public String toString() {
        return String.format("片名：%s，上映年份：%s，类型：%s",title,year,subtype);
    }

    public MovieRating getRating() {
        return rating;
    }

    public void setRating(MovieRating rating) {
        this.rating = rating;
    }

    private MovieRating rating;

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        this.genres = genres;
    }

    private String[] genres;
    private List<Director> directors;

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<Director> getCasts() {
        return casts;
    }

    public void setCasts(List<Director> casts) {
        this.casts = casts;
    }

    private List<Director> casts;

    public static class Director{
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private String name;
    }

    public static class MovieRating{
        public double getMax() {
            return max;
        }

        public void setMax(double max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public double getMin() {
            return min;
        }

        public void setMin(double min) {
            this.min = min;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        private double max;
        private double average;
        private double min;
        private String stars;
    }
    public static class MovieImage{
        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        private String small;
        private String medium;
        private String large;
    }
}
