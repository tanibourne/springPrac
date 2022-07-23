package com.tanibourne.week01hw.repository;

import com.tanibourne.week01hw.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
