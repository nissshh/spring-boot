/**
 * 
 */
package com.company.labs.shop.eshop.model;

import java.util.Date;

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
@Table(name = "ITEM")
@Data
@RequiredArgsConstructor
@NoArgsConstructor

public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	private Long amount;
	
	@NonNull
	private Date dueDate;
	
	@NonNull
	private String mode;
	
	private String channel;
	
	//ref
	@OneToOne
	private Order order;

}
