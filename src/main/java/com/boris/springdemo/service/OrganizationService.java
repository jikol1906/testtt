package com.boris.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boris.domain.Organization;
import com.boris.domain.dao.OrganizationDAO;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationDAO dao;
	
	public List<Organization> getOrgList(){
		List<Organization> orgList = dao.getAllOrganizations();
		return orgList;
	}
	
	

}
