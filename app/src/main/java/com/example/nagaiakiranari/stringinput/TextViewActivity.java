package com.example.nagaiakiranari.stringinput;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by nagaiakiranari on 2016/10/11.
 */

public class TextViewActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_text);

        Intent intent = getIntent();
        String str = intent.getStringExtra("text");

        if(str != null) {
            TextView textView = (TextView)findViewById(R.id.viewText);
            textView.setText("入力した文字列は\n" + str);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}

