package com.iteyes10.taskProject.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iteyes10.taskProject.domain.Contents;

@Repository
public interface ContentsRepository extends JpaRepository<Contents, Integer> {

    @Query("select data from Contents data where data.type = :type")
    @SuppressWarnings("null")
    public Page<Contents> findByType(Pageable pageable, @Param("type") String type);
}
