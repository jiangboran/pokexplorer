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
    private Bundle bundle;
    private String addnews;
    public static String username;
    public int frag;
    static public String news_data = "[" +
            "{" +
            "\"title\":\"2024宝可梦卡牌成都超级赛”预热活动即将开启\"," +
            "\"subtitle\":\"集换式卡牌游戏\"," +
            "\"tip\":\"置顶\"," +
            "\"content\":\"2024宝可梦卡牌成都超级赛（以下简称“成都超级赛”）的预热活动将于12月30日起在成都的各大商场举办，欢迎训练家们踊跃参加。\n" +
            "\n" +
            "1.主要活动内容\n" +
            "宝可梦卡牌入门教室\n" +
            "\n" +
            "面向想要开始尝试宝可梦卡牌对战的人，\n" +
            "\n" +
            "可以在这里学习宝可梦卡牌的基础玩法与规则。\n" +
            "\n" +
            "你的宝可梦卡牌之旅就此开始！\n" +
            "\n" +
            "欢迎新手！\n" +
            "\n" +
            "了解卡牌对战的进阶技巧，\n" +
            "\n" +
            "使用起始卡组和对手来一场友谊之战吧！\n" +
            "\n" +
            "对战派对（部分会场实施）\n" +
            "\n" +
            "\n" +
            "现开赛（部分会场实施）\n" +
            "\n" +
            "参加活动还有机会获得皮卡丘和伊布遮阳帽以及皮卡丘扇子！\"" +
            "}," +
            "{" +
            "\"title\":\"聚会合家欢桌面游戏《嗒宝：宝可梦》\"," +
            "\"subtitle\":\"商品\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"《嗒宝：宝可梦》继承了《嗒宝》系列一贯的易上手、高互动、多欢乐的特色，是一款适合各个年龄层玩家的桌面游戏。\n" +
            "\n" +
            "游戏的每张卡片均印有8个宝可梦相关图案，任意两张卡片都包含刚好一对相同的图案，玩家的任务是通过敏锐的观察力、迅敏的行动力以及对《宝可梦》系列丰富的知识储备，抢先于对手一步喊出对应宝可梦、登场人物或道具的名称来赢下游戏。\n" +
            "\n" +
            "作为《嗒宝：宝可梦》本身的一大亮点，游戏除了会收录皮卡丘、妙蛙种子、小火龙、杰尼龟等大家熟悉的宝可梦外，还迎来了敲音猴、炎兔儿、泪眼蜥等众多宝可梦伙伴。甚至能在游戏过程发现小智、大木博士、精灵球、大师球等在《宝可梦》系列中登场的人物及道具。让你在享受游戏乐趣的同时掌握更多关于《宝可梦》的知识。尝试成为伙伴身边的“宝可梦大师”吧。\"" +
            "}," +
            "{" +
            "\"title\":\"国服《宝可梦大集结》“登岛测试”招募开启\"," +
            "\"subtitle\":\"游戏\"," +
            "\"tip\":\"热点\"," +
            "\"pic\":\"@drawable/pikaqiu\"," +
            "\"content\":\"12 月 31 日消息，《宝可梦大集结》是腾讯天美工作室群与 The Pokémon Company 联合开发的宝可梦系列轻松竞技游戏，新一轮国服限量付费删档测试“登岛测试”即将到来，现已开启招募（限安卓机型），测试资格将于 1 月 22 日左右公布。\n" +
            "IT之家注意到，本次内测为“付费删档测试”，玩家的段位、等级等数据不会继承至正式服。在测试期间通过充值或直购进行付费的玩家，在游戏正式上线后使用同一账号登录，还将享有“宝石加量返还”的福利。\n" +
            "在内测中达成“训练家 8 级”的玩家，将在未来的正式服中获得“内测纪念装扮贴纸”。奖励将通过游戏系统邮件自动发放至符合条件的账号中（需使用与内测时相同的账号登录正式服）。\n" +
            "内测纪念装扮贴纸\n" +
            "本次限量删档内测预计将于 1 月下旬开启，时长预计在 20 天左右，测试版本已接入腾讯健康系统。\n" +
            "本次测试基于安卓手机端进行，配置要求如下：\n" +
            "最低配置\n" +
            "\n" +
            "处理器：骁龙 625、 麒麟 710、联发科 MT6765 及以上\n" +
            "\n" +
            "GPU：Mali-G51MP4、Adreno506 及以上\n" +
            "\n" +
            "操作系统：Android 4.4 以上\n" +
            "\n" +
            "内存：3G 及以上\n" +
            "\n" +
            "存储：预留 5G 及以上\n" +
            "\n" +
            "推荐配置\n" +
            "\n" +
            "处理器：骁龙 845、 海思 980、联发科天玑 900 及以上\n" +
            "\n" +
            "GPU：Mali-G77MP8、Adreno642L 及以上\n" +
            "\n" +
            "操作系统：Android 6.0 以上\n" +
            "\n" +
            "内存：6G 及以上\n" +
            "\n" +
            "存储：预留 5G 及以上\"" +
            "}," +
            "{" +
            "\"title\":\"做宝可梦的卡比兽拯救了一只现实里的猫猫\"," +
            "\"subtitle\":\"腾讯新闻\"," +
            "\"tip\":\"热点\"," +
            "\"pic\":\"@drawable/pikaqiu\"," +
            "\"content\":\"正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四正文四\"" +
            "}," +
            "{" +
            "\"title\":\"2023年第二次宝可梦集换式卡牌游戏官方认证裁判公开招募即将开启！\"," +
            "\"subtitle\":\"宝可梦微博\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五正文五\"" +
            "}," +
            "{" +
            "\"title\":\"大有可玩，就现在！宝可梦卡牌简中版【剑&盾】系列品牌宣传片\"," +
            "\"subtitle\":\"微博\"," +
            "\"tip\":\"热点\"," +
            "\"pic\":\"@drawable/pikaqiu\"," +
            "\"content\":\"正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六正文六\"" +
            "}," +
            "{" +
            "\"title\":\"萌力出发！SPAO宝可梦系列全新上线！\"," +
            "\"subtitle\":\"宝可梦微博\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七正文七\"" +
            "}," +
            "{" +
            "\"title\":\"宝可梦卡牌玩皮一夏\"," +
            "\"subtitle\":\"宝可梦微博\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八正文八\"" +
            "}," +
            "{" +
            "\"title\":\"宝可梦卡牌和《宝可梦太阳&月亮》将在上海BW出展！\"," +
            "\"subtitle\":\"宝可梦微博\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九正文九\"" +
            "}," +
            "{" +
            "\"title\":\"抓住睡眠好节奏！#宝可梦Sleep#介绍\"," +
            "\"subtitle\":\"宝可梦微博\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十正文十\"" +
            "}," +
            "{" +
            "\"title\":\"南京大学一学生在大二末暑假成功写出宝可梦APP！\"," +
            "\"subtitle\":\"JBR\"," +
            "\"tip\":\"自娱自乐\"," +
            "\"content\":\"正文十一正文十一正文十一正文十一正文十一正文十一正文十一\"" +
            "}," +
            "{" +
            "\"title\":\"Rocklove x 宝可梦的新四款戒指\"," +
            "\"subtitle\":\"宝可梦微博\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文十二正文十二正文十二正文十二正文十二正文十二正文十二\"" +
            "}," +
            "{" +
            "\"title\":\"伊布主题庆典开启！月亮伊布&叶伊布即将实装！\"," +
            "\"subtitle\":\"宝可梦微博\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文十三正文十三正文十三正文十三正文十三正文十三正文十三\"" +
            "}," +
            "{" +
            "\"title\":\"任天堂推出宝可梦官方论坛 惨遭垃圾信息困扰\"," +
            "\"subtitle\":\"搜狐网\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文十四正文十四正文十四正文十四正文十四正文十四正文十四\"" +
            "}," +
            "{" +
            "\"title\":\"2023宝可梦卡牌超级赛·厦门 预选赛\"," +
            "\"subtitle\":\"Pokemon宝可梦\"," +
            "\"tip\":\"热点\"," +
            "\"content\":\"正文十五正文十五正文十五正文十五正文十五正文十五正文十五\"" +
            "}" +
            "]";


    static public String video_data = "[" +
            "{" +
            "'video_title':'疯狂动物城爆笑上映'," +
            "'username':'媒体+'," +
            "'video_img':'https://img2.baidu.com/it/u=3599238479,2998054692&fm=253&fmt=auto&app=120&f=JPEG?w=1281&h=800'," +
            "'video_src':'https://box.nju.edu.cn/seafhttp/files/17cc78f7-d66d-4411-b742-9a0cff9af97f/964889265a89bf7b5710d1a637fc7385.mp4'" +
            "}," +
            "{" +
            "'video_title':'疯狂动物城爆笑上映'," +
            "'username':'媒体+'," +
            "'video_img':'https://img2.baidu.com/it/u=3599238479,2998054692&fm=253&fmt=auto&app=120&f=JPEG?w=1281&h=800'," +
            "'video_src':'http://vjs.zencdn.net/v/oceans.mp4'" +
            "}," +
            "{" +
            "'video_title':'疯狂动物城爆笑上映'," +
            "'username':'媒体+'," +
            "'video_img':'https://img2.baidu.com/it/u=3599238479,2998054692&fm=253&fmt=auto&app=120&f=JPEG?w=1281&h=800'," +
            "'video_src':'http://vjs.zencdn.net/v/oceans.mp4'" +
            "}]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = this.getIntent().getExtras();

        home = findViewById(R.id.home);
        video = findViewById(R.id.video);
        user = findViewById(R.id.user);
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
        user.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                turn_frag(view);
            }
        });

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

