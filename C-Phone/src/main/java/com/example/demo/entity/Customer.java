package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


//ユーザー情報Entity
@Data
//@Entity//エンティティクラスのアノテーション
@Table(name="customer_detail")//テーブル名の指定
public class Customer implements Serializable{

	@Id//idであることをアノテーションで明示する
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")//DB上のカラム名を指定する
	private Integer customerId;
	
	@Column(name="last_name")//DB上のカラム名を指定する
	private String lastName;

	@Column(name="first_name")
	private String firstName;

	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="post_code")
	private String postCode;
	
	@Column(name="mail_address")
	private String mail;
	
	@Column(name="sex")
	private int abc;

	@Column(name="address1")
	private String address1;
	
	@Column(name="address2")
	private String address2;
	
	@Column(name="address3")
	private String address3;
	
	@Column(name="product_id")
	private int product;
	
	@Column(name="notes")
	private String notes;
	
	@Column(name="user_id")
	private String userid;
	
}

//	@Override
//	public String getID() {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}
//
//	@Override
//	public boolean isCritical() {
//		// TODO 自動生成されたメソッド・スタブ
//		return false;
//	}
//
//	@Override
//	public byte[] getEncodedValue() {
//		// TODO 自動生成されたメソッド・スタブ
//		return null;
//	}

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities(){
//
//	return null;

//}



//	@Column(name="delflg")
//	private Integer delflg;