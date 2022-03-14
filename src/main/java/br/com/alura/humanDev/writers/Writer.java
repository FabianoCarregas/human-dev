package br.com.alura.humanDev.writers;

import br.com.alura.humanDev.entities.Category;
import br.com.alura.humanDev.entities.Course;
import br.com.alura.humanDev.entities.Subcategory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import static br.com.alura.humanDev.writers.filter.WriterFilters.*;

public class Writer {

    public static void writerHtml(List <Category> categories, List <Subcategory> subcategories, List <Course> courses) throws IOException {
        List<Subcategory> activeCategory = subcategories.stream()
               .filter(Subcategory::isActive).sorted(Comparator.comparing(Subcategory::getOrdination)).toList();

        String reader = "";
        for (Category c : categories) {
            reader += String.format("""
                    <div style="background-color:%s;color:white;padding:20px;">  <!--category colour-->
                        <h2 style="text-align:center";>%s</h3>  <!--category name-->
                        <h5 style="font-size:20px">%s</h5>  <!--category description-->
                        <img src="%s" alt="Icon-course" style="width:100px;height:100px;">
                        <h5 style="font-size:20px">%d</h5>  <!--category description-->
                        <h5 style="font-size:20px"> Total de horas: %d </h5> <!--category description-->
                            
                    """, c.getHexaColor(),
                    c.getName(),
                    c.getCategoryDescription(),
                    c.getIcon(),
                    numberOfCoursesInCategory(courses, c.getCode()),
                    totalHours(courses, c.getCode()));

                for (Subcategory subcategory : filterSubCategoryByCategory(activeCategory, c.getCode())) {
                    reader += String.format("""
                                <h5 style="font-size:20px">Cod: %s</h5>
                                <h5 style="font-size:20px">Desc: %s</h5>
                                <h5 style="font-size:20px">Nome: %s</h5>
                                                    
                            """.formatted(subcategory.getName(),
                            subcategory.getSubcategoryDescription(),
                            findCoursesNamesForSubcategory(courses, subcategory)));
                }

                reader += """
                        </div>
                        """;
        }

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("tex2.html"));

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

    }
}

