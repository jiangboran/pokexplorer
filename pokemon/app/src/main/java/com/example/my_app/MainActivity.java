package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.my_app.Fragment.Frag_home;
import com.example.my_app.Fragment.Frag_user;
import com.example.my_app.Fragment.Frag_video;

public class MainActivity extends AppCompatActivity {


    private ImageView home;
    private ImageView video;
    private ImageView user;
    private ImageView weather;
    private Bundle bundle;
    private String addnews;
    public static String username;
    public int frag;
    static public String news_data = "[" +
            "{" +
            "'title':'《宝可梦大探险》暑期探险季第二弹!帕路奇亚扭曲空间之力!'," +
            "'subtitle':'宝可梦大探险'," +
            "'tip':'置顶'" +
            "}," +
            "{" +
            "'title':'宝可梦毛绒玩具 故勒顿&密勒顿上新！'," +
            "'subtitle':'任天堂Switch游戏'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'《宝可梦黑/白》或将推出“传说”新作！微软索尼达成重要协议！'," +
            "'subtitle':'宝可梦微博'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'做宝可梦的卡比兽拯救了一只现实里的猫猫'," +
            "'subtitle':'腾讯新闻'," +
            "'tip':'热点'," +
            "'pic':'@drawable/pikaqiu'" +
            "}," +
            "{" +
            "'title':'2023年第二次宝可梦集换式卡牌游戏官方认证裁判公开招募即将开启！'," +
            "'subtitle':'宝可梦微博'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'大有可玩，就现在！宝可梦卡牌简中版【剑&盾】系列品牌宣传片'," +
            "'subtitle':'微博'," +
            "'tip':'热点'," +
            "'pic':'@drawable/pikaqiu'" +
            "}," +
            "{" +
            "'title':'萌力出发！SPAO宝可梦系列全新上线！'," +
            "'subtitle':'宝可梦微博'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'宝可梦卡牌玩皮一夏'," +
            "'subtitle':'宝可梦微博'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'宝可梦卡牌和《宝可梦太阳&月亮》将在上海BW出展！'," +
            "'subtitle':'宝可梦微博'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'抓住睡眠好节奏！#宝可梦Sleep#介绍'," +
            "'subtitle':'宝可梦微博'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'南京大学一学生在大二末暑假成功写出宝可梦APP！'," +
            "'subtitle':'JBR'," +
            "'tip':'自娱自乐'" +
            "}," +
            "{" +
            "'title':'Rocklove x 宝可梦的新四款戒指'," +
            "'subtitle':'宝可梦微博'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'伊布主题庆典开启！月亮伊布&叶伊布即将实装！'," +
            "'subtitle':'宝可梦微博'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'任天堂推出宝可梦官方论坛 惨遭垃圾信息困扰'," +
            "'subtitle':'搜狐网'," +
            "'tip':'热点'" +
            "}," +
            "{" +
            "'title':'2023宝可梦卡牌超级赛·厦门 预选赛'," +
            "'subtitle':'Pokemon宝可梦'," +
            "'tip':'热点'" +
            "}" +
            "]";
    static public String video_data = "[" +
            "{" +
            "'video_title':'PokemonGo2023——极巨争锋，大有可玩'," +
            "'username':'Pokemon'," +
            "'video_img':'https://img0.baidu.com/it/u=276300108,2915552299&fm=253&fmt=auto&app=138&f=JPEG?w=889&h=500'," +
            "'video_src':'https://vod-progressive.akamaized.net/exp=1690590385~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F1057%2F7%2F180289993%2F589233630.mp4~hmac=8eb30c3a2bb2e4d9710ef4d446ce0866a8f315a7d2e33a19481fb3a7fa7a7991/vimeo-prod-skyfire-std-us/01/1057/7/180289993/589233630.mp4?filename=file.mp4'" +
            "}," +
            "{" +
            "'video_title':'《Pokémon Party（宝可梦派对）》'," +
            "'username':'张艺兴'," +
            "'video_img':'https://img0.baidu.com/it/u=124891460,90637342&fm=253&fmt=auto&app=138&f=JPEG?w=750&h=500'," +
            "'video_src':'https://vod-progressive.akamaized.net/exp=1690591120~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F875%2F7%2F179376463%2F585217510.mp4~hmac=04896c47587f4746ac77916fa769b655eea9c643e35a286e1a7ed8aeae379c05/vimeo-prod-skyfire-std-us/01/875/7/179376463/585217510.mp4?filename=file.mp4'" +
            "}," +
            "{" +
            "'video_title':'宝可梦拼图来袭！'," +
            "'username':'酷潮玩乐'," +
            "'video_img':'https://img1.baidu.com/it/u=1936449927,1843667784&fm=253&fmt=auto&app=138&f=JPEG?w=721&h=500'," +
            "'video_src':'https://vod-progressive.akamaized.net/exp=1690591633~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F2147%2F5%2F135736895%2F401815107.mp4~hmac=5b79ab3bed765aa9c8ad468ad2dfd21af03c0bf57332c59f181ed1820cba2d13/vimeo-prod-skyfire-std-us/01/2147/5/135736895/401815107.mp4?filename=file.mp4'" +
            "}," +
            "{" +
            "'video_title':'宝可梦播放器'," +
            "'username':'视觉中国'," +
            "'video_img':'https://f7.baidu.com/it/u=701359210,2085993493&amp;fm=222&amp;app=108&amp;f=JPEG@s_0,w_800,h_1000,q_80,f_auto'," +
            "'video_src':'https://vod-progressive.akamaized.net/exp=1690591520~acl=%2Fvimeo-prod-skyfire-std-us%2F01%2F2827%2F20%2F514139029%2F2381409476.mp4~hmac=02129aec39d669d07336bba840ed274f8a06b72f4172068d6b46ad42aff5d596/vimeo-prod-skyfire-std-us/01/2827/20/514139029/2381409476.mp4?filename=file.mp4'" +
            "}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = this.getIntent().getExtras();

