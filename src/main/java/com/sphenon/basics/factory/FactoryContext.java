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
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.function.*;

import java.util.Vector;

public class FactoryContext extends SpecificContext {

    static public FactoryContext get(Context context) {
        FactoryContext factory_context = (FactoryContext) context.getSpecificContext(FactoryContext.class);
        return factory_context;
    }

    static public FactoryContext create(Context context) {
        FactoryContext factory_context = new FactoryContext(context, false);
        context.setSpecificContext(FactoryContext.class, factory_context);
        return factory_context;
    }

    protected FactoryContext (Context context, boolean is_default_singelton) {
        super(context);
    }

    public<FactoryType> FactoryType newInstance (CallContext context, Class<FactoryType> factory_class) {
        return null;
    }

    protected Vector<String> factory_sub_package_search_path;

    public void addFactorySubPackage(CallContext context, String sub_package) {
        if (this.factory_sub_package_search_path == null) {
            this.factory_sub_package_search_path = this.getFactorySubPackageSearchPath(context);
            if (this.factory_sub_package_search_path != null) {
                this.factory_sub_package_search_path = (Vector<String>) (this.factory_sub_package_search_path.clone());
            } else {
                this.factory_sub_package_search_path = new Vector<String>();
            }
        }
        this.factory_sub_package_search_path.add(sub_package);
    }

    public Vector<String> getFactorySubPackageSearchPath(CallContext context) {
        FactoryContext factory_context;
        return (this.factory_sub_package_search_path != null ?
                     this.factory_sub_package_search_path
                  : (factory_context = (FactoryContext) this.getCallContext(FactoryContext.class)) != null ?
                       factory_context.getFactorySubPackageSearchPath(context)
                     : null
               );
    }
    
    protected String factory_prefix;
    protected Getter<String> factory_prefix_source;
    
    public void setFactoryPrefixSource(CallContext context, Getter<String> factory_prefix_source){
        this.factory_prefix_source = factory_prefix_source;
    }

    public void setFactoryPrefix(CallContext context, String prefix){
        this.factory_prefix = prefix;
    }
    
    public String getFactoryPrefix(CallContext context){
        FactoryContext factory_context;
        String fp = null;
        return ( (    this.factory_prefix_source != null
                   && ((fp = this.factory_prefix_source.get(context)) != null)
                 ) ?
                    fp
                : this.factory_prefix != null ?
                    this.factory_prefix
                : (factory_context = (FactoryContext) this.getCallContext(FactoryContext.class)) != null ?
                    factory_context.getFactoryPrefix(context)
                : null
               );
    }
}
