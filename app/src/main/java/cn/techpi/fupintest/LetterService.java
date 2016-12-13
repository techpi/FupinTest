package cn.techpi.fupintest;

import java.util.List;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Lenovo on 2016/12/12.
 */

public interface LetterService {
    @GET("letters")
    Call<List<Letter>> getAllLetters(@Query("start") int start, @Query("count") int count);
}
