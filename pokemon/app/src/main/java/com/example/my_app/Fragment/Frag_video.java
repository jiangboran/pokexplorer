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

import com.example.my_app.Adapter.VideoAdapter;
import com.example.my_app.Bean.Video_bean;
import com.example.my_app.JsonParse;
import com.example.my_app.MainActivity;
import com.example.my_app.R;
import com.example.my_app.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Frag_video#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Frag_video extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<Video_bean> videoList = new ArrayList<>();//定义视频信息列表

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Frag_video() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Frag_video.
     */
    // TODO: Rename and change types and number of parameters
    public static Frag_video newInstance(String param1, String param2) {
        Frag_video fragment = new Frag_video();
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
        View view = inflater.inflate(R.layout.frag_video, container, false);

        // 设置背景颜色为 #123456
        int color = Color.parseColor("#FFAD40");
        view.setBackgroundColor(color);

        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        addVideo();//添加video信息
        RecyclerView recyclerView = getActivity().findViewById(R.id.video_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());//添加布局管理器
        recyclerView.setLayoutManager(layoutManager);//设置布局管理器
        VideoAdapter adapter = new VideoAdapter(videoList);
        recyclerView.setAdapter(adapter);

        //跳转搜索界面
        getActivity().findViewById(R.id.search2).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addVideo(){
        videoList = JsonParse.getInstance().getVideoList(MainActivity.video_data);
    }
}