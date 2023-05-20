package br.com.academiaJava.JpaEx1.orm;

import jakarta.persistence.*;

@Entity
@Table(name = "profissoes")
public class Profissao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String area;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Profissao{" +
                "id=" + id +
                ", area='" + area + '\'' +
                '}';
    }
}
