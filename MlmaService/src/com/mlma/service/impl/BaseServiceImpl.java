package com.mlma.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mlma.dao.AddMapper;
import com.mlma.model.Add;
import com.mlma.service.BaseService;

@Service("baseService")
public class BaseServiceImpl implements BaseService {
	
	private AddMapper addMapper;
	
	public AddMapper getAddMapper() {
		return addMapper;
	}
	@Autowired
	public void setAddMapper(AddMapper addMapper) {
		this.addMapper = addMapper;
	}
	@Override
	public List<Add> getAll() {
		return addMapper.getAll();
	}

}
