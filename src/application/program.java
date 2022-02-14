package application;

import entities.*;
import enums.*;

public class program {

    public static void main(String[] args) {

        Course course1 = new Course(1L, "Java", "TeSdTfH9756WSSa", 20, CourseStatus.STATUS_PRIVATE, "Developers",
                "João", "Object orientation fundamentals", "Object orientation Programming");
        MultipleChoices multChoices1 = new MultipleChoices(1L, "The question should be right here", 1, "The answer is two",
                "Two i even", "The answer is two");
        Question questions1 = new Question(1L, "This Questions atend to test your skills", "Who James Gosling ?",
                DoubleChoiceQuestion.YES, multChoices1);
        Video video1 = new Video(1L, "http//--09io", 19, "Developments skills explanations");
        Type type1= new Type(1L, "The questions must be answered by the time you watch the videos", questions1, video1);
        Section section1 = new Section(1L, "Java OO", "http//--oi09", 1, SectionStatus.SECTION_ACTIVE, TestStatus.IS_NOT_TEST, course1);
        Activity activity1 = new Activity(1L, "Creating variables", "http//--00oi", ActivityStatus.STATUS_PUBLIC, 1, type1, questions1, section1);

        System.out.println("\n"+ course1);

    }
}
