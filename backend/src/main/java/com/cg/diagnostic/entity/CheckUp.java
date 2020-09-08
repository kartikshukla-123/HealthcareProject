package com.cg.diagnostic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/*********************************************************************************************
 * @author Bhanu Prakash Kavuri
 * Class: CheckUp
 *********************************************************************************************/
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="checkup")
public class CheckUp {
	
	@Id
	@Column(name="test_id")
	private String testId;
	@Column(name="test_name")
	private String testName;
	@Column(name="test_desc")
	private String testDesc;
	
	
	
	

	/*****************************************************************************************
	 * Method: Constructor method - CheckUp
	 * @param testId
	 * @param testName
	 * @param amount
	 *****************************************************************************************/
	public CheckUp() {
		super();
		
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getTestDesc() {
		return testDesc;
	}

	public void setTestDesc(String testDesc) {
		this.testDesc = testDesc;
	}

}
