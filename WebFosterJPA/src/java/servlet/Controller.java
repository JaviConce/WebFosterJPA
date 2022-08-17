/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entities.Categoria;
import entities.Producto;
import entities.Punto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jpautil.JPAUtil;

/**
 *
 * @author pacopulido
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private int i;
    private int estrellas;
    private List<Categoria> categorias;
    private Categoria categoria;
    private Set productosSet;
    private List<Producto> productos;
    private Producto producto;
    private EntityManager em;
    private Query q;
    private List<Punto> puntos;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        String op = request.getParameter("op");
        em = JPAUtil.getEntityManagerFactory().createEntityManager();
        if (op.equals("inicio")) {
            q = em.createQuery("select c from Categoria c");
            categorias = q.getResultList();
            session.setAttribute("categorias", categorias);
            dispatcher = request.getRequestDispatcher("home.jsp");
            dispatcher.forward(request, response);

        } else if (op.equals("dameproductos")) {
            i = Integer.parseInt(request.getParameter("i"));
            categorias = (List<Categoria>) session.getAttribute("categorias");
            categoria = categorias.get(i);
            productos = categoria.getProductoList();
            session.setAttribute("productos", productos);
            session.setAttribute("categoria", categoria.getNombre());
            dispatcher = request.getRequestDispatcher("platos.jsp");
            dispatcher.forward(request, response);		
        } else  if (op.equals("detail")) {
            i = Integer.parseInt(request.getParameter("i"));
            productos = (List<Producto>) session.getAttribute("productos");
            producto = productos.get(i);
            puntos = producto.getPuntoList();
            estrellas = 0;
            if (puntos.size()>0){
                int suma = 0;
                for (Punto punto:puntos){
                    suma+=punto.getPuntos();
                }
                estrellas = Math.round(suma / puntos.size());
            }
            session.setAttribute("producto", producto);
            session.setAttribute("estrellas", estrellas);
            dispatcher = request.getRequestDispatcher("detail.jsp");
            dispatcher.forward(request, response);		
        } else  if (op.equals("rating")) {
            producto = (Producto)session.getAttribute("producto");
            String puntos = request.getParameter("rating");
            Punto punto = new Punto();
            punto.setId(1);
            punto.setIdproducto(producto);
            punto.setPuntos(Short.valueOf(puntos));
            EntityTransaction tran = em.getTransaction();
            tran.begin();
            em.persist(punto);
            tran.commit();
            // Calcular las nuevas estrellas.
            estrellas = 0;
            q = em.createQuery("select avg(p.puntos) from Punto p where p.idproducto.id = "+producto.getId());
            Double media = ((Double)q.getSingleResult());
            estrellas = (int) (Math.round(media));
            session.setAttribute("estrellas", estrellas);
            dispatcher = request.getRequestDispatcher("detail.jsp");
            dispatcher.forward(request, response);		
        }
		
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
