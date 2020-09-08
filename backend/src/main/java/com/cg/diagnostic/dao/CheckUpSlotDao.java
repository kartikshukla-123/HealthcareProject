package com.cg.diagnostic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.diagnostic.entity.CheckUpSlot;
@Repository
public interface CheckUpSlotDao extends JpaRepository<CheckUpSlot,String>{

	@Query(" select count(s.testSlotId)from CheckUpSlot s where s.diagnosisTest.diagnosisTestId=:tid")
	public int getCountByCentreTest(@Param("tid") String diagnosisId);
	
	@Query("from CheckUpSlot s where s.diagnosisTest.diagnosisTestId=:tid")
	public List<CheckUpSlot> getSlots(@Param("tid") String diagnosisTestId);

}
