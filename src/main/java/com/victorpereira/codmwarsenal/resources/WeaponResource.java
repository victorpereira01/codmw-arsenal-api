package com.victorpereira.codmwarsenal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.codmwarsenal.models.Weapon;
import com.victorpereira.codmwarsenal.repositories.WeaponRepository;
import com.victorpereira.codmwarsenal.resources.utils.URL;

@RestController
@RequestMapping(value = "/weapons")
public class WeaponResource {

	@Autowired
	private WeaponRepository repo;

	@GetMapping
	public List<Weapon> findAll() {
		return repo.findAll();
	}

	@GetMapping(value = "/{id}")
	public Weapon findById(@PathVariable String id) {
		return repo.findById(id).orElseThrow();
	}

	@GetMapping(value = "/name")
	public Weapon findByName(@RequestParam(value = "text") String name) {
		name = URL.decodeParam(name);
		return repo.findByNameContainingIgnoreCase(name);
	}

	@GetMapping(value = "/type")
	public List<Weapon> findByType(@RequestParam(value = "text", defaultValue = "") String type) {
		type = URL.decodeParam(type);
		return repo.findByTypeIgnoreCase(type);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Weapon insert(@RequestBody Weapon weapon) {
		return repo.insert(weapon);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id) {
		repo.deleteById(id);
	}
}
