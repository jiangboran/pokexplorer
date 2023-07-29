package com.example.my_app.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_app.R;
import com.example.my_app.Bean.Weather_bean;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder>{
    private List<Weather_bean> mContactList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View contactView;//存储解析到的view
        ImageView image_weather;
        TextView text_weather;
        public ViewHolder(View view){
            super(view);
            contactView = view;
            image_weather = view.findViewById(R.id.image_weather);
            text_weather = view.findViewById(R.id.text_weather);
        }
    }

    public WeatherAdapter(List<Weather_bean> weatherList){
        mContactList = weatherList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hourwea,parent,false);//解析layout
        final ViewHolder viewHolder = new ViewHolder(view);//新建一个viewHolder绑定解析到的view
        //监听每一项的点击事件
        viewHolder.contactView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Weather_bean weather_bean = mContactList.get(position);
                Toast.makeText(view.getContext(),weather_bean.getWeather(),Toast.LENGTH_SHORT).show();
            }
        });
        //监听每一项里的控件的点击事件，如点击了ImageView
        viewHolder.image_weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = viewHolder.getAdapterPosition();
                Weather_bean weather_bean = mContactList.get(position);
                Toast.makeText(view.getContext(),weather_bean.getWea_img(),Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Weather_bean weather_bean = mContactList.get(position);
        holder.image_weather.setImageResource(weather_bean.getWea_img());
        holder.text_weather.setText(weather_bean.getWeather());
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }


}
