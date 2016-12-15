package cn.techpi.fupintest;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cn.techpi.fupintest.dummy.DummyContent;
import cn.techpi.fupintest.dummy.DummyContent.DummyItem;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class MessageFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private int currentPage;
    private int totalPage;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public MessageFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static MessageFragment newInstance(int columnCount) {
        MessageFragment fragment = new MessageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final SwipeRefreshLayout refreshview = (SwipeRefreshLayout) inflater.inflate(R.layout.fragment_message_list, container, false);
        final RecyclerView recyclerView = (RecyclerView) refreshview.findViewById(R.id.listMessage);
        final MyMessageRecyclerViewAdapter adapter= new MyMessageRecyclerViewAdapter(new ArrayList<Message>());
        recyclerView.setAdapter(adapter);
        Context context = refreshview.getContext();
        if (mColumnCount <= 1) {
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
        }
        refreshview.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Message letter=new Message();
                letter.setTitle("下拉加载");
                adapter.getmValues().add(0,letter);
                adapter.notifyDataSetChanged();
                ((SwipeRefreshLayout) refreshview).setRefreshing(false);
            }
        });
        recyclerView.addItemDecoration(new DividerDecoration(getContext(),DividerDecoration.VERTICAL_LIST));
        loadPage(adapter);
        return refreshview;
    }
    private void loadPage(final MyMessageRecyclerViewAdapter adapter) {
        MessageUtils.getAllMessages(currentPage*20,20,new Callback<List<Message>>() {
            @Override
            public void onResponse(Response<List<Message>> response, Retrofit retrofit) {
                if(response.body()==null) {
                    Toast.makeText(getContext(),"加载失败！",Toast.LENGTH_SHORT).show();
                    return;
                }
                totalPage=response.body().size()/20+1;
                adapter.getmValues().addAll(response.body());
                adapter.notifyDataSetChanged();
                currentPage++;
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(getContext(),"加载失败！",Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
