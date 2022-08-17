package entities;

import entities.Categoria;
import entities.Punto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-01-28T08:58:24")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> fondo;
    public static volatile SingularAttribute<Producto, String> sumario;
    public static volatile ListAttribute<Producto, Punto> puntoList;
    public static volatile SingularAttribute<Producto, String> titulo;
    public static volatile SingularAttribute<Producto, String> imagen;
    public static volatile SingularAttribute<Producto, Short> id;
    public static volatile SingularAttribute<Producto, String> body;
    public static volatile SingularAttribute<Producto, Categoria> categoriaid;

}