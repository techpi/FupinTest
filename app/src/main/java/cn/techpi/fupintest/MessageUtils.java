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

public class MessageUtils {
    private static OkHttpClient httpClient=new OkHttpClient();
    public static void getAllMessages(int start, int count, Callback<List<Message>> callback) {
        String baseUrl = "http://hudong.sdfp.gov.cn/hudongapi/";
        httpClient.setAuthenticator(new BasicAuthenticator());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient)
                .build();

        MessageService messageService = retrofit.create(MessageService.class);
        Call<List<Message>> call = messageService.getAllMessages(start, count);
        call.enqueue(callback);
    }
}
