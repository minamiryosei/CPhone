//package com.example.demo.entity;
//
//import java.util.Collection;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import lombok.Data;
//
////ユーザー情報Entity
//@Data
//@Entity//エンティティクラスのアノテーション
//@Table(name="users")//テーブル名の指定
//public class Customer implements CustomerDetails{
//
//	@Id//idであることをアノテーションで明示する
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="last_name")//DB上のカラム名を指定する
//	private String lastname;
//
//	@Column(name="first_name")
//	private String firstname;
//
//	@Column(name="phone number")
//	private String phonenumber;
//	
//	@Column(name="post_code")
//	private String postcode;
//	
//	@Column(name="mail_address")
//	private String mail;
//	
//	@Column(name="sex")
//	private int 1;
//
//	@Column(name="address")
//	private String address1;
//	
//	@Column(name="address")
//	private String address2;
//	
//	@Column(name="address")
//	private String address3;
//	
//	@Column(name="product_id")
//	private int 11;
//
//}
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities(){
//
//	return null;
//}
//}
//	
////	@Column(name="delflg")
////	private Integer delflg;