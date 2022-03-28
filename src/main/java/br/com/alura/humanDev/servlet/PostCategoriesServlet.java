package br.com.alura.humanDev.servlet;

import br.com.alura.humanDev.dao.CategoryDAO;
import br.com.alura.humanDev.dto.CategoryDTO;
import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/criarCategoria")
public class PostCategoriesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher rd = request.getRequestDispatcher("/postcategory.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String name = request.getParameter("name");
        String code = request.getParameter("code");
        Integer ordination = Integer.valueOf(request.getParameter("ordination"));
        String description  = request.getParameter("categoryDescription");
        boolean active = Boolean.parseBoolean(request.getParameter("active"));
        String icon = request.getParameter("icon");
        String color = request.getParameter("hexaColor");

        Category category = new Category(name, code, ordination, description, active, icon, color);

        EntityManager em = JPAUtil.getEntityManager();
        CategoryDAO dao = new CategoryDAO(em);
        dao.insert(category);

        response.sendRedirect("listaCategorias");

        em.close();

    }
}
