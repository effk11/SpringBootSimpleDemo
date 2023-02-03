package com.example.demo.Entity.EntityStudent;

import jakarta.persistence.*;

@Entity
@Table(name="studentt")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer Id;
	@Column(name="name")
	public String name;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		this.Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
