package br.com.alura.humanDev.jdbc.query;

import br.com.alura.humanDev.entities.dto.InsertCourseDTO;

import java.sql.*;

public class CourseDAO {

//    private static Connection connection;
//
//    public CourseDAO(Connection connection) {
//        CourseDAO.connection = connection;
//    }
//
//    public static int insert(InsertCourseDTO insertCourseDTO) {
//        String sql = "INSERT INTO Course (name, code_url, course_time_hours, instructor, subcategory_id)" +
//                " VALUES (?, ?, ?, ?, ?)";
//
//        try (PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            pstm.setString(1, insertCourseDTO.getName());
//            pstm.setString(2, insertCourseDTO.getCodeUrl());
//            pstm.setInt(3, insertCourseDTO.getCourseTimeHours());
//            pstm.setString(4, insertCourseDTO.getInstructor());
//            pstm.setInt(5, insertCourseDTO.getSubcategoryId());
//
//            pstm.execute();
//
//            try (ResultSet rst = pstm.getGeneratedKeys()) {
//                rst.next();
//                return rst.getInt(1);
//            }
//        } catch (SQLException s) {
//            throw new RuntimeException(s);
//        }
//    }
//
//    public static void deleteCourseByCode(String code) {
//        String sql = "DELETE FROM Course WHERE code_url = ?";
//
//        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
//            pstm.setString(1, code);
//            pstm.execute();
//
//            Integer modifiedLines = pstm.getUpdateCount();
//            System.out.println(modifiedLines + " lines removed from the table.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static int updateAllToActive() {
//        String sql = "update Course set status = 1 where status = 0";
//
//        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
//            pstm.execute();
//            return pstm.getUpdateCount();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return 0;
//    }
}