        home = findViewById(R.id.home);
        video = findViewById(R.id.video);
        user = findViewById(R.id.user);
        weather =findViewById(R.id.weather);
        turn_frag(home);

        if (bundle != null) {
            if (bundle.getInt("flag") == 1) {
                addnews = "{'title':'" + bundle.getString("title") + "'," +
                        "'subtitle':'" + bundle.getString("subtitle") + "'," +
                        "'tip':'" + bundle.getString("tip") + "'";
                if (bundle.getString("pic") != null)
                    addnews += ",'pic':'" + bundle.getString("pic") + "'},";
                else
                    addnews += "},";
                StringBuilder s = new StringBuilder(news_data);
                s.insert(1, addnews);
                news_data = s.toString();

                //写入文件
                //获取准确的路径,context.getPackageName()得到包名
                File dir = new File("data/data/" + this.getPackageName());
                //如果文件夹不存在，则创建指定的文件
                if (!dir.exists() || !dir.isDirectory()) {
                    dir.mkdir();
                }
                //文件声明
                File file = new File(dir, "news.txt");
                //输入流
                InputStream inputStream = null;
                //输出流
                OutputStream outputStream = null;
                //若不存在，通过IO流的方式，将assets目录下的数据库文件，写入到项目模拟手机中，当开启模拟
                //器时，会将数据库文件写入到模拟手机的内存中
                if (!file.exists()) {
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    //创建文件
                    file.createNewFile();
                    //加载文件
                    inputStream = new ByteArrayInputStream(news_data.getBytes());
                    //输出到文件
                    outputStream = new FileOutputStream(file);

                    byte[] buffer = new byte[1024];
                    int len;
                    //按字节写入
                    while ((len = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    //关闭资源
                    if (outputStream != null) {

                        try {
                            outputStream.flush();
                            outputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }


            } else if (bundle.getInt("flag") == 2) {
                turn_frag(video);
            } else if (bundle.getInt("flag") == 3) {
                turn_frag(weather);
            } else if (bundle.getInt("flag") == 4) {
                turn_frag(user);
            }
        }

        home.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turn_frag(view);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turn_frag(view);
            }
        });
        weather.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turn_frag(view);
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turn_frag(view);
            }
        });

        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToFourth();
            }
            private void navigateToFourth() {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

    }

    private void navigateToFourth() {
        Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
        startActivity(intent);
    }

    public void turn_frag(View v) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Frag_home f1 = new Frag_home();
        Frag_video f2 = new Frag_video();
        Frag_user f3 = new Frag_user();
        switch (v.getId()) {
            case R.id.home:
                if(frag != 1) {
                    ft.replace(R.id.frag, f1);
                    frag = 1;
                }
                break;
            case R.id.video:
                if(frag != 2) {
                    ft.replace(R.id.frag, f2);
                    frag = 2;
                }
                break;
            case R.id.user:
                if(frag != 3) {
                    ft.replace(R.id.frag, f3);
                    frag = 3;
                }
                break;
        }
        ft.commit();
    }


}

