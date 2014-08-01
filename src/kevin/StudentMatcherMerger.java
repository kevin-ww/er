package kevin;

import serf.data.AtomicMatch;
import serf.data.BasicMatcherMerger;
import serf.data.MatcherMerger;
import serf.data.Record;
import serf.data.RecordFactory;

import com.wcohen.ss.BasicStringWrapper;
import com.wcohen.ss.Jaro;
import com.wcohen.ss.api.StringWrapper;

public class StudentMatcherMerger extends BasicMatcherMerger implements
    MatcherMerger {

  public StudentMatcherMerger(RecordFactory factory) {
    this._factory = factory;
  }

  @Override
  protected boolean matchInternal(Record r1, Record r2) {

    Student s1 = (Student) r1;
    Student s2 = (Student) r2;

    // extract match;

    return new StudentMatcher().valuesMatch(s1.toValString(), s2.toValString());

  }

  static class StudentMatcher implements AtomicMatch {

    float threshold =
    // 0.82F;
        0.9F;

    public StudentMatcher() {

    }

    public StudentMatcher(float th) {
      threshold = th;
    }

    /**
     * Test if titles match In this implementation the jaro similarity metric is
     * used to compare string values. Very similar strings will have a jaro
     * score close to 1. Different strings have a jaro score close to 0.
     * 
     * @param s1 title 1
     * @param s2 title 2
     * @return true if jaro.score(title1, title2) > threshold (threshold
     *         defaults to 0.9)
     */
    public boolean valuesMatch(String s1, String s2) {

      StringWrapper sw1 = new BasicStringWrapper(s1);
      StringWrapper sw2 = new BasicStringWrapper(s2);

      Jaro jro = new Jaro();
      double score = jro.score(sw1, sw2);

      System.out
          .println("score to compare  :" + s1 + "," + s2 + " is " + score);

      if (score > threshold)
        return true;
      else
        return false;

    }

  }

}
