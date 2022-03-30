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
import java.util.List;

@WebServlet("/listaCategorias")
public class GetAllCategoriesServlet extends HttpServlet {

    private final CategoryDAO dao = new CategoryDAO(JPAUtil.getEntityManager());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        List<Category> categoriesList = dao.findAllCategories();
        request.setAttribute("categories", categoriesList);
        RequestDispatcher rd = request.getRequestDispatcher("/categoriesList.jsp");
        rd.forward(request, response);
    }
}
