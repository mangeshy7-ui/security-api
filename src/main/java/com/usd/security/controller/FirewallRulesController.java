package com.usd.security.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usd.security.entity.FirewallRules;
import com.usd.security.service.IFirewallService;

@RestController
@RequestMapping("/firewall")
public class FirewallRulesController {
	
	@Autowired
	private  IFirewallService firewallService;

	@PostMapping("/save")
	public ResponseEntity<String> saveFirewallRulesHandler(@RequestBody FirewallRules rules){
		
		
		Integer id=firewallService.saveFirewallRules(rules);
		
		return new ResponseEntity<String>("firewallrules '"+id+"'saved", HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<FirewallRules>> getAllFirewallRulesHandler(){
	List<FirewallRules> list=firewallService.getAllFirewallRules();
	return new ResponseEntity<List<FirewallRules>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<FirewallRules> getOneFirewallRuleHandler(@PathVariable Integer id){
		
		FirewallRules cnf=firewallService.getOneFirewallRule(id);
		return new ResponseEntity<FirewallRules>(cnf,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteFirewallRuleHandler(@PathVariable Integer id){
		
		
		firewallService.deleteFirewallRule(id);
		
		return new ResponseEntity<String>("firewall rules '"+id+"' deleted",HttpStatus.OK);
		 
	 }
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody FirewallRules cnf){
		
		
		FirewallRules dbcnf=firewallService.getOneFirewallRule(id);
		/*
		 * dbcnf.setCompletLogPath(cnf.getCompletLogPath());
		 * 
		 * dbcnf.setCnfId(cnf.getCnfId()); dbcnf.setName(cnf.getName());
		 * dbcnf.setType(cnf.getType()); dbcnf.setUpdatedOn(cnf.getUpdatedOn());
		 * dbcnf.setCreatedOn(cnf.getCreatedOn());
		 * configurationService.saveConfiguration(dbcnf);
		 */
		BeanUtils.copyProperties(cnf, dbcnf);
		firewallService.saveFirewallRules(dbcnf);
		return new ResponseEntity<String>("firewallrules '"+id+"' updated",HttpStatus.OK);
	}
	
}
