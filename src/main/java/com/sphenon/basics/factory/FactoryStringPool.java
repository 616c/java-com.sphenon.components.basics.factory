package com.sphenon.basics.factory;

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

public class FactoryStringPool extends StringPoolClass {
    static protected FactoryStringPool singleton = null;

    static public FactoryStringPool getSingleton (CallContext cc) {
        if (singleton == null) {
            singleton = new FactoryStringPool(cc);
        }
        return singleton;
    }

    static public VariativeString get(CallContext cc, String id) {
        return VariativeStringClass.createVariativeStringClass(cc, id, getSingleton(cc));
    }

    static public String get(CallContext cc, String id, String isolang) {
        return getSingleton(cc).getString(cc, id, isolang);
    }

    protected FactoryStringPool (CallContext cc) {
        super(cc);
        /*************************************************/
        /* THE FOLLOWING SECTION IS PARTIALLY GENERATED. */
        /* BE CAREFUL WHEN EDITING MANUALLY !            */
        /*                                               */
        /* See StringPool.java for explanation.          */
        /*************************************************/
        //BEGINNING-OF-STRINGS
        //P-0-com.sphenon.basics.factory
        //F-0-0-factory.java.tpl
        addEntry(cc, "0.0.0", "en", "Cannot instantiate abstract class '%(class)'");
        addEntry(cc, "0.0.0", "de", "Abstrakte Klasse '%(class)' kann nicht instantiiert werden");
        addEntry(cc, "0.0.1", "en", "Cannot instantiate abstract class '%(class)'");
        addEntry(cc, "0.0.1", "de", "Abstrakte Klasse '%(class)' kann nicht instantiiert werden");
        addEntry(cc, "0.0.2", "en", "Creation failed, invalid factory parameters");
        addEntry(cc, "0.0.2", "de", "Erzeugung schlug fehl, ungültiger Fabrik-Parameter");
        addEntry(cc, "0.0.3", "en", "Creation failed, new instance has invalid members");
        addEntry(cc, "0.0.3", "de", "Erzeugung schlug fehl, neue Instanz enthält ungültige Werte");
        addEntry(cc, "0.0.4", "en", "Some factory parameters are invalid.");
        addEntry(cc, "0.0.4", "de", "Einige Fabrik-Parameter sind ungültig.");
        addEntry(cc, "0.0.5", "en", "Creation failed, instance is invalid despite valid factory parameters");
        addEntry(cc, "0.0.5", "de", "Erzeugung schlug fehl, Instanz ist ungültig trotz gültiger Fabrik-Parameter");
        //END-OF-STRINGS
        /*************************************************/
    }
}
