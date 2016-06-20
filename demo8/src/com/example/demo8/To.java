package com.example.demo8;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;

public class To extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.to);
        //�Ӵ�ʹ�߶���
        Intent in =this.getIntent();
        //��ȡ����
        Bundle bundle = in.getExtras();
        //�Ӱ����л�ȡ����
        String name = bundle.getString("name");
        String pass = bundle.getString("pass");
        EditText et1 = (EditText)findViewById(R.id.editText1);
        EditText et2 = (EditText)findViewById(R.id.editText2);
        et1.setText(name);
        et2.setText(pass);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}