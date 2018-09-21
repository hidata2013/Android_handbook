package com.demo.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.TitleViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    private List<String> titleList;
    private OnItemClick onItemClick;

    public interface OnItemClick {
        void onItemClick(int position, View view);
    }

    public TitleAdapter(Context mContext) {
        context = mContext;
        inflater = LayoutInflater.from(context);
    }

    public void setTitleList(List<String> list) {
        titleList = list;
    }

    public void setOnItemClick(OnItemClick onItemClick) {
        this.onItemClick = onItemClick;
    }

    @NonNull
    @Override
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.title_list_item, parent, false);
        return new TitleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TitleViewHolder titleViewHolder, int i) {
        if (titleList == null) {
            return;
        }
        final int position = i;
        titleViewHolder.textView.setText(titleList.get(i));
        titleViewHolder.textView.setTag(titleList.get(i));
        titleViewHolder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClick != null) {
                    onItemClick.onItemClick(position, titleViewHolder.textView);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (titleList == null) {
            return 0;
        }
        return titleList.size();
    }

    static class TitleViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tile_name);
        }
    }
}
