package br.com.alura.humanDev.jdbc.query;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HtmlReport {

    private Connection connection;

    public HtmlReport(Connection connection) {
        this.connection = connection;
    }

    public void list() throws SQLException {
        String sql = "select c.id, c.`name`, c.course_time_hours, c.subcategory_id, s.`name`\n" +
                "from Course c\n" +
                "inner join Subcategory s on c.subcategory_id = s.id\n" +
                "where c.status";

        String htmlOpen = """
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset= UTF-8 />
                <title>Cursos</title>
                </head>
                <body>
                <h1>Cursos</h1>
                """;

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            String reader = null;
            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    Long id = rst.getLong("id");
                    String name = rst.getString("name");
                    int hours = rst.getInt("course_time_hours");
                    Long subcategoryId = rst.getLong("subcategory_id");
                    String subcategory = rst.getString("name");

                    htmlOpen += """
                            <div>
                                <ul>
                                    <li> %d </li>
                                    <li> %s </li>
                                    <li> %d </li>
                                    <li> %d </li>
                                    <li> %s </li>
                                </ul>
                               </div>
                            """.formatted(id, name, hours, subcategoryId, subcategory);
                }
            }

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("report.html"));

            htmlOpen += """  
                            </body>
                    </html>
                    """;

            bufferedWriter.write(htmlOpen);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("created");
    }
}


