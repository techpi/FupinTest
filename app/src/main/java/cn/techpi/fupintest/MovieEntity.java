package cn.techpi.fupintest;

import android.util.Log;

import java.util.List;

/**
 * Created by Lenovo on 2016/12/8.
 */

public class MovieEntity {
    public int getStart() {
        return start;
    }

    public int getTotal() {
        return total;
    }

    public int getCount() {
        return count;
    }

    private int start;
    private int total;
    private int count;

    public List<Movie> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Movie> subjects) {
        this.subjects = subjects;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setCount(int count) {
        this.count = count;
    }

    private List<Movie> subjects;

    @Override
    public String toString() {
        String moviesStr=formatMovies(subjects);
        Log.d("MovieEntity",moviesStr);
        return String.format("total:%s,start:%s,count:%s\nMovies:%s",total,start,count,moviesStr);
    }

    private String formatMovies(List<Movie> movies) {
        StringBuffer sb=new StringBuffer("[");
        for (int i=0;i<movies.size();i++) {
            if(i!=0)sb.append(",\n");
            sb.append(movies.get(i).toString());
        }
        sb.append("]");
        return sb.toString();
    }
}
