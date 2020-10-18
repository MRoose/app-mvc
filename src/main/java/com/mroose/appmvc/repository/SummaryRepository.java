package com.mroose.appmvc.repository;

import com.mroose.appmvc.model.Summary;
import com.mroose.appmvc.model.SummaryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, SummaryId> {

    Summary findByUsername(String username);

    Long deleteByUsername(String username);
}