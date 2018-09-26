package com.wallethub.repository;

import com.wallethub.model.LogComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository

public interface LogCommentsRepository extends JpaRepository<LogComments, String> {


}
