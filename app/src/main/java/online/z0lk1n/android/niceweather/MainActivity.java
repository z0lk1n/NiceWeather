package online.z0lk1n.android.niceweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GreetingStrings {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greeting = findViewById(R.id.greeting);
        BuilderGreetingPhrase greetingPhrase = new BuilderGreetingPhrase(this);
        greeting.setText(greetingPhrase.getGreetingPhrase());
    }

    @Override
    public String getWho() {
        return getResources().getString(R.string.who);
    }

    @Override
    public String getMorning() {
        return getResources().getString(R.string.morning);
    }

    @Override
    public String getAfternoon() {
        return getResources().getString(R.string.afternoon);
    }

    @Override
    public String getEvening() {
        return getResources().getString(R.string.evening);
    }

    @Override
    public String getNight() {
        return getResources().getString(R.string.night);
    }
}
