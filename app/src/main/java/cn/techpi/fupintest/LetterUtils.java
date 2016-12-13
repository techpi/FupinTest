package cn.techpi.fupintest;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Lenovo on 2016/12/12.
 */

public class LetterUtils {
    public static void getAllLetters(int start, int count, Callback<List<Letter>> callback) {
        String baseUrl = "http://hudong.sdfp.gov.cn/hudongapi/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LetterService letterService = retrofit.create(LetterService.class);
        Call<List<Letter>> call = letterService.getAllLetters(start, count);
        call.enqueue(callback);
    }
}
