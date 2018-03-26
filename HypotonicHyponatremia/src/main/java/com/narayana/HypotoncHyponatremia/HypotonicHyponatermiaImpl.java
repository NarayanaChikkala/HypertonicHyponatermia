package com.narayana.HypotoncHyponatremia;

import java.util.Arrays;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;


@Repository
public class HypotonicHyponatermiaImpl implements HypotonicHyponatermiaRepository {

	public static final String HYPONATERMIA_SERVICE_URL = "http://HYPONATEMIA";
	public static final String HYPOTONIC_SERVICE_URL = "http://HYPOTONICITY";
	protected RestTemplate restTemplate;

	@Override
	public String gethypotonicHyponatermia(String serumSodium, String serumOsmol) {
		String hyponatermia = restTemplate.getForObject(HYPONATERMIA_SERVICE_URL+"/hyponatemia/{serumSodium}",String.class);
		if(hyponatermia.equalsIgnoreCase("hyponatemia")) {
			String hypertonicity = restTemplate.getForObject(HYPOTONIC_SERVICE_URL+"/hypotonicity/{serumOsmol}",String.class);
			if(hypertonicity.equalsIgnoreCase("hypotonic")) {
				return "hypotonichyponatermia";
			}
			else {
				return "nothypotonichyponatermia";
			}
		}
		else {
			return "nothypotonichyponatermia";
		}
	}

	

}
