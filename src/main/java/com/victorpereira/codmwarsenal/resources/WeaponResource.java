package com.victorpereira.codmwarsenal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.codmwarsenal.models.Weapon;
import com.victorpereira.codmwarsenal.repositories.WeaponRepository;

@RestController
@RequestMapping(value="/weapons")
public class WeaponResource {
	
	@Autowired
	private WeaponRepository repo;
	
	@GetMapping
	public List<Weapon> findAll() {
		return repo.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Weapon findById(@PathVariable String id) {
		return repo.findById(id).orElseThrow();
	}
}
