package hr.algreba.pi.hardwareapp.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class ReviewCommand {
    @NotBlank(message = "Title must not be empty")
    private String title;

    @NotBlank(message = "Text must not be empty")
    private String text;

    @PositiveOrZero(message = "Rating must be positive or zero")
    @Max(value = 5, message = "Rating can't be above 5")
    private Long rating;

    @NotBlank(message = "Hardware code must not be empty")
    private String hardwareCode;

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Long getRating() {
        return rating;
    }

    public String getHardwareCode() {
        return hardwareCode;
    }
}
