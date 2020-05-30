package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "c_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_role_id")
    public int roleId;

    @Column(name = "c_role_name")
    public String roleName;

    @ManyToMany(targetEntity = Student.class)
    //joinColumns 当前对象在中间表中的外键
    //inverseJoinColumns 对方对象在中间表中的外键
    @JoinTable(name = "t_student_role",
            joinColumns = {@JoinColumn(name = "c_role_student_id", referencedColumnName = "c_role_id")},
            inverseJoinColumns = {@JoinColumn(name = "c_student_role_id", referencedColumnName = "c_student_id")})
    public Set<Student>  students = new HashSet<>();

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
