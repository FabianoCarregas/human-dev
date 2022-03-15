package br.com.alura.humanDev.jdbc.query;

import br.com.alura.humanDev.entities.Course;

import java.sql.*;

public class CourseDAO {

    private static Connection connection;

    public CourseDAO(Connection connection) {
        CourseDAO.connection = connection;
    }

    public static int insert(CourseDTO courseDTO) throws SQLException {
        String sql = "INSERT INTO Course (name, code_url, course_time_hours, instructor, subcategory_id) VALUES (?, ?, ?, ?, ?)";

        try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstm.setString(1, courseDTO.getName());
            pstm.setString(2, courseDTO.getCodeUrl());
            pstm.setInt(3, courseDTO.getCourseTimeHours());
            pstm.setString(4,courseDTO.getInstructor());
            pstm.setInt(5, courseDTO.getSubcategoryId());

            pstm.execute();

            try (ResultSet rst = pstm.getGeneratedKeys()) {
                rst.next();
                return rst.getInt(1);
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

    public static int updateToActive() throws SQLException {
        String sql = "update Course set status = 1 where status = 0";

        try(PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();
            return pstm.getUpdateCount();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}