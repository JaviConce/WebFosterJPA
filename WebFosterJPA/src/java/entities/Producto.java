/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author diurno
 */
@Entity
@Table(name = "PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findById", query = "SELECT p FROM Producto p WHERE p.id = :id")
    , @NamedQuery(name = "Producto.findByTitulo", query = "SELECT p FROM Producto p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Producto.findByBody", query = "SELECT p FROM Producto p WHERE p.body = :body")
    , @NamedQuery(name = "Producto.findByImagen", query = "SELECT p FROM Producto p WHERE p.imagen = :imagen")
    , @NamedQuery(name = "Producto.findByFondo", query = "SELECT p FROM Producto p WHERE p.fondo = :fondo")
    , @NamedQuery(name = "Producto.findBySumario", query = "SELECT p FROM Producto p WHERE p.sumario = :sumario")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "BODY")
    private String body;
    @Column(name = "IMAGEN")
    private String imagen;
    @Column(name = "FONDO")
    private String fondo;
    @Column(name = "SUMARIO")
    private String sumario;
    @JoinColumn(name = "CATEGORIAID", referencedColumnName = "ID")
    @ManyToOne
    private Categoria categoriaid;
    @OneToMany(mappedBy = "idproducto")
    private List<Punto> puntoList;

    public Producto() {
    }

    public Producto(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public Categoria getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categoria categoriaid) {
        this.categoriaid = categoriaid;
    }

    @XmlTransient
    public List<Punto> getPuntoList() {
        return puntoList;
    }

    public void setPuntoList(List<Punto> puntoList) {
        this.puntoList = puntoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Producto[ id=" + id + " ]";
    }
    
}
