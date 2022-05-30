package com.usd.security.service;

import java.util.List;

import com.usd.security.entity.FirewallRules;

public interface IFirewallService {
    
	
	Integer saveFirewallRules(FirewallRules firewallRules );
	List<FirewallRules> getAllFirewallRules();
	FirewallRules getOneFirewallRule(Integer id);
	void deleteFirewallRule(Integer id);
}
