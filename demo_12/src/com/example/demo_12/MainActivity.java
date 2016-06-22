package com.example.demo_12;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1.添加一个aaa.xml
        //布局反射类，根据一个布局xml文件，可以形成一个view对象
        LayoutInflater inflater = this.getLayoutInflater();
        //根据xml形成view
        View view = inflater.inflate(R.layout.aaa, null);
        //找到view里面的内容
        
        Button button=(Button)view.findViewById(R.id.button1);
        TextView tv =(TextView)view.findViewById(R.id.textView1);
        tv.setText("清华大学");
        
        //生成提示框对象
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        //把我们的xml对应的view贴在提示框上
        builder.setView(view);
        //弹出提示框，返回dialog对象
        final Dialog dlg =builder.show();
        //做按钮的事件
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				dlg.dismiss();
			}
		});
        

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
