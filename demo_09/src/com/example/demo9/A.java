package com.example.demo9;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class A extends Activity {
    TextView tv;
    Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aaa);
        //根据id找到容器中的组件
        button =(Button)findViewById(R.id.button1);
        tv=(TextView)findViewById(R.id.textView1);
        //获取跳转对象
        Intent in = this.getIntent();
        String str=in.getExtras().getString("key");
        tv.setText(str);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Bundle bundle=new Bundle();
				bundle.putString("key", "500卷经文");
				Intent in = new Intent();
				in.putExtras(bundle);
				A.this.setResult(40, in);
				A.this.finish();
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
