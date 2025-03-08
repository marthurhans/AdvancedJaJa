package edu.wgu.d387_sample_code;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/timezones")
public class TimeZoneController {

    private final TimeZoneFormatter timeZoneFormatter = new TimeZoneFormatter();

    @GetMapping
    public Map<String, String> getTimeZones() {
        Map<String, String> timeZones = new HashMap<>();
        timeZones.put("Eastern Time", timeZoneFormatter.getEasternTime());
        timeZones.put("Mountain Time", timeZoneFormatter.getMountainTime());
        timeZones.put("UTC Time", timeZoneFormatter.getUtcTime());
        return timeZones;
    }
}
