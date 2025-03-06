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
        // Create runnable instances
        WelcomeMessageThread englishRunnable = new WelcomeMessageThread(Locale.ENGLISH);
        WelcomeMessageThread frenchRunnable = new WelcomeMessageThread(Locale.FRANCE);

        // Create threads
        Thread englishThread = new Thread(englishRunnable);
        Thread frenchThread = new Thread(frenchRunnable);

        // Start threads
        englishThread.start();
        frenchThread.start();

        // Wait for threads to finish
        englishThread.join();
        frenchThread.join();

        // Collect the messages into a list
        List<String> messages = new ArrayList<>();
        messages.add(englishRunnable.getMessage());
        messages.add(frenchRunnable.getMessage());

        return messages; // Automatically converted to JSON
    }
}
