package br.com.alura.humanDev.servlet;

import br.com.alura.humanDev.dao.CategoryDAO;
import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeCategoryStatus")
public class ChangeStatusServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        EntityManager em = JPAUtil.getEntityManager();
        CategoryDAO dao = new CategoryDAO(em);

        String paramId = request.getParameter("id");
        Long id = Long.valueOf(paramId);
        Category category = dao.findCategoryById(id);
        category.toggleStatus();
        dao.update(category);

        em.close();
        response.sendRedirect("listaCategorias");
    }

}
