package br.com.alura.humanDev.servlet;

import br.com.alura.humanDev.dao.CategoryDAO;
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

@WebServlet("/alterarCategoria")
public class PutCategoriesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        EntityManager em = JPAUtil.getEntityManager();
        CategoryDAO dao = new CategoryDAO(em);

        try {
            Long id = Long.valueOf(request.getParameter("id"));
            String name = request.getParameter("name");
            String code = request.getParameter("code");
            Integer ordination = Integer.valueOf(request.getParameter("ordination"));
            String description = request.getParameter("categoryDescription");
            boolean active = Boolean.parseBoolean(request.getParameter("categoryDescription"));
            String icon = request.getParameter("icon");
            String color = request.getParameter("hexaColor");

            Category category = new Category(id, name, code, ordination, description, active, icon, color);
            em.getTransaction().begin();
            dao.findCategoryById(id);
            dao.insert(category);
        }catch (Exception e) {
            em.getTransaction().rollback();
        }

        response.sendRedirect("listaCategorias");
//        RequestDispatcher rd = request.getRequestDispatcher("/PostCategory.jsp");
//        request.setAttribute("category", category.getName());
//        rd.forward(request, response);
    }
}
