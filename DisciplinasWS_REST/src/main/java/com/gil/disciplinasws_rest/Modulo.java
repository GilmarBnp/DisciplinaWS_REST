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
@Table(name = "MODULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m"),
    @NamedQuery(name = "Modulo.findByModuloId", query = "SELECT m FROM Modulo m WHERE m.moduloId = :moduloId"),
    @NamedQuery(name = "Modulo.findByModuloNome", query = "SELECT m FROM Modulo m WHERE m.moduloNome = :moduloNome"),
    @NamedQuery(name = "Modulo.findByTemaId", query = "SELECT m FROM Modulo m WHERE m.temaId = :temaId")})
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "MODULO_ID")
    private Integer moduloId;
    @Size(max = 255)
    @Column(name = "MODULO_NOME")
    private String moduloNome;
    @Column(name = "TEMA_ID")
    private Integer temaId;

    public Modulo() {
    }

    public Modulo(Integer moduloId) {
        this.moduloId = moduloId;
    }

    public Integer getModuloId() {
        return moduloId;
    }

    public void setModuloId(Integer moduloId) {
        this.moduloId = moduloId;
    }

    public String getModuloNome() {
        return moduloNome;
    }

    public void setModuloNome(String moduloNome) {
        this.moduloNome = moduloNome;
    }

    public Integer getTemaId() {
        return temaId;
    }

    public void setTemaId(Integer temaId) {
        this.temaId = temaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduloId != null ? moduloId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.moduloId == null && other.moduloId != null) || (this.moduloId != null && !this.moduloId.equals(other.moduloId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.gil.disciplinasws_rest.Modulo[ moduloId=" + moduloId + " ]";
    }
    
}
