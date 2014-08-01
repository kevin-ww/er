package kevin;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import serf.data.MatcherMerger;
import serf.data.Record;
import serf.deduplication.Bfa;
import serf.deduplication.RSwoosh;

public class SwooshTest {

  static Set<Record> students;

  // @Test
  public void test() {
    fail("Not yet implemented");
  }

  @BeforeClass
  public static void setup() {
    Student s1 = new Student("x1", "edgar", "jones", "20001104", "G34");
    Student s2 = new Student("x2", "Marry", "smith", "19990921", "G55");
    Student s3 = new Student("x3", "eddie", "jones", "20001104", "G34");
    Student s4 = new Student("x4", "mary", "smith", "19990921", "H17");
    Student s5 = new Student("x5", "eddie", "jones", "20001104", "H15");

    students = new HashSet<Record>(Arrays.asList(s1, s2, s3, s4, s5));
  }

  @Test
  public void rswooshTest() {

    MatcherMerger mm = new StudentMatcherMerger(new SimpleStudentFactory());

    Set<Record> processedStudents = RSwoosh.execute(mm, students);

    System.out.println(processedStudents);
  }

  @Test
  public void bfaTest() {

    MatcherMerger mm = new StudentMatcherMerger(new SimpleStudentFactory());

    Bfa bfa = new Bfa();

    Set<Record> processedStudents = bfa.execute(mm, students);

    System.out.println(processedStudents);
  }

}
