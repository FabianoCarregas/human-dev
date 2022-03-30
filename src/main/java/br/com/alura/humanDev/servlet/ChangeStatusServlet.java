package br.com.alura.humanDev.servlet;

import br.com.alura.humanDev.dao.CategoryDAO;
import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.util.JPAUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/changeCategoryStatus")
public class ChangeStatusServlet extends HttpServlet {

    private final CategoryDAO dao = new CategoryDAO(JPAUtil.getEntityManager());

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response)
            throws IOException{
        Long id = Long.valueOf(request.getParameter("id"));
        Category category = dao.findCategoryById(id);
        category.toggleStatus();
        dao.update(category);
        response.sendRedirect("listaCategorias");
    }
}
