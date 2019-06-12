/**
 * 
 */
package com.company.labs.shop.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Table(name = "SHIPMENT")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Shipment {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@OneToOne
	private Address shipTo;
	
	private String tracking;
	
	//ref
	@ManyToOne
	private Order order;

}
