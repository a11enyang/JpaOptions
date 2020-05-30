package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_student")
public class Student {
    @Id
    @Column(name = "c_student_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int studentId;

    @Column(name = "c_student_number")
    public int studentNumber;

    @Column(name = "c_studnet_name")
    public String studentName;

    @ManyToOne(targetEntity = Group.class)
    @JoinColumn(name = "c_student_group_id", referencedColumnName = "c_group_id")
    public Group group;


    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "t_student_role",
            inverseJoinColumns = {@JoinColumn(name = "c_role_student_id", referencedColumnName = "c_role_id")},
            joinColumns = {@JoinColumn(name = "c_student_role_id", referencedColumnName = "c_student_id")})
    public Set<Role> roles= new HashSet<>();


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber=" + studentNumber +
                ", studentName='" + studentName + '\'' +
                '}';
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
