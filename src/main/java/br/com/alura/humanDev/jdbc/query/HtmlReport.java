package br.com.alura.humanDev.jdbc.query;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static br.com.alura.humanDev.writers.filter.WriterFilters.*;
import static br.com.alura.humanDev.writers.filter.WriterFilters.findCoursesNamesForSubcategory;

public class HtmlReport {

    private Connection connection;

    public HtmlReport(Connection connection) {
        this.connection = connection;
    }

    public void list() throws SQLException {
        String sql = "select A.id, A.name, A.course_time_hours, A.subcategory_id from Course A " +
                "inner join Subcategory B on A.subcategory_id = B.id\n" +
                "group by A.id, A.name, A.course_time_hours, A.subcategory_id, B.name";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            String reader = null;
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {

                    Long id = rst.getLong("id");
                    System.out.println(id);
                    String name = rst.getString("name");
                    System.out.println(name);
                    int hours = rst.getInt("course_time_hours");
                    System.out.println(hours);
                    Long subcategoryId = rst.getLong("subcategory_id");
                    System.out.println(subcategoryId);
                    String subcategory = rst.getString("name");
                    System.out.println(subcategory);

                    reader = "";
                    reader += String.format("""
                                    <div>
                                        <ul>
                                            <li %d>
                                            <li %s>
                                            <li %d>
                                            <li %d>
                                            <li %s>
                                        </ul>
                                     </div>
                                    """,
                            id, name, hours, subcategoryId, subcategory);
                }
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("report.html"));

            String htmlFile = """
                    <html>
                        <head>
                        </head>
                        <div style=background-color:#555151;>
                            <body>
                               <h1  style="text-align:center";>Human-Dev<h1>
                               """ + reader + """
                            </body>
                        </div>
                    </html>
                    """;

            bufferedWriter.write(htmlFile);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


