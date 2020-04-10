package com.example.mycustonchartview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=findViewById(R.id.zhanshi);

        textView.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
       switch (v.getId())
       {
           case R.id.zhanshi:
               Intent intent=new Intent(this,CharViewAtivity.class);
               startActivity(intent);
               break;
       }
    }
}
