package com.kanme.mtimecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button b_cancel, b_hour, b_min, b_sec, b_del, b_7, b_8, b_9, b_div, b_1, b_2, b_3, b_4, b_5, b_6, b_0, b_mul, b_sub, b_sum, b_dec, b_eql, b_per;
        b_cancel = findViewById(R.id.cancel_BTN);
        b_hour = findViewById(R.id.hour_BTN);
        b_min = findViewById(R.id.min_BTN);
        b_sec = findViewById(R.id.sec_BTN);
        b_del = findViewById(R.id.delete_btn);

        b_0 = findViewById(R.id.num0);
        b_1 = findViewById(R.id.num1);
        b_2 = findViewById(R.id.num2);
        b_3 = findViewById(R.id.num3);
        b_4 = findViewById(R.id.num4);
        b_5 = findViewById(R.id.num5);
        b_6 = findViewById(R.id.num6);
        b_7 = findViewById(R.id.num7);
        b_8 = findViewById(R.id.num8);
        b_9 = findViewById(R.id.num9);
        b_sum = findViewById(R.id.add_btn);
        b_sub = findViewById(R.id.sub_btn);
        b_mul = findViewById(R.id.mult_btn);
        b_div = findViewById(R.id.div_btn);
        b_dec = findViewById(R.id.deci);
        b_eql = findViewById(R.id.equ);
        b_per = findViewById(R.id.per_btn);

        b_0.setOnClickListener(this);
        b_1.setOnClickListener(this);
        b_2.setOnClickListener(this);
        b_3.setOnClickListener(this);
        b_4.setOnClickListener(this);
        b_5.setOnClickListener(this);
        b_6.setOnClickListener(this);
        b_7.setOnClickListener(this);
        b_8.setOnClickListener(this);
        b_9.setOnClickListener(this);

        b_sum.setOnClickListener(this);
        b_sub.setOnClickListener(this);
        b_mul.setOnClickListener(this);
        b_div.setOnClickListener(this);
        b_eql.setOnClickListener(this);
        b_per.setOnClickListener(this);

        b_cancel.setOnClickListener(this);
        b_dec.setOnClickListener(this);
        b_del.setOnClickListener(this);

        b_sec.setOnClickListener(this);
        b_min.setOnClickListener(this);
        b_hour.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView ans = findViewById(R.id.answer);

        String TEMP_S="";
        int TEMP=0,RESULT=0, DECI_CNT=0, DECI_NUM=0;
        boolean DECI_FLAG=false;
        boolean HMS_FLAG = false;
        char OPER;

        switch (v.getId())
        {
            case R.id.num0:
                ans.append("0");
                if (DECI_FLAG) {
                    if (DECI_NUM == 0)
                        DECI_CNT++;
                    else
                        DECI_NUM = DECI_NUM * 10 +0;
                }
                else {
                    TEMP_S = TEMP_S + "0";
                    TEMP = TEMP * 10 + 0;
                }
                break;
            case R.id.num1:
                ans.append("1");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 1;
                else {
                    TEMP_S = TEMP_S + "1";
                    TEMP = TEMP * 10 + 1;
                }
                break;
            case R.id.num2:
                ans.append("2");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 2;
                else {
                    TEMP_S = TEMP_S + "2";
                    TEMP = TEMP * 10 + 2;
                }
                break;
            case R.id.num3:
                ans.append("3");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 3;
                else {
                    TEMP = TEMP * 10 + 3;
                    TEMP_S = TEMP_S + "3";
                }
                break;
            case R.id.num4:
                ans.append("4");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 4;
                else {
                    TEMP = TEMP * 10 + 4;
                    TEMP_S = TEMP_S + "4";
                }
                break;
            case R.id.num5:
                ans.append("5");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 5;
                else {
                    TEMP = TEMP * 10 + 5;
                    TEMP_S = TEMP_S + "5";
                }
                break;
            case R.id.num6:
                ans.append("6");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 6;
                else {
                    TEMP = TEMP * 10 + 6;
                    TEMP_S = TEMP_S + "6";
                }
                break;
            case R.id.num7:
                ans.append("7");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 7;
                else {
                    TEMP = TEMP * 10 + 7;
                    TEMP_S = TEMP_S + "7";
                }
                break;
            case R.id.num8:
                ans.append("8");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 8;
                else {
                    TEMP = TEMP * 10 + 8;
                    TEMP_S = TEMP_S + "8";
                }
                break;
            case R.id.num9:
                ans.append("9");
                if(DECI_FLAG)
                    DECI_NUM = DECI_NUM*10 + 9;
                else {
                    TEMP = TEMP * 10 + 9;
                    TEMP_S = TEMP_S + "9";
                }
                break;
            case R.id.cancel_BTN:
                ans.setText(" ");
                break;
            case R.id.delete_btn:
                if (ans.length()>0)
                    ans.setText(ans.getText().subSequence(0,ans.length()-1));
                break;
            case R.id.deci:
                ans.append(".");
                DECI_FLAG=true;
                break;
            case R.id.sec_BTN:
                if (ans.length()>0)
                if (!(.contains("s")))
                    ans.append(Html.fromHtml("<font color = 'red'>s </font>"));
                break;
            case R.id.min_BTN:
                if (ans.length()>0)
                if (!(s.contains("m")))
                    ans.append(Html.fromHtml("<font color = 'red'>m </font>"));
                break;
            case R.id.hour_BTN:
                if (ans.length()>0)
                if (!(s.contains("h")))
                ans.append(Html.fromHtml("<font color = 'red'>h </font>"));
                break;
            case R.id.equ:
                if (ans.length()>0){
                    try {
                        Log.d("time","You are in equal case");
                        ans.setText(calculate(s));
                    }
                    catch (Exception e){
                        Log.d("time","exception occurred !!!!"+e);
                    }

                }
                break;
            case R.id.per_btn:
                if (ans.length()>0) {

                }
                break;
            case R.id.add_btn:
                if (ans.length()>0)
                ans.append("+");
                break;
            case R.id.sub_btn:
                if (ans.length()>0)
                ans.append("-");
                break;
            case R.id.mult_btn:
                if (ans.length()>0)
                ans.append("x");
                break;
            case R.id.div_btn:
                if (ans.length()>0)
                ans.append("/");
                break;

        }
    }
}
