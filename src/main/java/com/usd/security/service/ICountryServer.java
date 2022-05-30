package com.usd.security.service;

import java.util.List;

import com.usd.security.entity.CountryServer;

public interface ICountryServer {
	
	public Integer saveCountryServer(CountryServer countryServer );
	public List<CountryServer> getAllCountrySerever();
	public CountryServer getOneCountryServer(Integer id);
	public void deleteCountryServer(Integer id);

}
