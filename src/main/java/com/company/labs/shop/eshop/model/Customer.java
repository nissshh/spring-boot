package com.company.labs.shop.eshop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "CUSTOMER")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private String fname;
	
	@NonNull
	private String lname;
	
	@NonNull
	private String age;
	
	@NonNull
	private String gender;
	
	@OneToMany
	private List<Address> addresses;
	
	@OneToMany
	private List<Order> orders; 
	
}
