package com.example.ex14.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ex14.R;
import com.example.ex14.utils.Constants;
import com.example.ex14.utils.SharedPreferencesUtil;
import com.example.ex14.utils.ValidatorUtils;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin =findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ValidateSucc()){
                    //保存登录状态
                    SharedPreferencesUtil.getInstance(LoginActivity.this).setLogin(true);
                    //跳转列表界面
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    /**
     * 校验输入
     * @return
     */
    private boolean ValidateSucc() {
       TextInputEditText tiptetEmail = findViewById(R.id.tiptet_email);
       TextInputEditText tiptetpasswd=findViewById(R.id.tiptet_password);
       String email = tiptetEmail.getText().toString();
       String passwd = tiptetpasswd.getText().toString();

       //校验邮箱非空
        if(TextUtils.isEmpty(email)){
            tiptetEmail.setError("邮箱不能为空，重新输入！");
            return  false;
        }
        //校验邮箱合规
        if(!ValidatorUtils.isEmail(email)){
            tiptetEmail.setError("邮箱输入不正确，请重新输入");
            return  false;
        }
        //校验密码非空
        if(!ValidatorUtils.isPassword(passwd)){
            tiptetpasswd.setError("密码不能为空，请重新输入");
            return  false;
        }
        //校验密码合规
        if(!ValidatorUtils.isPassword(passwd)){
            tiptetpasswd.setError("密码输入不正确，请重新输入");
            return  false;
        }
        //校验用户密码是否正确
        if(!Constants.LOGIN_USER_NAME.equals(email) || !Constants.LOGIN_PASSWD.equals(passwd)){
            Toast.makeText(this, "用户名或密码错误，请重新输入", Toast.LENGTH_SHORT).show();
            return  false;
        }

       return  true;
    }
}
