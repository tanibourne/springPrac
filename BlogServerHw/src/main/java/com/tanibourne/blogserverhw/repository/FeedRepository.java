package com.tanibourne.blogserverhw.repository;

import com.tanibourne.blogserverhw.models.Feed;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface FeedRepository extends JpaRepository<Feed,Long> {

    List<Feed> findAllByOrderByCreatedAtDesc();
}
