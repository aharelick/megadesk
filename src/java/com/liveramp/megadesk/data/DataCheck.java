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

package com.liveramp.megadesk.data;

import com.liveramp.megadesk.resource.DependencyWatcher;
import com.liveramp.megadesk.resource.Resource;
import com.liveramp.megadesk.step.Step;

public interface DataCheck<STEP, RESOURCE> {

  public boolean check(Step<STEP, ?> step, Resource<RESOURCE> resource, DependencyWatcher watcher) throws Exception;
}
