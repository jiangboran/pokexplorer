package com.example.my_app.Adapter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_app.Bean.News_bean;
import com.example.my_app.R;
import com.example.my_app.ReadActivity;

import java.util.List;


public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private List<News_bean> mContactList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        View contactView;//存储解析到的view
        ImageView image_news;
        TextView text_title;
        TextView text_subtitle;
        TextView tip;

        public ViewHolder(View view) {
            super(view);
            contactView = view;
            image_news = view.findViewById(R.id.news_img);
            text_title = view.findViewById(R.id.news_title);
            text_subtitle = view.findViewById(R.id.news_subtitle);
            tip = view.findViewById(R.id.news_tip);
        }
    }

    public NewsAdapter(List<News_bean> newsList) {
        mContactList = newsList;
    }

    @NonNull
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);//解析layout
        final NewsAdapter.ViewHolder viewHolder = new NewsAdapter.ViewHolder(view);//新建一个viewHolder绑定解析到的view
        //监听每一项的点击事件
        viewHolder.contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                News_bean news_bean = mContactList.get(position);
                Toast.makeText(view.getContext(), news_bean.getTitle(), Toast.LENGTH_SHORT).show();
                // 创建用于传递数据的Intent
                Intent intent = new Intent(view.getContext(), ReadActivity.class);

                // 将News_bean的相关信息放入Intent中，例如title、content等
                intent.putExtra("title", news_bean.getTitle());
                intent.putExtra("content", news_bean.getContent());
                // 添加其他需要传递的信息...

                // 启动ReadActivity
                view.getContext().startActivity(intent);
            }
        });
        //监听每一项里的控件的点击事件，如点击了ImageView
//        viewHolder.image_news.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = viewHolder.getAdapterPosition();
//                News_bean news_bean = mContactList.get(position);
//                Toast.makeText(view.getContext(), news_bean.getPic(), Toast.LENGTH_SHORT).show();
//            }
//        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NewsAdapter.ViewHolder holder, int position) {
        News_bean news_bean = mContactList.get(position);
        if(news_bean.getPic()!=null) {
            Bitmap bitmap = BitmapFactory.decodeFile(news_bean.getPic());
            holder.image_news.setImageBitmap(bitmap);
        }
        holder.text_title.setText(news_bean.getTitle());
        holder.text_subtitle.setText(news_bean.getSubtitle());
        holder.tip.setText(news_bean.getTip());
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }


}

