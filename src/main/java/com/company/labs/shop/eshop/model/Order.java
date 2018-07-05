/**
 * 
 */
package com.company.labs.shop.eshop.model;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name="ORDER")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	private Long amount;
	
	@NonNull
	private Date date;
	
	@NonNull
	@OneToOne
	private Payment payment;
	
	@NonNull
	@OneToMany
	private List<LineItem> lineItem;

	@OneToMany
	private List<Shipment> shipment;
	
	
	//relationship/referecce tables
	@ManyToOne
	private Customer customer;
	
}
