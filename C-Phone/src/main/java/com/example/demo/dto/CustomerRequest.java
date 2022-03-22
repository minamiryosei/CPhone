package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class CustomerRequest implements Serializable {
	
	  /**
	   * 顧客ID
	   */
	@NotNull
	  private Integer Id;

	@NotEmpty(message = "名前を入力してください")
	@Size(max = 100, message = "名前は100桁以内で入力してください")
	private String lastname;

	@NotEmpty(message = "名前を入力してください")
	@Size(max = 100, message = "名前は100桁以内で入力してください")
	private String firstname;
	
	private Integer radio;
	
	private String postcode;
	
	@Size(max = 255, message = "住所は255桁以内で入力してください")
	private String address1;
	
	@Size(max = 255, message = "住所は255桁以内で入力してください")
	private String address2;
	
	@Size(max = 255, message = "住所は255桁以内で入力してください")
	private String address3;

	private String phonenumber;
	
	private String mail;

	private Integer products;
	
	private String remarks;
	
	private Integer user_id;
	
}