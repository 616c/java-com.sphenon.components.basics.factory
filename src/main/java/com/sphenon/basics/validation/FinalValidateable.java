package com.sphenon.basics.validation;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.CallContext;
import com.sphenon.basics.context.Context;
import com.sphenon.basics.customary.CustomaryContext;
import com.sphenon.basics.monitoring.ProblemState;
import com.sphenon.basics.factory.returncodes.*;
import com.sphenon.basics.validation.returncodes.*;

public interface FinalValidateable{
    public void 
        validateFinally(CallContext call_context) throws ValidationFailure; 
    public ValidationFailure getFinalValidation( CallContext ctx );
    public void setFinalValidation( CallContext ctx, ValidationFailure vf );
}
