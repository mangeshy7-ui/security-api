package com.usd.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usd.security.entity.Configuration;
import com.usd.security.exception.ConfigurationNotFoundException;
import com.usd.security.repository.ConfigurationRepository;
import com.usd.security.service.IConfigurationService;

@Service
public class ConfigurationService implements IConfigurationService{
	
	@Autowired
	private ConfigurationRepository configurationRepository;

	@Override
	public Integer saveConfiguration(Configuration cnf) {
		Integer id=configurationRepository.save(cnf).getCnfId();
		return id;
	}

	@Override
	public List<Configuration> getAllConfigurations() {
    List<Configuration> list=configurationRepository.findAll();
		return list;
	}

	@Override
	public Configuration getOneConfiguration(Integer id) {
        Optional<Configuration> opt=configurationRepository.findById(id);
       /* Configuration cnf=opt.orElseThrow(()-> new ConfigurationNotFoundException("configuration not exitst") );*/
        
        Configuration cnf=null;
        if(opt.isPresent()) {
        	cnf=opt.get();
        	
        }else {
        	throw new ConfigurationNotFoundException("configuration not exist");
        }
		
		return cnf;
	}

	@Override
	public void deleteConfiguration(Integer id) {
        		Configuration cnf=getOneConfiguration(id);
        		configurationRepository.delete(cnf);
	}
	
	
	

}
