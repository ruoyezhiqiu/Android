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
        

        //���������ҵ����
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
        
        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        
        //��Ȩ�¼�
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
		//����ǵ����¼��ť
		if(arg0.getId()==R.id.button1){
			//��ȡ���������
			String str1 =et1.getText().toString();
			String str2 =et2.getText().toString();
			
			//�����ݷ��������
			Bundle bundle = new Bundle();
			bundle.putString("name", str1);
			bundle.putString("pass", str2);
			
			//����ʹ�߶���
			Intent in = new Intent();
			//ʹ��Я������
			in.putExtras(bundle);
			//���Ķ��������Ķ�ȥ
			in.setClass(MainActivity.this, To.class);
			//��ת
			startActivity(in);
		}
		if(arg0.getId()==R.id.button2){
			et1.setText("");
			et2.setText("");
		}
		
	}
    
}
