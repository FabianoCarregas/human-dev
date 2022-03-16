package br.com.alura.humanDev.application;

import br.com.alura.humanDev.jdbc.ConnectionFactory;
import br.com.alura.humanDev.jdbc.query.CourseDAO;
import br.com.alura.humanDev.entities.dto.InsertCourse;
import br.com.alura.humanDev.jdbc.query.HtmlReport;

import java.sql.Connection;
import java.sql.SQLException;

import static br.com.alura.humanDev.jdbc.query.CourseDAO.insert;

public class Program {

    public static void main(String[] args) {

        String courseCode = "java-se";
        InsertCourse insertCourse = new InsertCourse("java-se", "java-se", 12,
                "fa", 1);

        ConnectionFactory factory = new ConnectionFactory();
        try(Connection connection = factory.getConnection()) {
            CourseDAO courseDAO = new CourseDAO(connection);
            System.out.println(insert(insertCourse));
            HtmlReport htmlReport = new HtmlReport(connection);
            System.out.println(courseDAO.updateToActive());
            courseDAO.deleteCourseByCode(courseCode);
            htmlReport.list();
        }  catch (SQLException s) {
            throw new RuntimeException(s);
        }
    }
}
