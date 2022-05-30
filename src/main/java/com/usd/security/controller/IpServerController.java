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

import com.usd.security.entity.IpServer;
import com.usd.security.service.IIpServerService;

@RestController
@RequestMapping("/ipserver")
public class IpServerController {
    @Autowired
	private IIpServerService iIpServerService ;
    @PostMapping("/save")
	public ResponseEntity<String> saveIpServerhandler(@RequestBody IpServer ipserver){
		
		
		Integer id=iIpServerService.saveIpSersver(ipserver);
		
		return new ResponseEntity<String>("IpServer '"+id+"'saved", HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<IpServer>> getAllIpServers(){
	List<IpServer> list=iIpServerService.getAllIpServices();
	return new ResponseEntity<List<IpServer>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<IpServer> getOneIpServer(@PathVariable Integer id){
		
		IpServer cnf=iIpServerService.getOneIpServer(id);
		return new ResponseEntity<IpServer>(cnf,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		
		
		iIpServerService.deleteIpServer(id);
		
		return new ResponseEntity<String>("IpServer '"+id+"' deleted",HttpStatus.OK);
		 
	 }
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody IpServer cnf){
		
		
		IpServer dbcnf=iIpServerService.getOneIpServer(id);
		
		/*
		 * dbcnf.setCompletLogPath(cnf.getCompletLogPath());
		 * 
		 * dbcnf.setCnfId(cnf.getCnfId()); dbcnf.setName(cnf.getName());
		 * dbcnf.setType(cnf.getType()); dbcnf.setUpdatedOn(cnf.getUpdatedOn());
		 * dbcnf.setCreatedOn(cnf.getCreatedOn());
		 * configurationService.saveConfiguration(dbcnf);
		 *
		 */
		BeanUtils.copyProperties(cnf, dbcnf);
		iIpServerService.saveIpSersver(dbcnf);
		return new ResponseEntity<String>("ipserver '"+id+"' updated",HttpStatus.OK);
	}
	
}
