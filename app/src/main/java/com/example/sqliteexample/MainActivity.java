package com.example.sqliteexample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	EditText editTextPhone, editTextName, editTextEmail;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editTextPhone = (EditText)findViewById(R.id.editTextPhone);
		editTextName = (EditText)findViewById(R.id.editTextName);
		editTextEmail = (EditText)findViewById(R.id.editTextEmail);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void callRegister(View v){
		UserSQLHelper dbHelper = new UserSQLHelper(this);

		//Prepare data
		UserRecord record = new UserRecord();
		record.setPhone(editTextPhone.getText().toString());
		record.setName(editTextName.getText().toString());
		record.setEmail(editTextEmail.getText().toString());

		dbHelper.insertUser(record);
	}

	public void retrieveRecord(View v){
		Intent intent = new Intent(this, ShowUserActivity.class);
		startActivity(intent);
	}
	
}
