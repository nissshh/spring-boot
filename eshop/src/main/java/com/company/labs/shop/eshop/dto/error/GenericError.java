/**
 * 
 */
package com.company.labs.shop.eshop.dto.error;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * A generic error to be returned.
 * 
 * @author Nishant.Sonar
 *
 */
@Data
@RequiredArgsConstructor
public class GenericError {

	@NonNull
	Long errorCode;

	@NonNull
	String message;

	Object entity;
}
