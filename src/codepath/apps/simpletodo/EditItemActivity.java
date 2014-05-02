package codepath.apps.simpletodo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditItemActivity extends Activity {
	int pos;
	String itemText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_item);
		pos = getIntent().getIntExtra("position", -1);
	    itemText = getIntent().getStringExtra("itemText");
		Log.d("####################","pos: " +pos+ " itemText: "+ itemText);
		EditText et = (EditText) findViewById(R.id.editText1);
		et.setText(itemText);
		et.requestFocus();
		et.setSelection(et.getText().length());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_edit_item, menu);  
		return true;
	}
	
	public void onSave(View v){
		  EditText et = (EditText) findViewById(R.id.editText1);
		  // Prepare data intent 
		  Intent data = new Intent();
		  // Pass relevant data back as a result
		  data.putExtra("itemValue", et.getText().toString());
		  data.putExtra("itemPos", pos);
		  // Activity finished ok, return the data
		  setResult(RESULT_OK, data); // set result code and bundle data for response
		  finish(); // closes the activity, pass data to parent
	}

}
