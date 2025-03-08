package edu.wgu.d387_sample_code;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimeZoneFormatter {

    private final String easternTime;
    private final String mountainTime;
    private final String utcTime;

    public TimeZoneFormatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm z");

        this.easternTime = ZonedDateTime.now(ZoneId.of("America/New_York")).format(formatter);
        this.mountainTime = ZonedDateTime.now(ZoneId.of("America/Denver")).format(formatter);
        this.utcTime = ZonedDateTime.now(ZoneId.of("UTC")).format(formatter);
    }

    public String getEasternTime() {
        return easternTime;
    }

    public String getMountainTime() {
        return mountainTime;
    }

    public String getUtcTime() {
        return utcTime;
    }

    public String getLivePresentationMessage() {
        return "Our live presentation from the Landon Hotel is happening now:\n" +
                "Eastern Time: " + easternTime + "\n" +
                "Mountain Time: " + mountainTime + "\n" +
                "UTC Time: " + utcTime;
    }
}

