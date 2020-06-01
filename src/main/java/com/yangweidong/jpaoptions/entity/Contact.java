package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_contact")
public class Contact {
    @Id
    @Column(name = "c_contact_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactId;//联系人id

    @Column(name = "c_contact_name")
    private String contactName;//联系人姓名

    @Column(name = "c_contact_phone_number")
    private String contactPhoneNumber;//联系人的电话号码

    @Column(name = "c_contact_id_card")
    private String contactID;//联系人的身份证
}
