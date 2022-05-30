package com.usd.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usd.security.entity.Configuration;
import com.usd.security.entity.CountryServer;
import com.usd.security.exception.ConfigurationNotFoundException;
import com.usd.security.exception.CountryServerNotFoundException;
import com.usd.security.repository.CountryServerRepository;
import com.usd.security.service.ICountryServer;
@Service
public class CountryServerImpl implements ICountryServer {
	
	@Autowired
	private CountryServerRepository  countryServerRepository ;

	@Override
	public Integer saveCountryServer(CountryServer countryServer) {
		return countryServerRepository.save(countryServer).getSId();
	}

	@Override
	public List<CountryServer> getAllCountrySerever() {
		List<CountryServer> all=countryServerRepository.findAll();
		return all;
	}

	@Override
	public CountryServer getOneCountryServer(Integer id) {
		 Optional<CountryServer> opt=countryServerRepository.findById(id);
	       /* Configuration cnf=opt.orElseThrow(()-> new ConfigurationNotFoundException("configuration not exitst") );*/
	        
		 CountryServer cnf=null;
	        if(opt.isPresent()) {
	        	cnf=opt.get();
	        	
	        }else {
	        	throw new CountryServerNotFoundException("configuration not exist");
	        }
			
			return cnf;
	}

	@Override
	public void deleteCountryServer(Integer id) {
		CountryServer cs=getOneCountryServer(id);
		countryServerRepository.delete(cs);
	}

}
