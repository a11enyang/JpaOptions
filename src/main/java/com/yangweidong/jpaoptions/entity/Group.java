package com.yangweidong.jpaoptions.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_group")
public class Group {
    @Id
    @Column(name = "c_group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int groupId;

    @Column(name = "c_group_number")
    public int groupNumber;

    @Column(name = "c_group_name")
    public String name;

    @OneToMany(targetEntity = Student.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "c_student_group_id", referencedColumnName = "c_group_id")
    public Set<Student> students = new HashSet<>();

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupNumber=" + groupNumber +
                ", name='" + name + '\'' +
                '}';
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
