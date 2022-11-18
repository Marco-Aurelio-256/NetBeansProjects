/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogovelha.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 *
 * @author Aluno
 */
@Entity
@Table(name = "RESULTADOS")
@NamedQueries({
    @NamedQuery(name = "Resultados.findAll", query = "SELECT r FROM Resultados r"),
    @NamedQuery(name = "Resultados.findByNpartida", query = "SELECT r FROM Resultados r WHERE r.npartida = :npartida"),
    @NamedQuery(name = "Resultados.findByJogador1", query = "SELECT r FROM Resultados r WHERE r.jogador1 = :jogador1"),
    @NamedQuery(name = "Resultados.findByJogador2", query = "SELECT r FROM Resultados r WHERE r.jogador2 = :jogador2")})
public class Resultados implements Serializable {
    
    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NPARTIDA")
    private Integer npartida;
    @Basic(optional = false)
    @Column(name = "JOGADOR1")
    private String jogador1;
    @Basic(optional = false)
    @Column(name = "JOGADOR2")
    private String jogador2;

    public Resultados() {
        emf = Persistence.createEntityManagerFactory("JogoVelha-Cabe_asDeBatatasPU");
        em = emf.createEntityManager();
    }

    public Resultados(Integer npartida) {
        emf = Persistence.createEntityManagerFactory("JogoVelha-Cabe_asDeBatatasPU");
        em = emf.createEntityManager();
        this.npartida = npartida;
    }

    public Resultados(Integer npartida, String jogador1, String jogador2) {
        emf = Persistence.createEntityManagerFactory("JogoVelha-Cabe_asDeBatatasPU");
        em = emf.createEntityManager();
        this.npartida = npartida;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }
    
    public List<Resultados> retrieveAll() throws Exception{
        List<Resultados> list = null;
        
        Query q = em.createNamedQuery("Resultados.findAll");
        list = (List<Resultados>) q.getResultList();
        
        return list;
        
    }
    
    public Integer getNpartida() {
        return npartida;
    }

    public void setNpartida(Integer npartida) {
        this.npartida = npartida;
    }

    public String getJogador1() {
        return jogador1;
    }

    public void setJogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public String getJogador2() {
        return jogador2;
    }

    public void setJogador2(String jogador2) {
        this.jogador2 = jogador2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (npartida != null ? npartida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resultados)) {
            return false;
        }
        Resultados other = (Resultados) object;
        if ((this.npartida == null && other.npartida != null) || (this.npartida != null && !this.npartida.equals(other.npartida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jogovelha.entidade.Resultados[ npartida=" + npartida + " ]";
    }
    
}
