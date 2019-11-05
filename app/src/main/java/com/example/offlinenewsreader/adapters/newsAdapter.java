package com.example.offlinenewsreader.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.offlinenewsreader.R;

public class newsAdapter extends RecyclerView.Adapter<newsAdapter.newsViewHolder> {

    private Cursor mCursor;
    private ListItemClickListener mOnClickListener;

    public interface ListItemClickListener {
        void onClick(String news);
    }

    public newsAdapter(ListItemClickListener listener, Cursor cursor) {
        mOnClickListener = listener;
        mCursor = cursor;
    }

    @NonNull
    @Override
    public newsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.news_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new newsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull newsViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        if (mCursor != null) {
            return mCursor.getCount();
        }
        return 1;
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) mCursor.close();
        mCursor = newCursor;
        if (newCursor != null) {
            this.notifyDataSetChanged();
        }
    }

    public class newsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView mItemTextView;

        public newsViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemTextView = (TextView) itemView.findViewById(R.id.text_item);
            itemView.setOnClickListener(this);
        }

        public void bind(int position) {

            if (mCursor == null) {
                mItemTextView.setText("There is no News Saved");
            } else {
                mItemTextView.setText("Hello From the other side");
            }

        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
        }
    }
}
