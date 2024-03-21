package hr.algreba.pi.hardwareapp.repository;

import hr.algreba.pi.hardwareapp.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

import javax.transaction.Transactional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Set<Review> findAllByHardware_Code(String hardwareCode);

    void deleteAllByHardware_Code(String hardwareCode);

    @Modifying
    @Query(value = "UPDATE Review r SET r.title = :title, r.text = :text, r.rating = :rating WHERE r.id = :id", nativeQuery = true)
    @Transactional // https://github.com/spring-projects/spring-boot/issues/3576#issuecomment-123721789
    int updateReviewTitleTextRatingForId(
            @Param("id") Long id,
            @Param("title") String title,
            @Param("text") String text,
            @Param("rating") Long rating);
}
