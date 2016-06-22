package com.example.demo8;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {
	EditText et1;
	EditText et2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        

        //从容器中找到组件
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        
        //授权事件
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		//如果是点击登录按钮
		if(arg0.getId()==R.id.button1){
			//获取输入的内容
			String str1 =et1.getText().toString();
			String str2 =et2.getText().toString();
			
			//把内容放入包裹内
			Bundle bundle = new Bundle();
			bundle.putString("name", str1);
			bundle.putString("pass", str2);
			
			//生成使者对象
			Intent in = new Intent();
			//使者携带包裹
			in.putExtras(bundle);
			//从哪儿来，到哪儿去
			in.setClass(MainActivity.this, To.class);
			//跳转
			startActivity(in);
		}
		if(arg0.getId()==R.id.button2){
			et1.setText("");
			et2.setText("");
		}
		
	}
    
}
