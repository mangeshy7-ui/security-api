package com.usd.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usd.security.entity.Configuration;
import com.usd.security.entity.FirewallRules;
import com.usd.security.exception.ConfigurationNotFoundException;
import com.usd.security.exception.FirewallRulesNotFoundException;
import com.usd.security.repository.FirewallRulesRepository;
import com.usd.security.service.IFirewallService;
@Service
public class FirewallRulsesServiceImpl implements IFirewallService {

	@Autowired
	FirewallRulesRepository firewallRulesRepository;

	@Override
	public Integer saveFirewallRules(FirewallRules firewallRules) {
		Integer id = firewallRulesRepository.save(firewallRules).getId();
		return id;
	}

	@Override
	public List<FirewallRules> getAllFirewallRules() {

		return firewallRulesRepository.findAll();
	}

	@Override
	public FirewallRules getOneFirewallRule(Integer id) {
		Optional<FirewallRules> opt = firewallRulesRepository.findById(id);
		/*
		 * Configuration cnf=opt.orElseThrow(()-> new
		 * ConfigurationNotFoundException("configuration not exitst") );
		 */

		FirewallRules cnf = null;
		if (opt.isPresent()) {
			cnf = opt.get();

		} else {
			throw new FirewallRulesNotFoundException("rules  not exist");
		}

		return cnf;
	}

	@Override
	public void deleteFirewallRule(Integer id) {
	
		FirewallRules rule =firewallRulesRepository.getById(id);
		firewallRulesRepository.delete(rule);
	

	}

}
