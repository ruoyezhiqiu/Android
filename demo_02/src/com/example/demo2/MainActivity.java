package com.example.demo2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	class MyEvent implements OnClickListener{
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String str="��Ե����ѽ��������̫���������̫��";
			tv.setText(str);
		}
	}
	TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //�ҵ��Ϸ��ϵ����
        Button button = (Button)findViewById(R.id.button1);
        tv=(TextView)findViewById(R.id.textView2);
        //�����¼�����
        button.setOnClickListener( new MyEvent());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}