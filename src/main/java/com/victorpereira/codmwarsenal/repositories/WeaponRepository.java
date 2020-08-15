package com.victorpereira.codmwarsenal.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.victorpereira.codmwarsenal.models.Weapon;

public interface WeaponRepository extends MongoRepository<Weapon, String> {

}
