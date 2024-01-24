package com.crud.crudAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.crudAPI.entity.Cource;
import com.crud.crudAPI.serice.CourceService;

@RestController
@RequestMapping("/crud/api/v1")
public class CouresController {

	@Autowired
	private CourceService courceService;

	@GetMapping("/home")
	public String home() {
		return "This is home ";
	}

	@GetMapping("/cources")
	public List<Cource> getCource() {
	return this.courceService.getCources();
	}

	@GetMapping("/cources/{id}")
	public ResponseEntity<HttpStatus> getCourceByid(@PathVariable String id) {
		try {
			this.courceService.getCourcesbyId(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}

	@PostMapping("/cources")
	public Cource addCource(@RequestBody Cource cource) {
		return this.courceService.saveCource(cource);
	}

	@PutMapping("/cources")
	public Cource updateCource(@RequestBody Cource cource) {
		return this.courceService.updateCource(cource);
	}
	
	@PutMapping("/cources/{id}")
    public ResponseEntity<Cource> updateCourse(@PathVariable Long id, @RequestBody Cource updatedCourse) {
        Cource existingCourseOptional = courceService.getCourcesbyId(id);
       
        if (existingCourseOptional!=null) {
        	existingCourseOptional.setTitle(updatedCourse.getTitle());
        	existingCourseOptional.setDescrption(updatedCourse.getDescrption());
            Cource savedCourse = courceService.saveCource(existingCourseOptional);
            return ResponseEntity.ok(savedCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

	@DeleteMapping("/cources/{id}")
	public ResponseEntity<HttpStatus> deleteById(@PathVariable String id) {	
		try {
			this.courceService.deleteCourceById(Long.parseLong(id));
			return	new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}

	@DeleteMapping("/cources")
	public Cource deleteCourceByEntity(@RequestBody Cource cource) {
		return this.courceService.deleteCourceByEntity(cource);
	}

}
