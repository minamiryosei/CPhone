package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


//ユーザー情報Entity
@Data
@Entity//エンティティクラスのアノテーション
@Table(name="customer_detail")//テーブル名の指定
public class Customer implements Serializable{

	@Id//idであることをアノテーションで明示する
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")//DB上のカラム名を指定する
	private Integer customerId;
	
	@Column(name="last_name")//DB上のカラム名を指定する
	private String lastname;

	@Column(name="first_name")
	private String firstname;
	
	@Column(name="sex")
	private Integer radio;
	
	@Column(name="post_code")
	private String postcode;
	
	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="address3")
	private String address3;

	@Column(name="phone_number")
	private String phonenumber;
	
	@Column(name="mail_address")
	private String mail;
	
	@Column(name="product_id")
	private Integer products;
	
	@Column(name="notes")
	private String remarks;
	
	@Column(name="user_id")
	private Integer user_id;
	
}
