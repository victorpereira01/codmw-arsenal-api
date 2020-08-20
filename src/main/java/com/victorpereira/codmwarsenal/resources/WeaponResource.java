package com.victorpereira.codmwarsenal.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
=======
import org.springframework.web.bind.annotation.CrossOrigin;
>>>>>>> 93fdf8f... Swagger documentation
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

	@PutMapping(value = "/{id}")
	public Weapon update(@RequestBody Weapon weapon, @PathVariable String id) {
		Weapon obj = findById(id);
		Utils.updateData(obj, weapon);
		return repo.save(obj);
	}

	@PutMapping(value = "/name")
	public Weapon updateByName(@RequestBody Weapon weapon,
			@RequestParam(value = "text", defaultValue = "") String name) {
		Weapon obj = findByName(name);
		Utils.updateData(obj, weapon);
		return repo.save(obj);
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
