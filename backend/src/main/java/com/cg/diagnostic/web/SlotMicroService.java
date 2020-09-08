package com.cg.diagnostic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.diagnostic.dto.SlotDto;
import com.cg.diagnostic.dto.SlotMessage;
import com.cg.diagnostic.entity.CheckUpSlot;
import com.cg.diagnostic.exceptions.SlotException;
import com.cg.diagnostic.service.ISlotService;
import com.cg.diagnostic.util.SlotConstants;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SlotMicroService {

	@Autowired
	private ISlotService slotService;
	@PostMapping(SlotConstants.ADD_SLOT_URL)
	public SlotMessage addSlot(@RequestBody SlotDto slotDto) throws SlotException {
		
		String res =slotService.addSlot(slotDto);
		return new SlotMessage(res);
	}
	
	
	@GetMapping(SlotConstants.VIEW_SLOT_URL)
	public List<CheckUpSlot> viewSlot(@PathVariable("tid") String testId) throws SlotException {
		
		
		return slotService.getSlot(testId);
	}
}
