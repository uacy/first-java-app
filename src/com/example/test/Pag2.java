package com.example.test;
import java.util.ArrayList;

import android.app.ListActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;

import android.widget.ListView;
import android.widget.Toast;

public class Pag2 extends ListActivity {
	Button btn;
    ArrayList<String> nume;
    ListView lista;
    ArrayAdapter<String> adapter;
    
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        lista = (ListView) findViewById(android.R.id.list);

        nume = new ArrayList<String>();
        nume.add("Naruto"); nume.add("Sasuke");
        nume.add("Sakura"); nume.add("Orochimaru");
        nume.add("Jyraia"); nume.add("Tsunade");

        
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nume);
        setListAdapter(adapter);

        lista.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adaptor, View arg1, int position,
                    long id) {
                Toast.makeText(Pag2.this, "Click "+ adaptor.getItemAtPosition(position)+ "?", Toast.LENGTH_LONG).show()    ;
            }
            

        });
        
        lista.setOnItemLongClickListener(new OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                    int pos, long id) {
				nume.remove(pos);
				adapter.notifyDataSetChanged();

                return true;
            }
        });
        
/*        lista.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(AdapterView<?> adaptor, View arg1, int position,
                    long id) {
				nume.remove(nume);
				adapter.notifyDataSetChanged();
				return true;
			}
			
		});*/
        btn = (Button)findViewById(R.id.b1);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				nume.add("Madara");
				adapter.notifyDataSetChanged();
			}
		});        
	}


}
