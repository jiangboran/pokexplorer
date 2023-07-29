package com.example.my_app.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.my_app.R;

public class RegisterActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText age;
    EditText phone;
    RadioGroup sex;
    Button register;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViews();
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name=username.getText().toString().trim();
                String pass=password.getText().toString().trim();
                String agestr=age.getText().toString().trim();
                String phonenum=phone.getText().toString().trim();
                String sexstr=((RadioButton)RegisterActivity.this.findViewById(sex.getCheckedRadioButtonId())).getText().toString();
                Log.i("TAG",name+"_"+pass+"_"+agestr+"_"+phonenum+"_"+sexstr);
                UserService uService=new UserService(RegisterActivity.this);
                boolean flag=uService.check(name);
                if(flag)
                    Toast.makeText(RegisterActivity.this, "用户名已存在，请更换用户名后再注册！", Toast.LENGTH_LONG).show();
                else {
                    User user = new User();
                    user.setUsername(name);
                    user.setPassword(pass);
                    user.setAge(Integer.parseInt(agestr));
                    user.setPhone(phonenum);
                    user.setSex(sexstr);
                    uService.register(user);
                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    private void findViews() {
        username=(EditText) findViewById(R.id.usernameRegister);
        password=(EditText) findViewById(R.id.passwordRegister);
        age=(EditText) findViewById(R.id.ageRegister);
        phone=(EditText) findViewById(R.id.phoneRegister);
        sex=(RadioGroup) findViewById(R.id.sexRegister);
        register=(Button) findViewById(R.id.Register);
    }

}
