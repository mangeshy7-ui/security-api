package com.usd.security.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.usd.security.entity.Configuration;
import com.usd.security.service.IConfigurationService;
import com.usd.security.view.ConfigurationPdfView;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/configs")
public class ConfigurationController {

	@Autowired
	private IConfigurationService configurationService;
	
	
	
	@PostMapping("/save")
	public ResponseEntity<String> saveConfiguration(@RequestBody Configuration cnf){
		
		
		Integer id=configurationService.saveConfiguration(cnf);
		
		return new ResponseEntity<String>("configuration '"+id+"'saved", HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Configuration>> getAllConfigurations(){
	List<Configuration> list=configurationService.getAllConfigurations();
	return new ResponseEntity<List<Configuration>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<Configuration> getOneConfiguration(@PathVariable Integer id){
		
		Configuration cnf=configurationService.getOneConfiguration(id);
		return new ResponseEntity<Configuration>(cnf,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		
		
		configurationService.deleteConfiguration(id);
		
		return new ResponseEntity<String>("Employee '"+id+"' deleted",HttpStatus.OK);
		 
	 }
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id,@RequestBody Configuration cnf){
		
		
		Configuration dbcnf=configurationService.getOneConfiguration(id);
		dbcnf.setCompletLogPath(cnf.getCompletLogPath());
		
		dbcnf.setCnfId(cnf.getCnfId());
		dbcnf.setName(cnf.getName());
		dbcnf.setType(cnf.getType());
		dbcnf.setUpdatedOn(cnf.getUpdatedOn());
		dbcnf.setCreatedOn(cnf.getCreatedOn());
		configurationService.saveConfiguration(dbcnf);
		return new ResponseEntity<String>("Employee '"+id+"' updated",HttpStatus.OK);
	}
	
	//9 Export to Pdf
		@SuppressWarnings("unused")
		@RequestMapping("/pdf")
		public ModelAndView showPdf(
				@RequestParam(required = false) Integer id) { 
			List<Configuration> users=null;
			if(users==null)
				users=configurationService.getAllConfigurations();
			else
				users=Arrays.asList(configurationService.getOneConfiguration(id));

			//read data from Db
			ModelAndView m= new  ModelAndView();
			m.setView(new ConfigurationPdfView());
			m.addObject("list",users);
			return m;

		}
	
}
