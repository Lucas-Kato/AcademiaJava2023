package br.com.academia.JpaEx03.orm;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name = "professores")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String tnome;
    private String assunto;
    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "professor_classe", joinColumns = {
            @JoinColumn(name = "fk_cid") },
            inverseJoinColumns = {@JoinColumn(name = "fk_tid")
    })
    private List<Classe> classeList;
    @OneToOne
    private Classe classe;

    public Professor(Integer tid, String tnome, String assunto) {
        this.tid = tid;
        this.tnome = tnome;
        this.assunto = assunto;
    }

    public Professor() {

    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTnome() {
        return tnome;
    }

    public void setTnome(String tnome) {
        this.tnome = tnome;
    }

    public String getAssunto(String assunto) {
        return this.assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }
}
