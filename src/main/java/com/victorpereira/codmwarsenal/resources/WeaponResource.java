package com.victorpereira.codmwarsenal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.victorpereira.codmwarsenal.models.Weapon;
import com.victorpereira.codmwarsenal.repositories.WeaponRepository;
import com.victorpereira.codmwarsenal.resources.utils.Utils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/weapons")
@Api(value="COD MW Arsenal API")
@CrossOrigin(origins="*")
public class WeaponResource {

	@Autowired
	private WeaponRepository repo;

	@GetMapping
	@ApiOperation(value="Return a list with all weapons")
	public List<Weapon> findAll() {
		return repo.findAll();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value="Return a unique weapon")
	public Weapon findById(@PathVariable String id) {
		return repo.findById(id).orElseThrow();
	}

	@GetMapping(value = "/name")
	@ApiOperation(value="Return a unique weapon by name")
	public Weapon findByName(@RequestParam(value = "text") String name) {
		name = Utils.decodeParam(name);
		return repo.findByNameContainingIgnoreCase(name);
	}

	@GetMapping(value = "/type")
	@ApiOperation(value="Return a list with all weapons of a type")
	public List<Weapon> findByType(@RequestParam(value = "text", defaultValue = "") String type) {
		return repo.findByTypeIgnoreCase(Utils.decodeParam(type));
	}
	
	@PostMapping
	@ApiOperation(value="Create a new weapon")
	public Weapon insert(@RequestBody Weapon weapon) {
		return repo.insert(weapon);
	}
	
	@PutMapping(value="/{id}")
	@ApiOperation(value="Update a existing weapon") 
	public Weapon update(@RequestBody Weapon weapon, @PathVariable String id ) {
		Weapon wp = findById(id);
		Utils.updateData(wp, weapon);
		return repo.save(wp);
	}
}

