package com.company.labs.shop.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.micrometer.core.lang.NonNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "LINEITEM")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NonNull
	@OneToOne
	private Item item;

	@NonNull
	private Long quantity;
	
	private Long discount;
	
	
	//ref
	@ManyToOne
	private Order order;
}
