package com.sphenon.basics.factory;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.factory.returncodes.*;
import com.sphenon.basics.validation.returncodes.*;

/**

   [INTERACTIONREFACTORING]

   This interface is to be refactored, see INTERACTIONREFACTORING.iss

   The commentaries here are already moved to ADTFactory.java

*/
public interface Factory {
    public void   validate        (CallContext context) throws ValidationFailure;
    public void confirmAttributes (CallContext context);
    public void validateFinally   (CallContext context) throws ValidationFailure;
    //  public void precreateObject   (CallContext context);
    public Object createObject    (CallContext context) throws ValidationFailure;
    public void   reset           (CallContext context);
}
