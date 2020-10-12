package com.example.ex14.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex14.R;
import com.example.ex14.utils.ImageUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 图片列表适配器
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.ViewHolder> {
    private Context context;
    private OnItemClickListener onItemClickListener;
    private List<String> dataList = new ArrayList<>();
    public PhotoAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.adapter_item_photo, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.binData(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void setData(List<String> list) {
        dataList.addAll(list);
    }

    public List<String> getData() {
        return dataList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivPhoto;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPhoto = itemView.findViewById(R.id.iv_photo);
        }

        public void binData(int position) {
            String url =dataList.get(position);
            ImageUtil.showByScale((Activity)context, ivPhoto, url);
        }
    }

    public void  setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 点击图片事件
     */
    public interface OnItemClickListener{
        void  onItemClick(int position);
    }
}
