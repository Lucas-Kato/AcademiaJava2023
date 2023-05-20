package br.com.academiaJava.JpaEx02Ex03.orm;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;
    private  String deg;
    private String ename;
    private Double salary;
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "department_emplyee", joinColumns = {
            @JoinColumn(name = "fk_employee")},
            inverseJoinColumns = {@JoinColumn(name = "fk_department")})
    private List<Department> departmentList;
    @OneToOne
    private Department department;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getDeg() {
        return deg;
    }

    public void setDeg(String deg) {
        this.deg = deg;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eid=" + eid +
                ", deg='" + deg + '\'' +
                ", ename='" + ename + '\'' +
                ", salary=" + salary +
                '}';
    }
}
