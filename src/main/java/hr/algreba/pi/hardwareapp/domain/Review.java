package hr.algreba.pi.hardwareapp.domain;

import javax.persistence.*;

import hr.algreba.pi.hardwareapp.command.ReviewCommand;
import hr.algreba.pi.hardwareapp.command.ReviewUpdateCommand;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;
    private Long rating;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hardware hardware;

    public Review() {
    }

    public Review(ReviewCommand reviewCommand, Hardware hardware) {
        this.title = reviewCommand.getTitle();
        this.text = reviewCommand.getText();
        this.rating = reviewCommand.getRating();
        this.hardware = hardware;
    }

    public Review(Review review, ReviewUpdateCommand reviewUpdateCommand) {
        this.title = reviewUpdateCommand.getTitle();
        this.text = reviewUpdateCommand.getText();
        this.rating = reviewUpdateCommand.getRating();
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
