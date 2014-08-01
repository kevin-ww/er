package kevin;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import serf.data.Attribute;
import serf.data.Record;

public class Student extends Record {

  String refCode;

  String firstName;

  String lastName;

  String dateofBirth;

  String sCode;

  public String getRefCode() {
    return refCode;
  }

  public void setRefCode(String refCode) {
    super.getAttributes().put("refCode", new Attribute(refCode));
    this.refCode = refCode;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    super.getAttributes().put("firstName", new Attribute(firstName));
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    super.getAttributes().put("lastName", new Attribute(lastName));
    this.lastName = lastName;
  }

  public String getDateofBirth() {
    return dateofBirth;
  }

  public void setDateofBirth(String dateofBirth) {
    super.getAttributes().put("dateofBirth", new Attribute(dateofBirth));
    this.dateofBirth = dateofBirth;
  }

  public String getsCode() {
    return sCode;
  }

  public void setsCode(String sCode) {
    super.getAttributes().put("sCode", new Attribute(sCode));
    this.sCode = sCode;
  }

  public Student(String refCode, String firstName, String lastName,
      String dateofBirth, String sCode) {

    // this(confidence, new HashSet<Attribute>(Arrays.asList(refCode, firstName,
    // lastName, dateofBirth, sCode)));

    this(0.0, new HashSet<Attribute>(Arrays.asList(new Attribute("refCode",
        refCode), new Attribute("firstName", firstName), new Attribute(
        "lastName", lastName), new Attribute("dateofBirth", dateofBirth),
        new Attribute("sCode", sCode))));
    // this(0.0, null);
    this.setFirstName(firstName);
    this.setLastName(lastName);
    this.setDateofBirth(dateofBirth);
    this.setsCode(sCode);
    this.setRefCode(refCode);

  }

  // public Student(double confidence, ArrayList<Attribute> attributes) {
  // // super(confidence, attributeSet);
  // this(confidence, new HashSet<Attribute>(attributes));
  //
  // }

  public Student(double confidence, Map<String, Attribute> attributes) {
    super(confidence, attributes);
    //
    Iterator<Map.Entry<String, Attribute>> iter =
        attributes.entrySet().iterator();
    while (iter.hasNext()) {
      Map.Entry<String, Attribute> entry = iter.next();
      if (entry.getKey().equalsIgnoreCase("firstName")) {
        String value = entry.getValue().getType();
        this.setFirstName(value);
      }
      if (entry.getKey().equalsIgnoreCase("lastName")) {
        String value = entry.getValue().getType();
        this.setLastName(value);
      }
      if (entry.getKey().equalsIgnoreCase("dateofBirth")) {
        String value = entry.getValue().getType();
        this.setDateofBirth(value);
      }
      if (entry.getKey().equalsIgnoreCase("sCode")) {
        String value = entry.getValue().getType();
        this.setsCode(value);
      }
      // if (entry.getKey().equalsIgnoreCase("refCode")) {
      // String value = entry.getValue().getType();
      // this.setRefCode(value);
      // }
    }

  }

  public Student(double confidence, Set<Attribute> attributeSet) {
    super(confidence, attributeSet);
  }

  @Override
  public String toString() {
    return "[refCode:" + refCode + "]";
  }

  public String toValString() {
    return "Student [firstName=" + firstName
        + ", lastName=" + lastName + ", dateofBirth=" + dateofBirth
        + ", sCode=" + sCode + "]";
  }

}
