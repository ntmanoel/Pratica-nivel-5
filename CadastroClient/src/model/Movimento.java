/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cadastroserver;

import model.Produto;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author nt_ma
 */
@Entity
@Table(name = "Movimento")
@NamedQueries({
    @NamedQuery(name = "Movimento.findAll", query = "SELECT m FROM Movimento m"),
    @NamedQuery(name = "Movimento.findByIdMovimento", query = "SELECT m FROM Movimento m WHERE m.idMovimento = :idMovimento"),
    @NamedQuery(name = "Movimento.findByIdPessoa", query = "SELECT m FROM Movimento m WHERE m.idPessoa = :idPessoa"),
    @NamedQuery(name = "Movimento.findByQtdProduto", query = "SELECT m FROM Movimento m WHERE m.qtdProduto = :qtdProduto"),
    @NamedQuery(name = "Movimento.findByTipo", query = "SELECT m FROM Movimento m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Movimento.findByPrecoUnit", query = "SELECT m FROM Movimento m WHERE m.precoUnit = :precoUnit")})
public class Movimento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdMovimento")
    private Integer idMovimento;
    @Basic(optional = false)
    @Column(name = "IdPessoa")
    private int idPessoa;
    @Basic(optional = false)
    @Column(name = "QtdProduto")
    private int qtdProduto;
    @Basic(optional = false)
    @Column(name = "Tipo")
    private Character tipo;
    @Basic(optional = false)
    @Column(name = "PrecoUnit")
    private long precoUnit;
    @JoinColumn(name = "IdUsuario", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pessoa idUsuario;
    @JoinColumn(name = "IdProduto", referencedColumnName = "IdProduto")
    @ManyToOne(optional = false)
    private Produto idProduto;

    public Movimento() {
    }

    public Movimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public Movimento(Integer idMovimento, int idPessoa, int qtdProduto, Character tipo, long precoUnit) {
        this.idMovimento = idMovimento;
        this.idPessoa = idPessoa;
        this.qtdProduto = qtdProduto;
        this.tipo = tipo;
        this.precoUnit = precoUnit;
    }

    public Integer getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(Integer idMovimento) {
        this.idMovimento = idMovimento;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public Character getTipo() {
        return tipo;
    }

    public void setTipo(Character tipo) {
        this.tipo = tipo;
    }

    public long getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(long precoUnit) {
        this.precoUnit = precoUnit;
    }

    public Pessoa getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Pessoa idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMovimento != null ? idMovimento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimento)) {
            return false;
        }
        Movimento other = (Movimento) object;
        if ((this.idMovimento == null && other.idMovimento != null) || (this.idMovimento != null && !this.idMovimento.equals(other.idMovimento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cadastroserver.Movimento[ idMovimento=" + idMovimento + " ]";
    }
    
}
