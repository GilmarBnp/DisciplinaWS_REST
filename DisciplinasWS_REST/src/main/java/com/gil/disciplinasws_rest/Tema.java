/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gil.disciplinasws_rest;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author emerson
 */
@Entity
@Table(name = "TEMA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tema.findAll", query = "SELECT t FROM Tema t"),
    @NamedQuery(name = "Tema.findByTemaId", query = "SELECT t FROM Tema t WHERE t.temaId = :temaId"),
    @NamedQuery(name = "Tema.findByTemaNome", query = "SELECT t FROM Tema t WHERE t.temaNome = :temaNome")})
public class Tema implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "TEMA_ID")
    private Integer temaId;
    @Size(max = 255)
    @Column(name = "TEMA_NOME")
    private String temaNome;

    public Tema() {
    }

    public Tema(Integer temaId) {
        this.temaId = temaId;
    }

    public Integer getTemaId() {
        return temaId;
    }

    public void setTemaId(Integer temaId) {
        this.temaId = temaId;
    }

    public String getTemaNome() {
        return temaNome;
    }

    public void setTemaNome(String temaNome) {
        this.temaNome = temaNome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (temaId != null ? temaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tema)) {
            return false;
        }
        Tema other = (Tema) object;
        if ((this.temaId == null && other.temaId != null) || (this.temaId != null && !this.temaId.equals(other.temaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gil.disciplinasws_rest.Tema[ temaId=" + temaId + " ]";
    }
    
}
