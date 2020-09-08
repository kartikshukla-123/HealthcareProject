package com.cg.diagnostic.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.diagnostic.dao.CheckUpSlotDao;
import com.cg.diagnostic.dao.DiagnosisTestDao;
import com.cg.diagnostic.dto.SlotDto;
import com.cg.diagnostic.entity.CheckUpSlot;
import com.cg.diagnostic.entity.DiagnosisTest;
import com.cg.diagnostic.exceptions.SlotException;
import com.cg.diagnostic.util.SlotConstants;
@Service
@Transactional
public class SlotServiceImpl implements ISlotService {
	private Logger  logger= LoggerFactory.getLogger(SlotServiceImpl.class);
	@Autowired
private CheckUpSlotDao slotDao;
	
	@Autowired
	private DiagnosisTestDao diagnosisDao;
	
	@Override
	public String addSlot(SlotDto slotDto) throws SlotException{
		Optional<DiagnosisTest>opt=diagnosisDao.findById(slotDto.getDiagnosticTestId());
		if(!opt.isPresent())
			throw new SlotException(SlotConstants.CENTRE_TEST_NOT_FOUND);
		DiagnosisTest dTest=opt.get();
		int count=slotDao.getCountByCentreTest(slotDto.getDiagnosticTestId())+SlotConstants.INCREMENT;
		String slotId=slotDto.getDiagnosticTestId()+SlotConstants.EMPTY+count;
		CheckUpSlot slot=new CheckUpSlot();
		slot.setSlotDate(slotDto.getSlotDate());
		slot.setNumOfApp(slotDto.getNoOfAppointments());
		slot.setTestSlotId(slotId);
		slot.setAmt(slotDto.getAmount());
		slot.setDiagnosisTest(dTest);
		slotDao.save(slot);
		return SlotConstants.SLOT_CREATED;
	}
	@Override
	public List<CheckUpSlot> getSlot(String testId) throws SlotException {
		List<CheckUpSlot> slots=slotDao.getSlots(testId);
		logger.info(slots.size()+"");
		if(slots.isEmpty())
			throw new SlotException(SlotConstants.SLOT_NOT_AVAILABLE);
		slots=slots.stream().filter(s->s.getSlotDate().isAfter(LocalDate.now()) || s.getSlotDate().isEqual(LocalDate.now())).collect(Collectors.toList());
		logger.info(slots.size()+"");
		if(slots.isEmpty())
			throw new SlotException(SlotConstants.SLOT_NOT_AVAILABLE);
		slots.sort((s1,s2)->s1.getSlotDate().compareTo(s2.getSlotDate()));
 		return slots;
	}

}
