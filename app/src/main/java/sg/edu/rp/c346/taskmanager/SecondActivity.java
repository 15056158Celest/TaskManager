package sg.edu.rp.c346.taskmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText etName, etDescription, etTime;
    Button btnAdd, btnCancel;
    int reqCode = 12345;

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
                String time = etTime.getText().toString();
                int Time = Integer.parseInt(time);

                DBHelper dbh = new DBHelper(SecondActivity.this);
                long adding = dbh.insertTask(name,desc);
                dbh.close();

                if (adding != -1){
                    Toast.makeText(SecondActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }

                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND,Time);

                //Task task = new Task(name,desc);

                Intent intent = new Intent(SecondActivity.this, TaskManagerReciever.class);
                intent.putExtra("name",name);
                intent.putExtra("desc",desc);
                int fakeID = Integer.parseInt(String.valueOf(adding));
                int total = fakeID + 2;
                intent.putExtra("ID",total+"");

                PendingIntent pendingIntent = PendingIntent.getBroadcast(SecondActivity.this,reqCode,intent, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP,cal.getTimeInMillis(),pendingIntent);


                finish();
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
