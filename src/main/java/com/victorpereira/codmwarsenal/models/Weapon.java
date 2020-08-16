package com.victorpereira.codmwarsenal.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Weapon {
	
	@Id
	private String id;
	
	private String name;
	
	private String type;
	
	private Integer chestDmg;
	
	private Integer magSize;
	
	private Integer adsSpeed;
	
	private Integer chestDps;
	
	private Integer rpm;
	
	private Integer baseRange;
}
