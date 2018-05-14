package online.z0lk1n.android.niceweather;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreetingUnitTest {
    GreetingStrings greetingStrings = new GreetingStrings() {
        @Override
        public String getWho() {
            return "Master";
        }

        @Override
        public String getMorning() {
            return "Good morning";
        }

        @Override
        public String getAfternoon() {
            return "Good afternoon";
        }

        @Override
        public String getEvening() {
            return "Good evening";
        }

        @Override
        public String getNight() {
            return "Good night";
        }
    };

    @Test
    public void BuilderGreetingPhrase_Morning_Test() throws Exception {
        BuilderGreetingPhrase greetingPhrase = new BuilderGreetingPhrase(greetingStrings, 9);
        String expected = "Good morning Master!";
        String actual = greetingPhrase.getGreetingPhrase();
        assertEquals(expected, actual);
    }

    @Test
    public void BuilderGreetingPhrase_Afternoon_Test() throws Exception {
        BuilderGreetingPhrase greetingPhrase = new BuilderGreetingPhrase(greetingStrings, 12);
        String expected = "Good afternoon Master!";
        String actual = greetingPhrase.getGreetingPhrase();
        assertEquals(expected, actual);
    }

    @Test
    public void BuilderGreetingPhrase_Evening_Test() throws Exception {
        BuilderGreetingPhrase greetingPhrase = new BuilderGreetingPhrase(greetingStrings, 18);
        String expected = "Good evening Master!";
        String actual = greetingPhrase.getGreetingPhrase();
        assertEquals(expected, actual);
    }

    @Test
    public void BuilderGreetingPhrase_Night_Test() throws Exception {
        BuilderGreetingPhrase greetingPhrase = new BuilderGreetingPhrase(greetingStrings, 21);
        String expected = "Good night Master!";
        String actual = greetingPhrase.getGreetingPhrase();
        assertEquals(expected, actual);
    }
}
