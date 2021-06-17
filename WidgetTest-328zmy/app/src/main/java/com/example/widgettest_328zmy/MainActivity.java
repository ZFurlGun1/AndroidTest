package com.example.widgettest_328zmy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
      private TextView tv;
      private EditText et;
      private Button btngettext ,btnsetime;
      private ImageView iv;
      private ImageButton ibtn;
    //声明8个控件
    private RadioGroup rg;
    private RadioButton rbnan,rbnv;
    private CheckBox cblan,cbzu,cbyou;
    private Button btngetgender,btngetfun;

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
        rg=(RadioGroup) findViewById(R.id.rr);
        rbnan=(RadioButton) findViewById(R.id.radioButton1);
        rbnv=(RadioButton)findViewById(R.id.radioButton2);
        cblan=(CheckBox)findViewById(R.id.checkBox);
        cbzu=(CheckBox)findViewById(R.id.checkBox2);
        cbyou=(CheckBox)findViewById(R.id.checkBox3);
        btngetgender=(Button)findViewById(R.id.button2);
        btngetfun=(Button)findViewById(R.id.button5);




        //设置监听器
        btngettext.setOnClickListener(this);
        btnsetime.setOnClickListener(this);
        ibtn.setOnClickListener(this);
        btngetgender.setOnClickListener(this);
        btngetfun.setOnClickListener(this);
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
                Intent intent=new Intent(MainActivity.this,NewActivity.class);
                intent.putExtra("param1",et.getText().toString());
                intent.putExtra("param2",3);
                startActivity(intent);
                break;
            case R.id.button2:
                if(rbnan.isChecked())
                tv.setText("男");
                if(rbnv.isChecked())
                    tv.setText("女");
                break;
            case R.id.button5:
                String msg="";
                if(cblan.isChecked())
                    msg+="篮球+";
                if(cbzu.isChecked())
                    msg+="足球";
                if(cbyou.isChecked())
                    msg+="游泳";
                tv.setText(msg);

                break;
        }
    }
}
