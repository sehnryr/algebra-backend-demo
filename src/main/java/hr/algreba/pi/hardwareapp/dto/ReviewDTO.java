package hr.algreba.pi.hardwareapp.dto;

import hr.algreba.pi.hardwareapp.domain.Review;

public class ReviewDTO {

    private Long id;
    private String title;
    private String text;
    private Long rating;

    public ReviewDTO(Review review) {
        this.id = review.getId();
        this.title = review.getTitle();
        this.text = review.getText();
        this.rating = review.getRating();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public Long getRating() {
        return rating;
    }
}
