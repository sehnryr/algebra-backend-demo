package hr.algreba.pi.hardwareapp.service;

import hr.algreba.pi.hardwareapp.command.ReviewCommand;
import hr.algreba.pi.hardwareapp.command.ReviewUpdateCommand;
import hr.algreba.pi.hardwareapp.domain.Review;
import hr.algreba.pi.hardwareapp.dto.ReviewDTO;
import hr.algreba.pi.hardwareapp.repository.HardwareRepository;
import hr.algreba.pi.hardwareapp.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final HardwareRepository hardwareRepository;
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(HardwareRepository hardwareRepository, ReviewRepository reviewRepository) {
        this.hardwareRepository = hardwareRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Set<ReviewDTO> findAll() {
        return reviewRepository.findAll().stream().map(ReviewDTO::new).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Set<ReviewDTO> findAllByHardwareCode(String hardwareCode) {
        return reviewRepository.findAllByHardware_Code(hardwareCode).stream().map(ReviewDTO::new).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Optional<ReviewDTO> save(ReviewCommand reviewCommand) {
        return Optional.of(new ReviewDTO(reviewRepository.save(
                new Review(
                        reviewCommand,
                        hardwareRepository.findByCode(reviewCommand.getHardwareCode()).orElseThrow()))));
    }

    @Override
    public Optional<ReviewDTO> update(Long id, ReviewUpdateCommand reviewUpdateCommand) {
        int affectedRows = reviewRepository.updateReviewTitleTextRatingForId(id,
                reviewUpdateCommand.getTitle(),
                reviewUpdateCommand.getText(),
                reviewUpdateCommand.getRating());

        if (affectedRows == 0) {
            return Optional.empty();
        }

        return Optional.of(new ReviewDTO(reviewRepository.getById(id)));
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
        reviewRepository.flush();
    }
}
