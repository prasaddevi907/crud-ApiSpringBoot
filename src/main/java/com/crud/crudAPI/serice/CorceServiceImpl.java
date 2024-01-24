package com.crud.crudAPI.serice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.crud.crudAPI.dao.CoureceDao;
import com.crud.crudAPI.entity.Cource;

@Service
public class CorceServiceImpl implements CourceService {
	
	@Autowired
	private CoureceDao coureceDao;

	@Override
	public List<Cource> getCources() {	
		return coureceDao.findAll();
	}

	@Override
	public Cource getCourcesbyId(Long id) {
		return coureceDao.findById(id).get();
	}

	@Override
	public Cource saveCource(Cource cource) {
		return coureceDao.save(cource);
	}

	@Override
	public Cource updateCource(Cource cource) {		
		return coureceDao.save(cource);
	}

	@Override
	public Cource deleteCourceById(Long id) {
		Cource c=coureceDao.getById(id);
		if(c.getId()==id) {
			coureceDao.delete(c);	
		}
		return c;
	}

	@Override
	public Cource deleteCourceByEntity(Cource cource) {
		coureceDao.delete(cource);			
		return cource;
	}

}
