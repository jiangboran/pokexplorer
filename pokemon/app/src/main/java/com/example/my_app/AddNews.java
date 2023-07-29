package com.example.my_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class AddNews extends AppCompatActivity {

    private ImageView img1;
    private ImageView img2;
    private TextView input_title;
    private TextView input_abstract;
    private TextView input_article;
    private TextView input_subtitle;
    private RadioButton R1;
    private RadioButton R2;
    private String title;
    private String abstr;
    private String article;
    private String subtitle;
    public String img_path;
    private String tip;
    public int sig;
    public int sig2;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);


        img1 = (ImageView) findViewById(R.id.news_pic1);
        img2 = (ImageView) findViewById(R.id.news_pic2);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果没有权限则申请权限
                if (ContextCompat.checkSelfPermission(AddNews.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AddNews.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
                sig = 1;
                //调用打开相册
                openAlbum();
            }

        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //如果没有权限则申请权限
                if (ContextCompat.checkSelfPermission(AddNews.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(AddNews.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                }
                sig = 2;
                //调用打开相册
                openAlbum();
            }

        });

        //返回
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AddNews.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //选项
        radioGroup = (RadioGroup) findViewById(R.id.RadioGroup);
        R1 = (RadioButton) findViewById(R.id.radioButton1);
        R2 = (RadioButton) findViewById(R.id.radioButton2);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1)
                    sig2 = 1;
                else if (checkedId == R.id.radioButton2)
                    sig2 = 2;
            }

        });

        //提交
        findViewById(R.id.submit_news).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                input_title = (EditText) findViewById(R.id.input_title);
                input_abstract = (EditText) findViewById(R.id.input_abstract);
                input_article = (EditText) findViewById(R.id.input_article);
                input_subtitle = (EditText) findViewById(R.id.input_subtitle);
                title = input_title.getText().toString();
                abstr = input_abstract.getText().toString();
                article = input_article.getText().toString();
                subtitle = input_subtitle.getText().toString();
                if (sig2 == 1)
                    tip = "置顶";
                else if (sig2 == 2)
                    tip = "热门";
                if (title.trim().equals("") || abstr.trim().equals("") || article.trim().equals("") || subtitle.trim().equals("")) {
                    Toast.makeText(AddNews.this, "请填写完整后再提交", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(AddNews.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("title", title);//使用显式Intent传递参数，用以区分功能
                    bundle.putString("abstract", abstr);
                    bundle.putString("article", article);
                    bundle.putString("article", article);
                    bundle.putString("pic", img_path);
                    bundle.putString("subtitle", subtitle);
                    bundle.putString("tip", tip);
                    bundle.putInt("flag", 1);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

    }

    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, 2); // 打开相册
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    openAlbum();
                } else {
                    Toast.makeText(this, "You denied the permission", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 判断手机系统版本号
        if (Build.VERSION.SDK_INT >= 19) {
            // 4.4及以上系统使用这个方法处理图片
            handleImageOnKitKat(data);
        } else {
            // 4.4以下系统使用这个方法处理图片
            handleImageBeforeKitKat(data);
        }
    }

    @TargetApi(19)
    private void handleImageOnKitKat(Intent data) {
        img_path = null;
        try {
            Uri uri = data.getData();

            Log.d("TAG", "handleImageOnKitKat: uri is " + uri);

            if (DocumentsContract.isDocumentUri(this, uri)) {
                // 如果是document类型的Uri，则通过document id处理
                String docId = DocumentsContract.getDocumentId(uri);
                if ("com.android.providers.media.documents".equals(uri.getAuthority())) {

                    String id = docId.split(":")[1]; // 解析出数字格式的id
                    String selection = MediaStore.Images.Media._ID + "=" + id;
                    img_path = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);

                } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                    Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                    img_path = getImagePath(contentUri, null);
                }
            } else if ("content".equalsIgnoreCase(uri.getScheme())) {
                // 如果是content类型的Uri，则使用普通方式处理
                img_path = getImagePath(uri, null);
            } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                // 如果是file类型的Uri，直接获取图片路径即可
                img_path = uri.getPath();
            }
            displayImage(img_path); // 根据图片路径显示图片
        } catch (Exception e) {
            e.printStackTrace();// 输出异常信息

        }
    }

    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        img_path = getImagePath(uri, null);
        displayImage(img_path);
    }

    @SuppressLint("Range")
    private String getImagePath(Uri uri, String selection) {
        String path = null;
        // 通过Uri和selection来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }

    private void displayImage(String imagePath) {
        if (imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            if (sig == 1)
                img1.setImageBitmap(bitmap);
            else
                img2.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "failed to get image", Toast.LENGTH_SHORT).show();
        }
    }


}