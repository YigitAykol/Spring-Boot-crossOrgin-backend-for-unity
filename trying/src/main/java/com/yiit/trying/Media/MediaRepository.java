package com.yiit.trying.Media;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MediaRepository extends JpaRepository<media, Long> {

    @Query("SELECT s FROM media s WHERE s.name = ?1")
    Optional<media> findMediaByName(String name);
}
