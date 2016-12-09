package cn.techpi.fupintest;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link RetrofitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RetrofitFragment extends Fragment {
    @Bind(R.id.click_me_BN)
    Button loadButton;
    @Bind(R.id.result_TV)
    TextView textView;

    public RetrofitFragment() {
        // Required empty public constructor
    }

    public static RetrofitFragment newInstance() {
        RetrofitFragment fragment = new RetrofitFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_retrofit, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @OnClick(R.id.click_me_BN)
    public void onClick() {
        Toast.makeText(this.getContext(),"You clicked Button",Toast.LENGTH_LONG).show();
        MovieUtils.getMovies(0,20,new Callback<MovieEntity>() {
            @Override
            public void onResponse(Response<MovieEntity> response, Retrofit retrofit) {
                textView.setText(response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                textView.setText(t.getMessage());
            }

        });
    }




}
