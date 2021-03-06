/**
 *  Copyright 2014 LiveRamp
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

package com.liveramp.megadesk.base.state;

import com.liveramp.megadesk.core.state.Persistence;
import com.liveramp.megadesk.core.state.PersistenceTransaction;

public class InMemoryPersistence<VALUE> extends BasePersistence<VALUE> implements Persistence<VALUE> {

  private VALUE value;

  public InMemoryPersistence() {
    this.value = null;
  }

  public InMemoryPersistence(VALUE value) {
    this.value = value;
  }

  @Override
  public VALUE read() {
    return value;
  }

  @Override
  public void write(VALUE value) {
    this.value = value;
  }

  @Override
  public Object transactionCategory() {
    return InMemoryPersistence.class;
  }

  @Override
  public PersistenceTransaction newTransaction() {
    return new InMemoryPersistenceTransaction();
  }

  @Override
  public void writeInTransaction(PersistenceTransaction transaction, VALUE value) {
    ((InMemoryPersistenceTransaction)transaction).write(this, value);
  }
}
