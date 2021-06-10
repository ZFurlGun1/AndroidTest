package com.example.widgettest_328zmy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
      private TextView tv;
      private EditText et;
      private Button btngettext ,btnsetime;
      private ImageView iv;
      private ImageButton ibtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        //获取那六个控件
        tv=(TextView)findViewById(R.id.TextView);
        et=(EditText) findViewById(R.id.editText2);
        btngettext=(Button) findViewById(R.id.button);
        btnsetime=(Button) findViewById(R.id.button3);
        iv=(ImageView) findViewById(R.id.imageView);
        ibtn=(ImageButton) findViewById(R.id.imageButton5);
        //设置监听器
        btngettext.setOnClickListener(this);
        btnsetime.setOnClickListener(this);
        ibtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button://设置文本
                String str=et.getText().toString();
                tv.setText(str);//核心代码
                break;
            case R.id.button3://设置图片
                iv.setImageResource(R.drawable.f_rolleyes);
                break;
            case R.id. imageButton5://图片按钮
                break;
        }
    }
}
