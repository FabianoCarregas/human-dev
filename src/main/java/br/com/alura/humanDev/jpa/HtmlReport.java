package br.com.alura.humanDev.jpa;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlReport {

    public HtmlReport() {
    }

    public static void listHtml(CategoryDAO categoryDAO, SubcategoryDAO subcategoryDAO, CourseDAO courseDAO) {

        StringBuilder htmlOpen = new StringBuilder("""
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset= UTF-8 />
                <title>Categories</title>
                </head>
                <body>
                """);

        List<Category> cat = categoryDAO.showActiveCategoriesByOrder();
        cat.forEach(c -> System.out.println(

                htmlOpen.append("""
                        <div>
                            <ul>
                                <li>Category name: %s </li>
                                <li>Category code: %s </li>
                                <li>Category description: %s </li>
                                <li>Category color: %s </li>
                                <li>Category icon: %s </li>
                            </ul>
                        </div>
                        """.formatted(c.getName(), c.getCode(), c.getCategoryDescription(), c.getHexaColor(), c.getIcon()))));

        List<Subcategory> sub = subcategoryDAO.showActiveSubcategoriesByOrder();
        sub.forEach(c -> System.out.println(

                htmlOpen.append("""
                        <div>
                            <ul>
                                <li>Subcategory name: %s </li>
                                <li>Subcategory code: %s </li>
                                <li>Subcategory description: %s </li>
                                <li>Subcategory ordination: %s </li>
                                <li>Subcategory category: %s </li>
                            </ul>
                        </div>
                        """.formatted(c.getName(), c.getCode(), c.getSubcategoryDescription(), c.getOrdination(), c.getCategory()))));

        List<Course> courses = courseDAO.showPublicCourses();
        courses.forEach(c -> System.out.println(

                htmlOpen.append("""
                        <div>
                            <ul>
                                <li>Course name: %s </li>
                                <li>Course code: %s </li>
                                <li>Course instructor: %s </li>
                                <li>Course course hours: %s </li>
                                <li>Course subcategory: %s </li>
                            </ul>
                        </div>
                        """.formatted(c.getName(), c.getCode(), c.getInstructor(), c.getCourseTimeHours(), c.getSubcategory() ))));

        List<String> subName = subcategoryDAO.showSubcategoriesWithoutDescription();
        subName.forEach(c -> System.out.println(

                htmlOpen.append("""
                        <div>
                            <ul>
                                <li>Subcategory without description </li>
                                <li>Subcategory name: %s </li>
                            </ul>
                        </div>
                        """.formatted(c.toString()))));


        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("report.html"))) {

            htmlOpen.append("""  
                            </body>
                    </html>
                    """);

            bufferedWriter.write(htmlOpen.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
            System.out.println("HTML created");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


