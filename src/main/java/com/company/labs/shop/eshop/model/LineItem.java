package com.company.labs.shop.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import io.micrometer.core.lang.NonNull;
import io.swagger.annotations.ApiModel;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@Entity
@Table(name = "LINEITEM")
@Data
@NoArgsConstructor
public class LineItem implements Comparable<LineItem>{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private Item item;

	private Long quantity;
	
	private Long discount;
	
	//ref
	@ManyToOne
	private Order order;

	@Override
	public int compareTo(LineItem o) {
		return o.getItem().getName().compareTo(this.getItem().getName());
	}
	
}
