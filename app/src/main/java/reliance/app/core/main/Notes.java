package reliance.app.core.main;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Alex on 11/11/2017.
 */

public class Notes implements Serializable {


    private long mDateTime;
    private String mTitle;
    private String mContent;

    public Notes(long DateTime, String Title, String Content) {
        this.mDateTime = DateTime;
        this.mTitle = Title;
        this.mContent = Content;
    }

    public void setDateTime(long DateTime) {
        this.mDateTime = DateTime;
    }

    public void setTitle(String Title) {
        this.mTitle = Title;
    }

    public void setContent(String Content) {
        this.mContent = Content;
    }

    public long getDateTime() {
        return mDateTime;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getContent() {
        return mContent;
    }

    public String getDateTimeFormatted(Context context){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", context.getResources().getConfiguration().locale);
        sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(new Date(mDateTime));

    }

}