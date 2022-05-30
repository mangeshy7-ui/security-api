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

import com.usd.security.entity.CountryServer;
import com.usd.security.service.ICountryServer;

@RestController
@RequestMapping("/countryserver")
public class CountryServerController {
	
	@Autowired
	private ICountryServer countryServer ;

	@PostMapping("/save")
	 public ResponseEntity<String> saveConfiguration(@RequestBody CountryServer countryserver){
		
		
		Integer id=countryServer.saveCountryServer(countryserver);
		
		return new ResponseEntity<String>("countryserver '"+id+"'saved", HttpStatus.OK);
		
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<CountryServer>> getAllCountryServer(){
	List<CountryServer> list=countryServer.getAllCountrySerever();
	return new ResponseEntity<List<CountryServer>>(list, HttpStatus.OK);
	}
	
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<CountryServer> getOneCountryServer(@PathVariable Integer id){
		
		CountryServer cnf=countryServer.getOneCountryServer(id);
		return new ResponseEntity<CountryServer>(cnf,HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteEmployee(@PathVariable Integer id){
		
		
		countryServer.deleteCountryServer(id);
		
		return new ResponseEntity<String>("Employee '"+id+"' deleted",HttpStatus.OK);
		 
	 }
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateCountryServer(@PathVariable Integer id,@RequestBody CountryServer cnf){
		
		
		CountryServer dbcnf=countryServer.getOneCountryServer(id);
		BeanUtils.copyProperties(cnf, dbcnf);
		countryServer.saveCountryServer(dbcnf);
		return new ResponseEntity<String>("countryServer '"+id+"' updated",HttpStatus.OK);
	}
	

}
