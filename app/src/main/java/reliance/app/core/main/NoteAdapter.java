package reliance.app.core.main;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Alex on 11/11/2017.
 */

public class NoteAdapter extends ArrayAdapter<Notes> {


    public NoteAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Notes> notes) {
        super(context, resource, notes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);

        if(convertView == null){

            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.item_note, null);
        }

        Notes note = getItem(position);

        if(note != null){

            TextView title = (TextView) convertView.findViewById(R.id.list_note_title);
            TextView date = (TextView) convertView.findViewById(R.id.list_note_date);
            TextView content = (TextView) convertView.findViewById(R.id.list_note_content);

            title.setText(note.getTitle());
            date.setText(note.getDateTimeFormatted(getContext()));
            if(note.getContent().length() > 50){

                content.setText(note.getContent().substring(0,50));

            }else
                content.setText(note.getContent());
        }
            return convertView;
    }
}
