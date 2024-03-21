package hr.algreba.pi.hardwareapp.service;

import hr.algreba.pi.hardwareapp.command.ReviewCommand;
import hr.algreba.pi.hardwareapp.command.ReviewUpdateCommand;
import hr.algreba.pi.hardwareapp.dto.ReviewDTO;

import java.util.Optional;
import java.util.Set;

public interface ReviewService {

    Set<ReviewDTO> findAll();

    Set<ReviewDTO> findAllByHardwareCode(String hardwareCode);

    Optional<ReviewDTO> save(ReviewCommand reviewCommand);

    Optional<ReviewDTO> update(Long id, ReviewUpdateCommand reviewUpdateCommand);

    void deleteById(Long id);
}
