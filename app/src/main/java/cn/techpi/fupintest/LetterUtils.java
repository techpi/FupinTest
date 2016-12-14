package cn.techpi.fupintest;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.Proxy;
import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Lenovo on 2016/12/12.
 */

public class LetterUtils {
    private static OkHttpClient httpClient=new OkHttpClient();
    public static void getAllLetters(int start, int count, Callback<List<Letter>> callback) {
        String baseUrl = "http://hudong.sdfp.gov.cn/hudongapi/";
        httpClient.setAuthenticator(new Authenticator() {
            @Override
            public Request authenticate(Proxy proxy, Response response) throws IOException {
                    String credential = Credentials.basic(Config.getConfig("key_username"),Config.getConfig("key_password"));
                    return response.request().newBuilder()
                                .header("Authorization", credential)
                                .build();
            }

            @Override
            public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
                return null;
            }
        });
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        LetterService letterService = retrofit.create(LetterService.class);
        Call<List<Letter>> call = letterService.getAllLetters(start, count);
        call.enqueue(callback);
    }
}
