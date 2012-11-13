/**
 *  Copyright 2012 LiveRamp
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.liveramp.megadesk.data.lib;

import com.liveramp.megadesk.data.DataCheck;
import com.liveramp.megadesk.data.SimpleDataCheck;

import java.util.ArrayList;
import java.util.List;

public class ComparisonDataCheck<T extends Comparable<T>>
    extends SimpleDataCheck<T>
    implements DataCheck<Object, T> {

  private final T data;
  private final List<Integer> acceptableComparisonResults;

  public ComparisonDataCheck(T data, int... acceptableComparisonResults) {
    this.data = data;
    this.acceptableComparisonResults = new ArrayList<Integer>(acceptableComparisonResults.length);
    for (int acceptableComparisonResult : acceptableComparisonResults) {
      this.acceptableComparisonResults.add(sign(acceptableComparisonResult));
    }
  }

  @Override
  public boolean check(T resourceData) throws Exception {
    if (data == null || resourceData == null) {
      return false;
    } else {
      return acceptableComparisonResults.contains(sign(resourceData.compareTo(data)));
    }
  }

  @Override
  public String toString() {
    return "[ComparisonDataCheck: " + acceptableComparisonResults
        + " when compared to " + data + "]";
  }

  private int sign(int result) {
    return result == 0 ? 0 : result > 0 ? 1 : -1;
  }
}
