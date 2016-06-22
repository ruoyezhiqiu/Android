package com.example.demo_11;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	int allId[]={R.id.imageView1,R.id.textView1,R.id.textView2,R.id.checkBox1};
	//������Ķ�Ӧ
	//��������
	String allName[]={"aaa","bbb","ccc","ddd"};
	int photo[]={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
	String name[]={"·��","�ǰ�","ɽ��","��¡"};
	String number[]={"028-142589","028-3692587","028-1473695","028-3691472"};
	boolean check[]={true,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //�������---��Map---��ArrayList
        
        ArrayList al=new ArrayList();
        for(int i=0;i<4;i++){
        	HashMap map = new HashMap();
        	map.put("aaa", photo[i]);
        	map.put("bbb", name[i]);
        	map.put("ccc", number[i]);
        	map.put("ddd", check[i]);
        	al.add(map);
        }
        
        //���ݺ����֮����н���������
        //1����ʾ�Ķ���������2��listview��ʾ�ĸ�ʽ��3��������4��ID
        SimpleAdapter sa = new SimpleAdapter(this,al,R.layout.each,allName,allId){
        	
        	//��дGetView�ķ�����Ϊ�˴���checkbox���¼�
        	public View getView(int position,View convertView,ViewGroup parent){
        		System.out.println("bbbbbbb");
        		//��ǰ�����view
        		View view =super.getView(position, convertView, parent);
        		//ÿһ�������
        		final HashMap hm=(HashMap)this.getItem(position);
        		//�ҵ�checkbox
        		CheckBox check=(CheckBox)view.findViewById(R.id.checkBox1);
        		//����checkbox�ĵ���¼�
        		check.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View parent) {
						hm.put("ddd", ((CheckBox)parent).isChecked());
					}
				});
        		
        		
        		return view;
        	}
        };
        //�ҵ�listview
        ListView lv = (ListView)findViewById(R.id.listView1);
        //��listview��������
        lv.setAdapter(sa);
       
        //listview�ĵ����Ϣ
        lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
				//��ȡ�������item����Ӧ������
				//�ҵ���ǰ����һ��
				HashMap<String,Object> map =(HashMap<String,Object>)parent.getItemAtPosition(position);
				//���������������߼�
				System.out.println("aaaaaaaaaaa");
				String name =(String)map.get("bbb");
				String code=(String)map.get("ccc");
				String check=((Boolean)map.get("ddd"))?"yes":"no";
				//���ڱ�������ʾ�������item�е�����
				MainActivity.this.setTitle(name+":"+code+":"+check);
				
				//�ڶ����ҵ��ؼ�����ʽ
				TextView tv1=(TextView)view.findViewById(R.id.textView1);
				TextView tv2=(TextView)view.findViewById(R.id.textView2);
				
				String all=tv1.getText().toString()+":"+tv2.getText().toString();
				Toast.makeText(MainActivity.this,all,1).show();
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