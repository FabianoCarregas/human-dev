package br.com.alura.humanDev.application;

import br.com.alura.humanDev.jdbc.ConnectionFactory;
import br.com.alura.humanDev.jdbc.query.CourseDAO;
import br.com.alura.humanDev.entities.dto.CourseDTO;
import br.com.alura.humanDev.jdbc.query.HtmlReport;

import java.sql.Connection;
import java.sql.SQLException;

public class Program {

    public static void main(String[] args) throws SQLException {

        String courseCode = "java-se";
        CourseDTO courseDTO = new CourseDTO("java", "java-se", 12, "fa", 1);

        ConnectionFactory factory = new ConnectionFactory();
        try(Connection connection = factory.getConnection()) {
            CourseDAO courseDAO = new CourseDAO(connection);
            System.out.println(CourseDAO.insert(courseDTO));
            HtmlReport htmlReport = new HtmlReport(connection);
            System.out.println(courseDAO.updateToActive());
            courseDAO.deleteCourseByCode(courseCode);
            htmlReport.list();
        }
    }
}
