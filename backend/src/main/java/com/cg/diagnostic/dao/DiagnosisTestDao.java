package com.cg.diagnostic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.diagnostic.entity.DiagnosisTest;
@Repository
public interface DiagnosisTestDao extends JpaRepository<DiagnosisTest,String> {

}
