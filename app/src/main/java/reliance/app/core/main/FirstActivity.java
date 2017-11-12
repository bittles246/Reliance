package reliance.app.core.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private  EditText mood;
    private Button forward;
    private int val = 0;
    private String[] myStrings = {"Drink a glass of water and head outside for a walk!", "Take a look outside and enjoy the scenery",
        "Take a 5 minute break and clear your mind before taking on the days activities","Call a friend and say hello!","Call a friend and make some plans!"
           ,"Do not forget to eat a healthy breakfast everyday!","Glad to hear your okay! don't forget to take study breaks.","Keep it up and have a good day!"
            ,"Awesome continue doing what your doing!","Time to Party!"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        forward =  findViewById(R.id.btnContinue);
        mood =  findViewById(R.id.et_num);

        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                val = Integer.parseInt( mood.getText().toString() );
                validate(val);




            }
        });

    }

    private void validate(int n){
        if(n >= 1 && n <= 10)
        {


            AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this)
                    .setTitle("Your Quote for the day!")
                    .setMessage("Quote:  " + myStrings[val - 1])
                    .setCancelable(false)
                    .setPositiveButton("Continue", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                            startActivity(intent);
                        }
                    });

            dialog.show();


        }else{
            AlertDialog.Builder dialog = new AlertDialog.Builder(FirstActivity.this)
                    .setTitle("Error")
                    .setMessage("Please enter a number between 1 and 10.")
                    .setCancelable(true);
                     dialog.show();

        }


    }}
