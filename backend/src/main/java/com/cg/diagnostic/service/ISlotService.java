package com.cg.diagnostic.service;

import java.util.List;

import com.cg.diagnostic.dto.SlotDto;
import com.cg.diagnostic.entity.CheckUpSlot;
import com.cg.diagnostic.exceptions.SlotException;

public interface ISlotService {
	
public String addSlot(SlotDto slotDto)throws SlotException;

public List<CheckUpSlot> getSlot(String testd)throws SlotException;

}
