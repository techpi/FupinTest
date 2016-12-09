package cn.techpi.fupintest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import cn.techpi.fupintest.LetterFragment.OnListFragmentInteractionListener;
import cn.techpi.fupintest.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLetterRecyclerViewAdapter extends RecyclerView.Adapter<MyLetterRecyclerViewAdapter.ViewHolder> {
    public List<Movie> getmValues() {
        return mValues;
    }

    public void setmValues(List<Movie> mValues) {
        this.mValues = mValues;
    }

    private List<Movie> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final Context mContext;
    public MyLetterRecyclerViewAdapter(List<Movie> items, OnListFragmentInteractionListener listener, Context context) {
        mValues = items;
        mListener = listener;
        mContext=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_letter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getTitle());
        holder.mContentView.setText("上映年份："+mValues.get(position).getYear());
        holder.mRatingView.setText("评分："+mValues.get(position).getRating().getAverage());
        Picasso.with(this.mContext).load(mValues.get(position).getImages().getLarge()).into(holder.mImage);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public final TextView mRatingView;
        public final ImageView mImage;
        public Movie mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.title);
            mContentView = (TextView) view.findViewById(R.id.content);
            mImage=(ImageView)view.findViewById(R.id.image);
            mRatingView=(TextView)view.findViewById(R.id.rating);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
