package br.com.alura.humanDev.jdbc.query;

import br.com.alura.humanDev.entities.Course;

import java.sql.*;

public class CourseDAO {

    private Connection connection;

    public CourseDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Course course) throws SQLException {
        String sql = "INSERT INTO Course (name, code_url, course_time_hours, instructor) VALUES (?, ?, ?, ?)";

        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, course.getName());
            pstm.setString(2, course.getCodeUrl());
            pstm.setInt(3, course.getCourseTimeHours());
            pstm.setString(4, course.getInstructor());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                while(rst.next()) {
                    course.setId(rst.getLong(1));
                    System.out.println("Course id " + course.getId() + " created successfully");
                }
            }
        }
    }

    public void deleteCourseByCode(String code) throws SQLException {
        String sql = "DELETE FROM Course WHERE code_url = ?";

        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstm.setString(1, code);
            pstm.execute();

            Integer modifiedLines = pstm.getUpdateCount();
            System.out.println(modifiedLines + " lines removed from the table.");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

   // Integer modifiedLines = stm.getUpdateCount();
//
//        System.out.println("The quantity of lines removed from the table = " + modifiedLines);
//        connection.close();