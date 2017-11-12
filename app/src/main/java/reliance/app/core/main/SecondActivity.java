package reliance.app.core.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {


    private Button notes;
    private Button feedBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        notes =  findViewById(R.id.btnNotes);
        feedBack = findViewById(R.id.btnFeedBack);



        notes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, MakeNote.class);
                startActivity(intent);
            }
        });

        feedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, FeedHub.class);
                startActivity(intent);
            }
        });


    }


}
