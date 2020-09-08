package com.cg.diagnostic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.diagnostic.entity.Appointment;

public interface AppointmentDao extends JpaRepository<Appointment, String>
{

	List<Appointment> findAll();
	

}
