package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TimeZoneController {

    private final TimeZoneFormatter timeZoneFormatter = new TimeZoneFormatter();

    @GetMapping("/live-presentation")
    public String getLivePresentationMessage() {
        return timeZoneFormatter.getLivePresentationMessage();
    }
}
