package com.victorpereira.codmwarsenal.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.victorpereira.codmwarsenal.models.Weapon;

public interface WeaponRepository extends MongoRepository<Weapon, String> {

	Weapon findByNameContainingIgnoreCase(String name);
	
	List<Weapon> findByTypeIgnoreCase(String type);
}
