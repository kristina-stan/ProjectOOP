package utilitys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateManager {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private LocalDate eventDate;

    public DateManager(String dateTotal) throws IllegalArgumentException {
        try {
            this.eventDate = LocalDate.parse(dateTotal, DateTimeFormatter.ISO_DATE); // Use ISO_DATE formatter for YYYY-MM-DD format
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Please provide date in yyyy-MM-dd format.");
        }
    }

    public boolean isValid() {
        LocalDate currentDate = LocalDate.now();
        LocalDate maxDateAllowed = currentDate.plusYears(4);

        return eventDate.isAfter(currentDate) && eventDate.isBefore(maxDateAllowed);
    }

    public LocalDate getDate() {
        return eventDate;
    }
}
