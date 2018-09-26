package com.wallethub.repository;

import com.wallethub.model.LogParams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface LogParamsRepository extends JpaRepository<LogParams, String> {

    @Query(value = "SELECT * FROM log_params  WHERE " +
            "log_Date between :startDate and :endDate " +
            "group by logip having count(logip)>= :threshold",
            nativeQuery = true
    )
    List<LogParams> analyzeLogParams(@Param("startDate") String startDate, @Param("endDate") String endDate, @Param("threshold") String threshold);


}
