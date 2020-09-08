package com.cg.diagnostic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.diagnostic.entity.CheckUp;

public interface CheckUpDao extends JpaRepository<CheckUp, String>{

}
