package cn.techpi.fupintest;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Credentials;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.Proxy;

/**
 * Created by chaxin on 2016/12/14.
 */

public class BasicAuthenticator implements Authenticator {
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
}
