package com.example.demo.dto;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 * ユーザー情報更新リクエストデータ
 *
 */
@EqualsAndHashCode(callSuper=false)
@Data
public class CustomerUpdateRequest extends CustomerRequest implements Serializable {

}