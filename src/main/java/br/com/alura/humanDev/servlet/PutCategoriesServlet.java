package br.com.alura.humanDev.servlet;

import br.com.alura.humanDev.dao.CategoryDAO;
import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.util.JPAUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/alterarCategoria")
public class PutCategoriesServlet extends HttpServlet {

    private final CategoryDAO dao = new CategoryDAO(JPAUtil.getEntityManager());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Long id = Long.valueOf(request.getParameter("id"));
        Category category = dao.findCategoryById(id);
        request.setAttribute("category", category);
        RequestDispatcher rd = request.getRequestDispatcher("/putCategories.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        Integer ordination = Integer.valueOf(request.getParameter("ordination"));
        String description = request.getParameter("categoryDescription");
        boolean active = Boolean.parseBoolean(request.getParameter("active"));
        String icon = request.getParameter("icon");
        String color = request.getParameter("hexaColor");

        Category category = new Category(name, code, ordination, description, active, icon, color);
        dao.update(category);
        response.sendRedirect("listaCategorias");
    }
}
