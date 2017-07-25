package com.example.sqliteexample;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ShowUserActivity extends ListActivity  implements AdapterView.OnItemClickListener{
	private UserSQLHelper dbHelper;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dbHelper = new UserSQLHelper(this);

		final List<UserRecord> values = dbHelper.getAllUsers();
		
		setListAdapter(new ArrayAdapter<UserRecord>(this, 
				android.R.layout.simple_list_item_2, 
				android.R.id.text1,  //this will be ignored by getView
				values){
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent){
				
				//Must return a View
				View view = super.getView(position, convertView, parent);
				
				UserRecord entry = values.get(position);
				
				TextView text1 = (TextView) view.findViewById(android.R.id.text1);
				TextView text2 = (TextView) view.findViewById(android.R.id.text2);
				text1.setText(entry.getName());
				text2.setText("Phone: " + entry.getPhone() + " Email: " + entry.getEmail());
				return view;
			}
		});
	}

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(), "Position" + i, Toast.LENGTH_SHORT).show();
    }
}
