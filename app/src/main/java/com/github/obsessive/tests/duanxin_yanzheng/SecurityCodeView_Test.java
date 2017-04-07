package com.github.obsessive.tests.duanxin_yanzheng;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.github.obsessive.tests.R;

public class SecurityCodeView_Test extends AppCompatActivity implements SecurityCodeView.InputCompleteListener {
    private SecurityCodeView editText;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_code_view__test);
        findViews();
        setListener();
    }private void setListener() {
        editText.setInputCompleteListener(this);
    }

    private void findViews() {
        editText = (SecurityCodeView) findViewById(R.id.scv_edittext);
        text = (TextView) findViewById(R.id.tv_text);
    }

    @Override
    public void inputComplete() {
        Toast.makeText(getApplicationContext(), "验证码是：" + editText.getEditContent(), Toast.LENGTH_LONG).show();
        if (!editText.getEditContent().equals("1234")) {
            text.setText("验证码输入错误");
            text.setTextColor(Color.RED);
        }
    }

    @Override
    public void deleteContent(boolean isDelete) {
        if (isDelete){
            text.setText("输入验证码表示同意《用户协议》");
            text.setTextColor(Color.BLACK);
        }
    }
}
