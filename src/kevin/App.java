package kevin;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import serf.data.MatcherMerger;
import serf.data.Record;
import serf.deduplication.RSwoosh;

public class App {
  public static void main(String[] args) throws Exception {

    Student s1 = new Student("x1", "edgar", "jones", "20001104", "G34");
    Student s2 = new Student("x2", "Marry", "smith", "19990921", "G55");
    Student s3 = new Student("x3", "eddie", "jones", "20001104", "G34");
    Student s4 = new Student("x4", "mary", "smith", "19990921", "H17");
    Student s5 = new Student("x5", "eddie", "jones", "20001104", "H15");

    Set<Record> students =
        new HashSet<Record>(Arrays.asList(s1, s2, s3, s4, s5));

    MatcherMerger mm = new StudentMatcherMerger(new SimpleStudentFactory());

    Set<Record> processedStudents = RSwoosh.execute(mm, students);

    System.out.println(processedStudents);
  }
}
