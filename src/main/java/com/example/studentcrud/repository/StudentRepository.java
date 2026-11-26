
package com.example.studentcrud.repository;

import com.example.studentcrud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Transactional
    @Modifying
    @Query("delete from Student s where s.rollNo = :rollNo")
    int deleteByRollNo(@Param("rollNo") String rollNo);
}
