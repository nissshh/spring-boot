/**
 * 
 */
package com.company.labs.shop.eshop.model;

import javax.persistence.Entity;
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
