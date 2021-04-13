/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.controlador;
import com.emergentes.modelo.GestorProductos;
import com.emergentes.modelo.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
/**
 *
 * @author CristhianFriasJaldin
 */
public class Principal extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       Productos objAlmacena=new Productos();
       int id;
       int pos;
       String op = request.getParameter("op");
       
       if(op.equals("nuevo")){
           HttpSession ses=request.getSession();
           GestorProductos agenda= (GestorProductos) ses.getAttribute("agenda");
           objAlmacena.setId(agenda.obtieneId());
           request.setAttribute("op", op);
           request.setAttribute("almacena",objAlmacena);
           request.getRequestDispatcher("editar.jsp").forward(request, response);
       }
       if(op.equals("modificar")){
           id=Integer.parseInt(request.getParameter("id"));
           HttpSession ses = request.getSession();
           GestorProductos agenda=(GestorProductos) ses.getAttribute("agenda");
           pos=agenda.ubicarProducto(id);
           objAlmacena=agenda.getLista().get(pos);
           request.setAttribute("op", op);
           request.setAttribute("almacena",objAlmacena);
           request.getRequestDispatcher("editar.jsp").forward(request, response);;
       }
       if(op.equals("eliminar")){
           id=Integer.parseInt(request.getParameter("id"));
           HttpSession ses = request.getSession();
           GestorProductos agenda=(GestorProductos) ses.getAttribute("agenda");
           pos= agenda.ubicarProducto(id);
           agenda.eliminarProducto(pos);
           ses.setAttribute("agenda", agenda);
           response.sendRedirect("index.jsp");
       }
}
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Productos objAlmacena = new Productos();
       int pos;
       String op=request.getParameter("op");
       if(op.equals("grabar")){
           objAlmacena.setId(Integer.parseInt(request.getParameter("id")));
           objAlmacena.setProducto(request.getParameter("producto"));
           objAlmacena.setPrecio(request.getParameter("precio"));
           objAlmacena.setCantidad(request.getParameter("cantidad"));
           HttpSession ses = request.getSession();
           GestorProductos agenda=(GestorProductos) ses.getAttribute("agenda");
           String opg=request.getParameter("opg");
           if(opg.equals("nuevo")){
               agenda.insertProducto(objAlmacena);
           }else{
               pos=agenda.ubicarProducto(objAlmacena.getId());
               agenda.modificarProducto(pos, objAlmacena);
           }
           ses.setAttribute("agenda", agenda);
           response.sendRedirect("index.jsp");
       }
    }
}
