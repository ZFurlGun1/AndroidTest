package com.example.zmy.startproject_328zmy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zmy.startproject_328zmy.bean.WeatherInfo;
import com.example.zmy.startproject_328zmy.iface.WeatherListener;
import com.example.zmy.startproject_328zmy.model.WeatherModel;
import com.example.zmy.startproject_328zmy.model.Weather51Model;
public class MainActivity extends AppCompatActivity implements WeatherListener,View.OnClickListener{
     private EditText etcityno;
    private Button  btnfind1,btnfind2;
    private TextView tvcityname,temp,wd,ws,sd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init()
    {
        etcityno=(EditText)findViewById(R.id.editText);
        btnfind1=(Button)findViewById(R.id.button);
        btnfind2=(Button)findViewById(R.id.button2);
        tvcityname=(TextView)findViewById(R.id.textView);
        temp=(TextView)findViewById(R.id.textView4);
        wd=(TextView)findViewById(R.id.textView6);
        ws=(TextView)findViewById(R.id.textView8);
        sd=(TextView)findViewById(R.id.textView10);

        btnfind1.setOnClickListener(this);
        btnfind2.setOnClickListener(this);
    }

    @Override
    public void onResponse(WeatherInfo weatherInfo) {
        if (weatherInfo!=null)
        {
            tvcityname.setText(weatherInfo.getCity());
            temp.setText(weatherInfo.getTemp());
            wd.setText(weatherInfo.getWD());
            ws.setText(weatherInfo.getWS());
            sd.setText(weatherInfo.getSD());
        }
        else
        {
            tvcityname.setText("未知");
        }
    }

    @Override
    public void onFail(String msg) {
    tvcityname.setText(msg);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case  R.id.button://查询1
                System.out.println("----按钮1被按下");
                WeatherModel weatherModel=new WeatherModel();
                weatherModel.getWeather(etcityno.getText().toString(),
                        this);
                break;
            case  R.id.button2:
                System.out.println("----按钮2被按下");
                Weather51Model weather51Model=new Weather51Model();
                weather51Model.getWeather(etcityno.getText().toString(),
                        this);
                break;
            default:
                break;
        }
    }
}
