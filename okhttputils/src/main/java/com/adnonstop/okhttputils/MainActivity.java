package com.adnonstop.okhttputils;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.adnonstop.okhttputils.impl.OKCallback;
import com.adnonstop.okhttputils.utils.OKUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mbtnOK = (Button) findViewById(R.id.id_btn_ok);
        mbtnOK.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        OKUtils.Get(this, "http:www.adnonstop.com", null, null, new OKCallback() {
            @Override
            public void onSuccessBody(String data) {
                System.out.println(data);
            }

            @Override
            public void onSuccessHeaders(Map<String, List<String>> headers) {
                Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
                for (Map.Entry<String, List<String>> header : entries) {
                    for (String list : header.getValue()) {
                        System.out.println(header.getKey() + " = " + list);
                    }
                }
            }

            @Override
            public void onFail(Exception e) {

            }
        });
    }
}
