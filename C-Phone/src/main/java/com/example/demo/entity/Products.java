package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity//エンティティクラスのアノテーション
@Table(name="products")//テーブル名の指定

public class Products implements Serializable{
	@Id//idであることをアノテーションで明示する
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")//DB上のカラム名を指定する
	private Integer id;
	
	@Column(name="product_name")//DB上のカラム名を指定する
	private String product_name;

}
	