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
import java.util.List;

@WebServlet("/getCategory")
public class GetCategoryServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String paramId = request.getParameter("id");
        Long id = Long.valueOf(paramId);

        EntityManager em = JPAUtil.getEntityManager();
        CategoryDAO dao = new CategoryDAO(em);
        Category category = dao.findCategoryById(id);

        request.setAttribute("category", category);

        RequestDispatcher rd = request.getRequestDispatcher("/postcategory.jsp");
        rd.forward(request, response);
    }
}
