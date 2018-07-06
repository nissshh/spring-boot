/**
 * 
 */
package com.company.labs.shop.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Nishant.Sonar
 *
 */
@Entity
@Table(name = "ADDRESS")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	private String address1;
	
	@NonNull
	private String address2;
	
	@NonNull
	private String city;
	
	@NonNull
	private String state;

	@NonNull
	private String zipcode;

	private ADDRESS_TYPE type;
}
