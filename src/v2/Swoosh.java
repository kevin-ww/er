package v2;

import java.util.Set;

public interface Swoosh<T> {
  public Set<T> execute(Set<T> records);
}
