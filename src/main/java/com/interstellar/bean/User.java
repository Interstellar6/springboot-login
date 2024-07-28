package com.interstellar.bean;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户信息
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="User")
//@Data
//@Builder
public class User {

//    @Id
//    @Column(name="userId", nullable = false)
    private Long userId;

//    @Column(name="userName", nullable = false)
    private String userName;

//    @Column(name = "userPassword", nullable = false)
    private String userPassword;

}
