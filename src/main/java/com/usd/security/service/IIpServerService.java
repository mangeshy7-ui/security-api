package com.usd.security.service;

import java.util.List;

import com.usd.security.entity.IpServer;

public interface IIpServerService {
	
	Integer saveIpSersver(IpServer ipServer);
	List<IpServer> getAllIpServices();
	IpServer getOneIpServer(Integer id);
	void deleteIpServer(Integer id);
	

}
