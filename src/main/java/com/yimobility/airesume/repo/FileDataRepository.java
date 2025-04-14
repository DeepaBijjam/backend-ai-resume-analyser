package com.yimobility.airesume.repo;

import com.yimobility.airesume.Model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDataRepository extends JpaRepository<Resume, Long> {
}
