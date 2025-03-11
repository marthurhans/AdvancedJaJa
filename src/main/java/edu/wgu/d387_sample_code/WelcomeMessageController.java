package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class WelcomeMessageController {

    @GetMapping("/api/welcome")
    public List<String> getWelcomeMessages() throws InterruptedException {
        WelcomeMessageThread englishRunnable = new WelcomeMessageThread(Locale.ENGLISH);
        WelcomeMessageThread frenchRunnable = new WelcomeMessageThread(Locale.FRANCE);

        Thread englishThread = new Thread(englishRunnable);
        Thread frenchThread = new Thread(frenchRunnable);

        englishThread.start();
        frenchThread.start();

        englishThread.join();
        frenchThread.join();

        List<String> messages = new ArrayList<>();
        messages.add(englishRunnable.getMessage());
        messages.add(frenchRunnable.getMessage());

        return messages;
    }
}
