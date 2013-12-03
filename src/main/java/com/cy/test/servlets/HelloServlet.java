package com.cy.test.servlets;

import com.cy.test.entities.Todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class HelloServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello, World !");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mypu");
        EntityManager em = emf.createEntityManager();
        Todo todo = new Todo();
        todo.setTitle("ok ok");

        EntityTransaction t = em.getTransaction();

        t.begin();

        em.persist(todo);

        t.commit();

    }
}
