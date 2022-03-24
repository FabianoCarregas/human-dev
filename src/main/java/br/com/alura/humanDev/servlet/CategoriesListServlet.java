package br.com.alura.humanDev.servlet;

import br.com.alura.humanDev.dao.CategoryDAO;
import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listaCategorias")
public class CategoriesListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        EntityManager em = JPAUtil.getEntityManager();
        CategoryDAO dao = new CategoryDAO(em);
        PrintWriter out = response.getWriter();

        List<Category> categories = dao.findAllCategories();

        out.println("<html><body>");
        out.println("<ul>");

        for (Category c : categories) {
            out.println("<li>" + c.getName() + "<li>");
        }

        out.println("</ul>");
        out.println("</body></html>");
    }
}
