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
import javax.persistence.Transient;

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
    @NamedQuery(name = "Resultados.findByJogador2", query = "SELECT r FROM Resultados r WHERE r.jogador2 = :jogador2"),
    @NamedQuery(name = "Resultados.DeleteAll", query = "DELETE FROM Resultados")})
public class Resultados implements Serializable {
  
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
    @Transient
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JogoVelha-Cabe_asDeBatatasPU");
    @Transient
    EntityManager em = emf.createEntityManager();

    public Resultados() {
    }

    public Resultados(Integer npartida) {
        this.npartida = npartida;
    }

    public Resultados(Integer npartida, String jogador1, String jogador2) {
        this.npartida = npartida;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
    }
    
    public void encerrarConexaoDB(EntityManagerFactory emf, EntityManager em) {
        em.close();
        emf.close();
    }
    
    public List<Resultados> retornarTodos() throws Exception {
        List<Resultados> list = null;
        
        Query q = em.createNamedQuery("Resultados.findAll");
        list = (List<Resultados>) q.getResultList();
        
        return list;
         
    }
    
    public void criaResultado(Resultados resultados) throws Exception{
        boolean transacaoOK = false;
        
        try {
            em.getTransaction().begin();               
            em.persist(resultados);
            transacaoOK = true;
            
        } catch(javax.persistence.PersistenceException pe) {
            throw new Exception("Registro já existente! Falha ao gravar no banco!");
        } finally {
            if(transacaoOK){
              em.getTransaction().commit();  
            } else {
                em.getTransaction().rollback();
            }
        }
    }
    
    public void deletaResultado(Resultados resultados) throws Exception{
        boolean transacaoOK = false;
        
        try {
            em.getTransaction().begin();
            em.remove(resultados);
            transacaoOK = true;
            
        } catch(javax.persistence.PersistenceException ep) {
            throw new Exception("Erro ao deletar dados da tabela Resultados!");
            
        } finally {
            if(transacaoOK){
              em.getTransaction().commit();  
            } else {
                em.getTransaction().rollback();               
            }
        }  
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
