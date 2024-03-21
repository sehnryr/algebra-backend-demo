package hr.algreba.pi.hardwareapp.controller;

import hr.algreba.pi.hardwareapp.command.ReviewCommand;
import hr.algreba.pi.hardwareapp.command.ReviewUpdateCommand;
import hr.algreba.pi.hardwareapp.dto.ReviewDTO;
import hr.algreba.pi.hardwareapp.service.ReviewService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;

import javax.validation.Valid;

@RestController
@RequestMapping("review")
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public Set<ReviewDTO> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping(params = "hardwareCode")
    public Set<ReviewDTO> getAllReviewsByHardwareCode(@RequestParam String hardwareCode) {
        return reviewService.findAllByHardwareCode(hardwareCode);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ReviewDTO save(@Valid @RequestBody final ReviewCommand command) {
        return reviewService.save(command)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.CONFLICT,
                        "Hardware with the same code already exists"));
    }

    @PutMapping("{id}")
    public ReviewDTO update(@PathVariable Long id,
            @Valid @RequestBody final ReviewUpdateCommand updatedHardwareCommand) {
        return reviewService.update(id, updatedHardwareCommand)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hardware was not found by that code"));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}
