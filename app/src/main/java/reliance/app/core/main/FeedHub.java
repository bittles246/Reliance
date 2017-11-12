package reliance.app.core.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class FeedHub extends AppCompatActivity {

    int val = 0;

    private Button submit;
    private EditText rate;
    private  EditText comment;

    private ArrayList<String> comments = new ArrayList<>();
    private ArrayList<Integer> rates = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_hub);

        submit =  findViewById(R.id.btnFSubmit);
        rate =  findViewById(R.id.et_num_rate);
        comment =  findViewById(R.id.et_comm_rate);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                val = Integer.parseInt( rate.getText().toString() );
                validate(val);

            }
        });

    }

    private void validate(int n){
        if(n >= 1 && n <= 5)
        {

            rates.add(val);
            comments.add(comment.getText().toString());
            AlertDialog.Builder dialog = new AlertDialog.Builder(FeedHub.this)
                    .setTitle("Feedback")
                    .setMessage("Your feedback has been received, thank you.")
                    .setPositiveButton("Continue", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {

                            finish();
                        }})
                    .setCancelable(false);

            dialog.show();


        }else{
            AlertDialog.Builder dialog = new AlertDialog.Builder(FeedHub.this)
                    .setTitle("Error")
                    .setMessage("Please enter a number between 1 and 10.")
                    .setCancelable(true);
                     dialog.show();
        }

    }

}
