package com.usd.security.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usd.security.entity.Configuration;
import com.usd.security.entity.IpServer;
import com.usd.security.exception.ConfigurationNotFoundException;
import com.usd.security.exception.IpServerNotFoundException;
import com.usd.security.repository.IpServerRepository;
import com.usd.security.service.IIpServerService;
@Service
public class IpServerService implements IIpServerService {
	@Autowired
    private IpServerRepository  ipServerRepository ;

	@Override
	public Integer saveIpSersver(IpServer ipServer) {
		return ipServerRepository.save(ipServer).getIpServerId();
	}

	@Override
	public List<IpServer> getAllIpServices() {
		return ipServerRepository.findAll();
	}

	@Override
	public IpServer getOneIpServer(Integer id) {
		Optional<IpServer>	opt=ipServerRepository.findById(id);
	       /* Configuration cnf=opt.orElseThrow(()-> new ConfigurationNotFoundException("configuration not exitst") );*/
	        
		IpServer cnf=null;
	        if(opt.isPresent()) {
	        	cnf=opt.get();
	        	
	        }else {
	        	throw new IpServerNotFoundException("IpServer not exist");
	        }
			
			return cnf;
		}

	@Override
	public void deleteIpServer(Integer id) {
		IpServer cnf=getOneIpServer(id);
		ipServerRepository.delete(cnf);
	}

	

}
