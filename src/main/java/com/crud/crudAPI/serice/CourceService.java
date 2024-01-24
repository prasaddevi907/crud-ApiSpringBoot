package com.crud.crudAPI.serice;

import java.util.List;

import com.crud.crudAPI.entity.Cource;

public interface CourceService {
	
	public List<Cource> getCources();
	
	public Cource getCourcesbyId(Long id);
	
	public Cource saveCource(Cource cource);
	
	public Cource updateCource(Cource cource);
	
	public Cource deleteCourceById(Long id);
	
	public Cource deleteCourceByEntity(Cource cource);

}
