package com.ymars.poj.home.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ymars.mvvm.poj.businesscom.bean.ArticleBean;
import com.ymars.poj.component.interf.RvItemOnclicker;
import com.ymars.poj.home.R;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewhodler> {
    private ArrayList<ArticleBean> data;
    private RvItemOnclicker rvItemOnclicker;
    private Context mCtx;

    public ArticleAdapter(ArrayList<ArticleBean> data, RvItemOnclicker rvItemOnclicker, Context mCtx) {
        this.data = data;
        this.rvItemOnclicker = rvItemOnclicker;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public ArticleViewhodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.article_item, null, false);
        return new ArticleViewhodler(view);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewhodler holder, int position) {
        holder.titleTv.setText(String.format("%s.%s", position + 1, data.get(position).getTitle()));
    }

    class ArticleViewhodler extends RecyclerView.ViewHolder {
        private TextView titleTv;

        public ArticleViewhodler(@NonNull View itemView) {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv);
        }
    }
}
