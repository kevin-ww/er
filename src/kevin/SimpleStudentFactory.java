package kevin;

import java.util.Map;

import serf.data.Attribute;
import serf.data.Record;
import serf.data.RecordFactory;

public class SimpleStudentFactory implements RecordFactory {

  @Override
  public Student create(double confidence, Map<String, Attribute> attrs,
      Record r1, Record r2) {
    Student s1 = (Student) r1;
    Student s2 = (Student) r2;
    String refCode = s1.getRefCode() + ";" + s2.getRefCode();
    // String refCode =
    Student r = new Student(confidence, attrs);
    r.setRefCode(refCode);
    return r;
  }

}
