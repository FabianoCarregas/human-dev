package br.com.alura.humanDev.servlet;

import br.com.alura.humanDev.dao.CategoryDAO;
import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listaCategorias")
public class CategoriesListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        EntityManager em = JPAUtil.getEntityManager();
        CategoryDAO dao = new CategoryDAO(em);
        PrintWriter out = response.getWriter();

        List<Category> categories = dao.findAllCategories();

        out.println("<html><body>");
        out.println("<h1>Categories</h1>");
        out.println("<ul>");

        for (Category c : categories) {
            out.println("<li>" + c.getName() + "<li>");
            out.println("<li>" + c.getCode()+ "<li>");
            out.println("<li>" + c.getCategoryDescription()+ "<li>");
            out.println("<li>" + c.getHexaColor()+ "<li>");
            out.println("<li>" + c.getIcon() + "<li>");
            out.println("<h5>%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%</h5>");


        }

        out.println("</ul>");
        out.println("</body></html>");
    }

}
