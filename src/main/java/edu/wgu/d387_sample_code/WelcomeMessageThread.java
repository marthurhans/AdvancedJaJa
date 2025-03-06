package edu.wgu.d387_sample_code;

import java.util.Locale;
import java.util.ResourceBundle;

public class WelcomeMessageThread implements Runnable{

    private final Locale locale;
    private String message;

    public WelcomeMessageThread(Locale locale) {
        this.locale = locale;
    }

    @Override
    public void run() {
        ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
        message = bundle.getString("welcome");
    }

    public String getMessage() {
        return message;
    }
}
