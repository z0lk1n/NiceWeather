package online.z0lk1n.android.niceweather;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greeting = findViewById(R.id.greeting);
        greeting.setText(greetingPhrase());
    }

    private String greetingPhrase() {
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        Resources resources = getResources();
        String who = resources.getString(R.string.who);
        String partDay;

        if (5 <= currentHour && currentHour < 12)
            partDay = resources.getString(R.string.morning);
        else if (12 <= currentHour && currentHour < 6)
            partDay = resources.getString(R.string.afternoon);
        else if (6 <= currentHour && currentHour < 9)
            partDay = resources.getString(R.string.evening);
        else
            partDay = resources.getString(R.string.night);

        return String.format("%s %s!", partDay, who);
    }
}
