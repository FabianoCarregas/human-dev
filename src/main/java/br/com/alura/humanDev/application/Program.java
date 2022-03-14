package br.com.alura.humanDev.application;

import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.jdbc.ConnectionFactory;
import br.com.alura.humanDev.jdbc.query.CourseDAO;
import br.com.alura.humanDev.jdbc.query.HtmlReport;

import java.sql.*;

public class Program {

    public static void main(String[] args) throws SQLException {

        String name = "Java";
        String code = "java";
        int hours = 8;
        String instructor = "Irineu";

        Course course = new Course(name, code, hours, instructor);

        try(Connection connection = new ConnectionFactory().connectionFactory()) {
            CourseDAO courseDAO = new CourseDAO(connection);
            //courseDAO.insert(course);
            //HtmlReport htmlReport = new HtmlReport(connection);
            //htmlReport.list();
            courseDAO.deleteCourseByCode(code);
        }

        //DELETE

//        int id = 5;
//        ConnectionFactory connectionFactoryService = new ConnectionFactory();
//        Connection connection = connectionFactoryService.connectionFactory();
//
//        PreparedStatement stm = connection.prepareStatement("DELETE FROM Course WHERE id > ?");
//        stm.setInt(1, id);
//        stm.execute();
//
//        Integer modifiedLines = stm.getUpdateCount();
//
//        System.out.println("The quantity of lines removed from the table = " + modifiedLines);
//        connection.close();


        //List
//
//        ConnectionFactory connectionFactoryService = new ConnectionFactory();
//        try(Connection connection = connectionFactoryService.connectionFactory()) {
//
//            connection.setAutoCommit(false);
//
//            try (PreparedStatement stm = connection.prepareStatement(
//                    "select A.id, A.name, A.course_time_hours, A.subcategory_id from Course A " +
//                            "inner join Subcategory B on A.subcategory_id = B.id\n" +
//                            "group by A.id, A.name, A.course_time_hours, A.subcategory_id, B.name;")) {
//
//
//                ResultSet rst = stm.getResultSet();
//                connection.commit();
//                while (rst.next()) {
//                    Long id = rst.getLong("id");
//                    System.out.println("Course id: " + id);
//                    String name = rst.getString("NAME");
//                    System.out.println("name: " + name);
//                    int hours = rst.getInt("COURSE_TIME_HOURS");
//                    System.out.println("hours: " + hours);
//                    BigDecimal subcategoryID = rst.getBigDecimal("SUBCATEGORY_ID");
//                    System.out.println("subcategory ID: " + subcategoryID);
//                    String subcategoryName = rst.getString("NAME");
//                    System.out.println("Subcategory name: " + subcategoryName);
//                    System.out.println("------------------");
//                }
//            }
//        }


        //Adding
//
//        String name = "Java";
//        String code = "java";
//        int hours = 7;
//        String instructor = "Tiburcio";
//        int subcategory = 1;
//
//        ConnectionFactory connectionFactoryService = new ConnectionFactory();
//        try(Connection connection = connectionFactoryService.connectionFactory()) {
//
//            connection.setAutoCommit(false);
//
//            try(PreparedStatement stm = connection.prepareStatement(
//                    "INSERT INTO Course (name, code_url, course_time_hours, instructor, subcategory_id) VALUES " +
//                            "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
//
//                stm.setString(1, name);
//                stm.setString(2, code);
//                stm.setInt(3, hours);
//                stm.setString(4, instructor);
//                stm.setInt(5, subcategory);
//
//                ResultSet rst = stm.getGeneratedKeys();
//                while (rst.next()) {
//                    Long id = rst.getLong(1);
//                    System.out.println("The id created is: " + id);
//                }
//
//                connection.commit();
//            }catch (Exception e) {
//                e.printStackTrace();
//                System.out.println("RollBack executed");
//                connection.rollback();
//            }
//        }


        //        List<Category> categories1 = loadCategory("/home/fabiano/Desktop/csv/Categoria.csv");
//
//        List<Subcategory> subcategories1 = loadSubcategory(categories1, "/home/fabiano/Desktop/csv/Subcategoria.csv");
//
//        List<Course> courses1 = loadCourses(subcategories1, "/home/fabiano/Desktop/csv/Curso.csv");
//
//        //writerHtml(categories1, subcategories1, courses1);
//        System.out.println("---------------------------------------------------------------------------------------");
//        System.out.println("-------------------------------------------Third Week-----------------------------------------");
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<List Of Active Categories>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        showActiveCategories(categories1);  //ok
//
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Subcategories with no Description>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        showSubcategoriesWithoutDescription(subcategories1);
//
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Private Courses >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        showAnyPrivateCourses(courses1); //ok?
//
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Find all Instructors whith no reps >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        showAllInstructors(courses1); //ok
//
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<< Count Active Subcategories with description >>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        System.out.println(showSubcategoriesActiveWithDescription(subcategories1)); //ok
//
//        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<< Instructor with quantity of Courses >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        showInstructorsWithCourses(courses1);

    }
}
