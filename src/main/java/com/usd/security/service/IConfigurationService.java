package com.usd.security.service;

import java.util.List;

import com.usd.security.entity.Configuration;

public interface IConfigurationService {
	public Integer saveConfiguration(Configuration cnf);
	public List<Configuration> getAllConfigurations();
	public Configuration getOneConfiguration(Integer id);
	public void deleteConfiguration(Integer id);
}
