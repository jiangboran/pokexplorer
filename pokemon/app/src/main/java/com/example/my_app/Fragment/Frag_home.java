package com.example.my_app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.my_app.Adapter.NewsAdapter;
import com.example.my_app.AddNews;
import com.example.my_app.Bean.News_bean;
import com.example.my_app.JsonParse;
import com.example.my_app.Loading;
import com.example.my_app.MainActivity;
import com.example.my_app.R;
import com.example.my_app.SearchActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private LinearLayout weather;
    private ImageButton addnews;
    private List<News_bean> newsList = new ArrayList<>();//定义新闻信息列表


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag_home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_home.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_home newInstance(String param1, String param2) {
        Frag_home fragment = new Frag_home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);

        // 设置背景颜色为 #123456
        int color = Color.parseColor("#FFFFC0");
        view.setBackgroundColor(color);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        weather = (LinearLayout) getActivity().findViewById(R.id.weather);
        //天气动画
        AlphaAnimation animaAlpha = new AlphaAnimation(0, 1);
        animaAlpha.setDuration(3000);    //持续时间
        animaAlpha.setFillAfter(true);    //动画停留最后一帧
        weather.startAnimation(animaAlpha);

        //跳转天气界面
        weather.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Loading.class);
                startActivity(intent);
            }
        });

        //跳转搜索界面
        getActivity().findViewById(R.id.search).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });

        addNews();//添加news信息
        RecyclerView recyclerView = getActivity().findViewById(R.id.news_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());//添加布局管理器
        recyclerView.setLayoutManager(layoutManager);//设置布局管理器
        NewsAdapter adapter = new NewsAdapter(newsList);
        recyclerView.setAdapter(adapter);

        //添加新闻
        addnews = (ImageButton) getActivity().findViewById(R.id.add_news);
        addnews.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), AddNews.class);
                startActivity(intent);
            }
        });
    }


    private void addNews() {
        File dir = new File("data/data/" + getActivity().getPackageName());
        //如果文件夹不存在，则创建指定的文件
        File file = new File(dir, "news.txt");
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdir();
        }
        if (file.exists()) {
            String newsdata;
            newsdata = getTxtFromAssets();
            newsList = JsonParse.getInstance().getNewsList(newsdata);
        }
        else
            newsList = JsonParse.getInstance().getNewsList(MainActivity.news_data);
    }


    // 读取txt文件的内容
    private String getTxtFromAssets() {
        String s = "";

        try {
            FileInputStream fileIn = new FileInputStream("data/data/" + getActivity().getPackageName() + "/news.txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[256];

            int charRead;

            while ((charRead = InputRead.read(inputBuffer)) > 0) {
                // char to string conversion
                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                s += readstring;
            }
            InputRead.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

}