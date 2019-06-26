package com.codepath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends Activity {

    // text field containing updated item description
    EditText etItemText;
    // we need to track the item's position in the list
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        // resolve the text field from the layout
        etItemText = (EditText) findViewById(R.id.etItemText);
        // set the title bar to reflect the purpose of the view
        getActionBar().setTitle("Edit Item");
        position = getIntent().getExtras().getInt("position");
    }

    public void onSaveItem(View v) {
        // Prepare intent to pass back to MainActivity
        Intent data = new Intent();
        // Pass updated item text and original position
        data.putExtra("position", position); // ints work too
        data.putExtra("content", etItemText.getText().toString());
        setResult(RESULT_OK, data);
        finish(); // closes the edit activity, passes intent back to main
    }
}