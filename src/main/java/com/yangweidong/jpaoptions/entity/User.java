package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @Column(name = "c_user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int userId;//用户id

    @Column(name = "c_user_id_card")
    public String userID;//用户的身份证

    @Column(name = "c_user_name")
    public String userName;//用户的名字

    @Column(name = "c_user_gender")
    public String userGender;//用户的性别

    @Column(name = "c_user_phone_number")
    public String userPhoneNumber;//用户的手机号

    @Column(name = "c_user_is_student")
    public boolean userIsStudent;//用户是否为学生

    @Column(name = "c_user_is_allowed")
    public boolean userIsAllowed;//用户是否被允许使用这个系统

}
