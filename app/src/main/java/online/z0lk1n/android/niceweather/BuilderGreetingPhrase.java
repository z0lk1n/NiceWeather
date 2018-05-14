package online.z0lk1n.android.niceweather;

import java.util.Calendar;

public class BuilderGreetingPhrase {
    private int currentHour;
    private GreetingStrings greetingStrings;

    public BuilderGreetingPhrase(GreetingStrings greetingStrings) {
        this(greetingStrings, Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
    }

    BuilderGreetingPhrase(GreetingStrings greetingStrings, int currentHour) {
        this.greetingStrings = greetingStrings;
        this.currentHour = currentHour;
    }

    public String getGreetingPhrase() {
        String who = greetingStrings.getWho();
        String partDay;

        if (5 <= currentHour && currentHour < 12)
            partDay = greetingStrings.getMorning();
        else if (12 <= currentHour && currentHour < 18)
            partDay = greetingStrings.getAfternoon();
        else if (18 <= currentHour && currentHour < 21)
            partDay = greetingStrings.getEvening();
        else
            partDay = greetingStrings.getNight();

        return String.format("%s %s!", partDay, who);
    }
}

