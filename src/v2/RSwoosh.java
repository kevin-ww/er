package v2;

import java.util.HashSet;
import java.util.Set;

public class RSwoosh<T> implements Swoosh<T> {

  private Matcher<T> matcher = null;

  private Merger<T> merger = null;

  public RSwoosh() {
    matcher = new Matcher<T>();
    merger = new Merger<T>();
  }

  public Set<T> execute(Set<T> records) {

    // Set<T> toProcessRecords = records;
    Set<T> primes = new HashSet<T>();

    //
    while (!records.isEmpty()) {
      // T current = records
      T current = records.iterator().next();

      //
      records.remove(current);
      T buddy = null;

      for (T prime : primes) {
        if (matcher.match(current, prime)) {
          buddy = prime;
          break;
        }
      }

      //
      if (buddy == null) {
        primes.add(current);
      } else {
        primes.remove(buddy);
        // do merge;
        T merged = merger.merge(current, buddy);
        primes.remove(buddy);
        records.add(merged);

      }
    }

    return records;

  }

  static class Matcher<T> {
    boolean match(T t1, T t2) {
      return false;
    }
  }

  static class Merger<T> {
    T merge(T t1, T t2) {
      return null;
    }
  }

}
