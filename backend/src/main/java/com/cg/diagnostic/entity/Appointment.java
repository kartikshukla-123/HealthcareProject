package com.cg.diagnostic.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/*********************************************************************************************
 * @author Bhanu Prakash Kavuri
 * Class: Appointment
 *********************************************************************************************/
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="lpu_appointment")
public class Appointment {
	
	@Id
	@Column(name="appmt_id")
	private String apmtId;
	@Column(name="patient_name", length=30)
	private String patientName;
	@Column(name="contact_no")
	private long userContactNum;
	
	@Transient
	private boolean removeFlag;
	@ManyToOne
	@JoinColumn(name="slot_id", referencedColumnName = "test_slot_id")
	private CheckUpSlot slot = new CheckUpSlot();
	
	
	public Appointment() {
		super();
		
	}


	public String getApmtId() {
		return apmtId;
	}


	public void setApmtId(String apmtId) {
		this.apmtId = apmtId;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public long getUserContactNum() {
		return userContactNum;
	}


	public void setUserContactNum(long userContactNum) {
		this.userContactNum = userContactNum;
	}


	public CheckUpSlot getSlot() {
		return slot;
	}


	public void setSlot(CheckUpSlot slot) {
		this.slot = slot;
	}


	public boolean isRemoveFlag() {
		if(slot.getSlotDate().compareTo(LocalDate.now())>=0)
			this.removeFlag=true;
		else
			this.removeFlag=false;
		return removeFlag;
	}

   public boolean getRemoveFlag() {
	   if(slot.getSlotDate().compareTo(LocalDate.now())>=0)
			this.removeFlag=true;
		else
			this.removeFlag=false;
		return removeFlag;
   }
	public void setRemoveFlag(boolean removeFlag) {
		this.removeFlag = removeFlag;
	}

	
	
}
