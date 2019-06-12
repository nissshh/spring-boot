/**
 * 
 */
package com.company.labs.shop.eshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Nishant.Sonar
 *
 */

@ApiModel(description = "All details about the Item. ")
@Entity
@Table(name = "ITEM")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Item {
	@ApiModelProperty(notes = "The database generated employee ID")		
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ApiModelProperty(notes = "The item name")
	@NonNull
	private String name;

	@ApiModelProperty(notes = "The item price")
	@NonNull
	private Long price;

}
