package cn.techpi.fupintest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import cn.techpi.fupintest.dummy.DummyContent.DummyItem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * TODO: Replace the implementation with code for your data type.
 */
public class MyLetterRecyclerViewAdapter extends RecyclerView.Adapter<MyLetterRecyclerViewAdapter.ViewHolder> {

    public List<Letter> getmValues() {
        return mValues;
    }

    private final List<Letter> mValues;
    public MyLetterRecyclerViewAdapter(List<Letter> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_letter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).getTitle());
        holder.mUserView.setText("来信人："+mValues.get(position).getUname());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        holder.mTimeView.setText("来信时间："+sdf.format(new Date(mValues.get(position).getAddtime()*1000)));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.mView.getContext(),"点击了"+position,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mTitleView;
        public final TextView mUserView;
        public final TextView mTimeView;
        public Letter mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.letterTitle);
            mUserView = (TextView) view.findViewById(R.id.letterUser);
            mTimeView=(TextView) view.findViewById(R.id.addTime);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mUserView.getText() + "'";
        }
    }
}
