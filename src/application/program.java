package application;

import entities.*;
import entities.activities.Explanation;
import entities.activities.Question;
import entities.activities.Video;

public class program {

    public static void main(String[] args) {

         Course course = new Course("Java", "cod3ac28", 20, true, "Developers",
         "Maria", "Object orientation fundamentals", "Object orientation Programming");

         Category category1 = new Category("Backend", "jhujfh77--kk", "development in backend and some tricks", "guide is just here",
                 true, 1, null, "FFF");

         Subcategory subcategory1 = new Subcategory("Variables", "jhf88hhd--d", "This subcategory is a class about variables",
                 "This guide will help you find a path to become a legend", true, 1, category1 );

         Section section1 = new Section("Study Section", "co9d3-aq", 1, true, false, course);

         Video video1 = new Video("Title", "co-d3e", section1, "http-00", 12, "video about coding stuff");

         Question question = new Question("Question Title", "co-od3", section1, "Description about the question");

         Alternative alternative = new Alternative("Question explanation", 1, "Question answer", true, "justification", "Right answer", question);

         Explanation explanation = new Explanation("Explanation title", "cod3-", section1, "Activity explanation huge text");

        System.out.println(course);
    //    System.out.println(category1);
    //    System.out.println(subcategory1);
    //    System.out.println(section1);
    //    System.out.println(video1);
    //    System.out.println(question);
    //    System.out.println(alternative);
    //   System.out.println(explanation);

    }
}
