package com.example.nagaiakiranari.stringinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import android.content.ContentValues;

public class MainActivity extends AppCompatActivity {
    private String text = null;


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) findViewById(R.id.editText);
                text = editText.getText().toString();

                try {
                    writeDB(editText.getText().toString());
                } catch (Exception e) {
                    toast("書き込み失敗しました。");
                }

                Intent intent = new Intent(MainActivity.this, TextViewActivity.class);
                intent.putExtra("text", text);

                startActivity(intent);
            }
        });
    }

    private void writeDB(String text) throws Exception {
        //コンテンツプロバイダが提供するデータベースを示すURI
        Uri uri=Uri.parse("content://com.example.nagaiakiranari.inputdbprovider");

        //コンテンツプロバイダが提供するデータベースへのアクセス
        ContentValues values = new ContentValues();
        values.put("text", text);
        int num=getContentResolver().update(uri, values, null, null);
        if (num == 0) getContentResolver().insert(uri,values);
    }

    private void toast(String text) {
        if (text == null) text = "";
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
