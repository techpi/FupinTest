package cn.techpi.fupintest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
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
        Movie m=holder.mItem = mValues.get(position);
        holder.mIdView.setText(m.getTitle()+"（"+m.getYear()+"）");
        holder.mContentView.setText("类型："+formatType(m.getGenres()));
        holder.mRatingView.setText("评分："+m.getRating().getAverage());
        holder.mStars.setRating(Float.valueOf(m.getRating().getStars())/10);
        holder.mDirectorView.setText("导演："+formatDirector(m.getDirectors()));
        holder.mCastsView.setText("主演："+formatDirector(m.getCasts()));
        Picasso.with(this.mContext).load(m.getImages().getLarge()).into(holder.mImage);
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

    private String formatDirector(List<Movie.Director> directors) {
        StringBuffer sb=new StringBuffer("");

        for(int i=0;i<directors.size();i++){
            if(i!=0)sb.append(",");
            sb.append(directors.get(i).getName());

        }
        return sb.toString();
    }

    private String formatType(String[] genres) {
        StringBuffer sb=new StringBuffer("");

        for(int i=0;i<genres.length;i++){
            if(i!=0)sb.append(",");
            sb.append(genres[i]);

        }
        return sb.toString();
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
        public final TextView mDirectorView;
        public final TextView mCastsView;
        public final ImageView mImage;
        public final RatingBar mStars;
        public Movie mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.title);
            mContentView = (TextView) view.findViewById(R.id.content);
            mImage=(ImageView)view.findViewById(R.id.image);
            mRatingView=(TextView)view.findViewById(R.id.rating);
            mStars=(RatingBar)view.findViewById(R.id.stars);
            mDirectorView=(TextView)view.findViewById(R.id.director);
            mCastsView=(TextView)view.findViewById(R.id.casts);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
