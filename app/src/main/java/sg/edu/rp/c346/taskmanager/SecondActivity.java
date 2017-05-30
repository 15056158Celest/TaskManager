package sg.edu.rp.c346.taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText etName, etDescription, etTime;
    Button btnAdd, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etName = (EditText) findViewById(R.id.editTextName);
        etDescription = (EditText) findViewById(R.id.editTextDescription);
        etTime = (EditText) findViewById(R.id.etSeconds);
        btnAdd = (Button) findViewById(R.id.btnAddTask);
        btnCancel = (Button) findViewById(R.id.btnCancel);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String desc = etDescription.getText().toString();
                DBHelper dbh = new DBHelper(SecondActivity.this);
                long row_affected = dbh.insertTask(name, desc);
                dbh.close();

                if (row_affected != -1){
                    Toast.makeText(SecondActivity.this, "INSERT SUCCESSFUL",
                            Toast.LENGTH_SHORT).show();
                }

                Intent i = new Intent(SecondActivity.this,
                        MainActivity.class);

                startActivity(i);
            }
        });



    }
}
