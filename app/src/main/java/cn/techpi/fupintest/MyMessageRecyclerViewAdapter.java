package cn.techpi.fupintest;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import cn.techpi.fupintest.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * TODO: Replace the implementation with code for your data type.
 */
public class MyMessageRecyclerViewAdapter extends RecyclerView.Adapter<MyMessageRecyclerViewAdapter.ViewHolder> {

    public List<Message> getmValues() {
        return mValues;
    }

    private final List<Message> mValues;

    public MyMessageRecyclerViewAdapter(List<Message> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_message, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mTitleView.setText(mValues.get(position).getTitle());
        holder.mUserView.setText(mValues.get(position).getUname());
        holder.mTimeView.setText(mValues.get(position).getAddtime()+"");

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
        public Message mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mTitleView = (TextView) view.findViewById(R.id.messageTitle);
            mUserView = (TextView) view.findViewById(R.id.messageUser);
            mTimeView = (TextView) view.findViewById(R.id.messageAddTime);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mTitleView.getText() + "'";
        }
    }
}
