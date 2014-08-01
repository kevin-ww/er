package serf.data.io;

import serf.data.Record;

public class RecordFilter {

  // don't filter anything...
  public boolean includeRecord(Record r) {
    return true;
  }

}
