package application;

import entities.*;
import entities.activities.Explanation;
import entities.activities.Question;
import entities.activities.Video;

public class Program {

    public static void main(String[] args) {

         Course course = new Course("Java", "cod3c2",22,  "mario");

         Category category1 = new Category("Backend", "jhujfh77--kk");

         Subcategory subcategory1 = new Subcategory("Variables", "jhf88hhd--d", category1 );

         Section section1 = new Section("Study Section", "co9d3-aq", course);

         Video video1 = new Video("Title", "co-d3e", section1, "http-00", 12);

         Question question = new Question("Question Title", "co-od3", section1, "Description about the question");

         Alternative alternative = new Alternative("This explanation is about the test", true, "the answer is A");

         Explanation explanation = new Explanation("Explanation title", "cod3-", section1, "Activity explanation huge text");

    //   System.out.println(course);
    //    System.out.println(category1);
    //    System.out.println(subcategory1);
    //    System.out.println(section1);
    //    System.out.println(video1);
    //    System.out.println(question);
    //    System.out.println(alternative);
    //   System.out.println(explanation);

    }
}
