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

import com.sphenon.basics.context.*;
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.classes.*;

public class ValidationStringPool extends StringPoolClass {
    static protected ValidationStringPool singleton = null;

    static public ValidationStringPool getSingleton (CallContext cc) {
        if (singleton == null) {
            singleton = new ValidationStringPool(cc);
        }
        return singleton;
    }

    static public VariativeString get(CallContext cc, String id) {
        return VariativeStringClass.createVariativeStringClass(cc, id, getSingleton(cc));
    }

    static public String get(CallContext cc, String id, String isolang) {
        return getSingleton(cc).getString(cc, id, isolang);
    }

    protected ValidationStringPool (CallContext cc) {
        super(cc);
        /*************************************************/
        /* THE FOLLOWING SECTION IS PARTIALLY GENERATED. */
        /* BE CAREFUL WHEN EDITING MANUALLY !            */
        /*                                               */
        /* See StringPool.java for explanation.          */
        /*************************************************/
        //BEGINNING-OF-STRINGS
        //P-0-.
        //F-0-0-class.java.tpl
        addEntry(cc, "0.0.0", "en", "Some values are invalid");
        addEntry(cc, "0.0.0", "de", "Einige Werte sind ungültig");
        addEntry(cc, "0.0.1", "en", "'%(field)' - invalid input");
        addEntry(cc, "0.0.1", "de", "'%(field)' - Ungültige Eingabe");
        //F-0-1-Class_MailMessageSender.java
        //END-OF-STRINGS
        /*************************************************/
    }
}
