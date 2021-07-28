package com.ymars.poj.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.ymars.mvvm.poj.businesscom.bean.ArticleBean;
import com.ymars.poj.component.interf.RvItemOnclicker;
import com.ymars.poj.home.BR;
import com.ymars.poj.home.R;
import com.ymars.poj.home.databinding.ArticleItemBinding;

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
        View view = LayoutInflater.from(mCtx).inflate(R.layout.article_item, parent, false);
        return new ArticleViewhodler(view);
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewhodler holder, final int position) {
        holder.itemListBinding.setVariable(BR.article, data.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rvItemOnclicker != null) {
                    rvItemOnclicker.onRvItemClick(data.get(position), view, position);
                }
            }
        });
    }

    class ArticleViewhodler extends RecyclerView.ViewHolder {
        private ArticleItemBinding itemListBinding;

        public ArticleViewhodler(@NonNull View itemView) {
            super(itemView);
            itemListBinding = DataBindingUtil.bind(itemView);
        }
    }
}
