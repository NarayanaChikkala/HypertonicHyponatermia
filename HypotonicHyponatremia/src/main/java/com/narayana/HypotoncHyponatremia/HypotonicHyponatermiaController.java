package com.narayana.HypotoncHyponatremia;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HypotonicHyponatermiaController {
	
	protected Logger logger = Logger
			.getLogger(HypotonicHyponatermiaController.class.getName());
	
	@Autowired
	HypotonicHyponatermiaRepository hypotonicHyponatermiaRepository;
	
	@RequestMapping("/HypotonicHyponatermia/{SerumSodium}/{SerumOsmol}")
	public String HypotonicHyponatermia(@PathVariable("SerumSodium") String SerumSodium,@PathVariable("SerumOsmol") String SerumOsmol) {
		logger.info("accounts-changed byId() invoked: " + SerumOsmol);
		String retVal = hypotonicHyponatermiaRepository.gethypotonicHyponatermia(SerumSodium,SerumOsmol);
		logger.info("accounts-microservice byId() found: " + retVal);
		return retVal;
	}

}
