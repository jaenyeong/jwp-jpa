package jpa.com.jaenyeong.domain.station;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StationRepository extends JpaRepository<Station, Long> {
    Optional<Station> findByName(String name);
    Optional<Station> findById(Long id);
}
