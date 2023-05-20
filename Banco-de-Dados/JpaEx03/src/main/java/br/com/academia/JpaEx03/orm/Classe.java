package br.com.academia.JpaEx03.orm;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classes")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cnome;
    @ManyToMany(mappedBy = "classeList", fetch = FetchType.EAGER)
    private List<Professor> professorList;

    public Classe() {

    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Classe(Integer cid, String cnome) {
        this.cid = cid;
        this.cnome = cnome;
    }
}
