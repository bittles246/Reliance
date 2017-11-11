package reliance.app.core.main;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    private EditText mEtTitle;
    private EditText mETContent;

    private String mNoteFileName;
    private Notes mLoadedNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        mEtTitle = (EditText) findViewById(R.id.note_et_title);
        mETContent = (EditText) findViewById(R.id.note_et_content);

        mNoteFileName = getIntent().getStringExtra("NOTE_FILE");
        if(mNoteFileName != null && !mNoteFileName.isEmpty()){
            mLoadedNote = Utilities.getNoteByName(this,mNoteFileName);

            if(mLoadedNote != null){
                mEtTitle.setText(mLoadedNote.getTitle());
                mETContent.setText(mLoadedNote.getContent());
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_noteact_new,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){

            case R.id.action_note_save:
                saveNote();

            case R.id.action_note_delete:
                deleteNote();

                break;


        }

        return true;

    }


    private void saveNote() {

        Notes note;

        if (mEtTitle.getText().toString().trim().isEmpty() || mETContent.getText().toString().trim().isEmpty()){
            Toast.makeText(this, "Please enter a title and content", Toast.LENGTH_SHORT).show();
        return;
    }

        if(mLoadedNote == null){
             note = new Notes(System.currentTimeMillis(),mEtTitle.getText().toString(), mETContent.getText().toString());
        }else{
             note = new Notes(mLoadedNote.getDateTime(),mEtTitle.getText().toString(), mETContent.getText().toString());
        }


        if(Utilities.saveNote(this,note)){
            Toast.makeText(this, "Your Note is Saved!", Toast.LENGTH_SHORT).show();
            finish();
        }else
            Toast.makeText(this, "Cannot save the note, please make sure you have enough storage space.", Toast.LENGTH_LONG).show();

        finish();
    }

    private void deleteNote(){
        if(mLoadedNote == null){
            finish();
        }else{

            AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                    .setTitle("Are you sure?")
                    .setMessage("Your are about to delete " + mEtTitle.getText().toString() + ", are you sure?" )
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            Utilities.deleteNote(getApplicationContext()
                                    , mLoadedNote.getDateTime() + Utilities.FILE_EXTENSION);
                            Toast.makeText(getApplicationContext()
                                    , mEtTitle.getText().toString() + "is deleted.",Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    })
                    .setNegativeButton("No", null)
                    .setCancelable(false);

                dialog.show();


        }


    }
}
