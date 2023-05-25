package com.microprac.springbootkafkaconsumer.repository;

import com.microprac.springbootkafkaconsumer.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<WikimediaData, String> {
}
