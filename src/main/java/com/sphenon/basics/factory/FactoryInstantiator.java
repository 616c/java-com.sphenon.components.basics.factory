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
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.customary.*;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.HashMap;
import java.util.Vector;

abstract public class FactoryInstantiator<FactoryType> {

    protected Constructor<FactoryType> implementation_constructor;
    protected Class<FactoryType>       factory_class;
    protected Configuration            configuration;

    public FactoryInstantiator (CallContext context, Class factory_class) {
        this.factory_class = factory_class;
        this.configuration = Configuration.create(context, factory_class.getName());
        String implementation_class_name = this.configuration.get(context, "ImplementationClass", (String) null);
        this.implementation_constructor = this.getConstructor(context, implementation_class_name, true);
    }

    protected Constructor<FactoryType> getConstructor(CallContext context, String implementation_class_name, boolean must_exist) {
        Class<FactoryType> implementation_class = null;
        if (implementation_class_name == null || implementation_class_name.length() == 0) {
            return null;
        } else {
            try {
                implementation_class = (Class<FactoryType>) com.sphenon.basics.cache.ClassCache.getClassForName(context, implementation_class_name);
            } catch (ClassNotFoundException cnfe) {
                if (must_exist) {
                    CustomaryContext.create((Context)context).throwConfigurationError(context, cnfe, "Factory implementation class '%(implclass)' does not exist", "implclass", implementation_class_name);
                    throw (ExceptionConfigurationError) null; // compiler insists
                } else {
                    return null;
                }
            }
            try {
                this.implementation_constructor = implementation_class.getConstructor(CallContext.class);
            } catch (NoSuchMethodException nsme) {
                CustomaryContext.create((Context)context).throwConfigurationError(context, nsme, "Factory implementation class '%(implclass)' has no appropriate constructor", "implclass", implementation_class_name);
                throw (ExceptionConfigurationError) null; // compiler insists
            }
        }
        return this.implementation_constructor;
    }

    abstract protected FactoryType createDefault (CallContext context);

    protected Map<Vector<String>,Constructor<FactoryType>> implementation_constructor_by_fspsp;
    
    protected Map<Vector<String>,Constructor<FactoryType>> implementation_constructor_by_fp;

    public FactoryType newInstance (CallContext context) {
        FactoryContext fc = FactoryContext.get((Context) context);
        FactoryType result;
        try {
            if (fc != null) {
                if (factory_class != null && (result = fc.newInstance(context, factory_class)) != null) {
                    return result;
                }
                Vector<String> fspsp = fc.getFactorySubPackageSearchPath(context);
                if (fspsp != null) {
                    if (this.implementation_constructor_by_fspsp == null) {
                        this.implementation_constructor_by_fspsp = new HashMap<Vector<String>,Constructor<FactoryType>>();
                    }
                    Constructor<FactoryType> ic = null;
                    if (this.implementation_constructor_by_fspsp.containsKey(fspsp)) {
                        ic = this.implementation_constructor_by_fspsp.get(fspsp);
                    } else {
                        String fcn = factory_class.getName();
                        int pos = fcn.lastIndexOf('.');
                        String fcnp = (pos == -1 ? "" : fcn.substring(0, pos+1));
                        String fcnn = (pos == -1 ? fcn : fcn.substring(pos+1));
                        for (String fsp : fspsp) {
                            ic = this.getConstructor(context, fcnp + fsp + "." + fcnn, false);
                            if (ic != null) { break; }
                        }
                        this.implementation_constructor_by_fspsp.put(fspsp, ic);
                    }
                    if (ic != null) {
                        return ic.newInstance(context);
                    }
                }
                Vector<String> fps = fc.getFactoryPrefix(context);
                if (fps != null) {
                    if (this.implementation_constructor_by_fp == null) {
                        this.implementation_constructor_by_fp = new HashMap<Vector<String>,Constructor<FactoryType>>();
                    }
                    Constructor<FactoryType> ic = null;
                    if (this.implementation_constructor_by_fp.containsKey(fps)) {
                        ic = this.implementation_constructor_by_fp.get(fps);
                    } else {
                        String fcn = factory_class.getName();
                        String p = "";
                        int pos = fcn.lastIndexOf('.');
                        String fcnp = (pos == -1 ? "" : fcn.substring(0, pos+1));
                        String fcnn = (pos == -1 ? fcn : fcn.substring(pos+1));
                        for (String fp : fps) {
                            p += fp+"_";
                            ic = this.getConstructor(context, fcnp+p+fcnn, false);
                            if (ic != null) { break; }
                        }
                        this.implementation_constructor_by_fp.put(fps, ic);
                    }
                    if (ic != null) {
                        return ic.newInstance(context);
                    }
                }
            }
            if (this.implementation_constructor != null) {
                return this.implementation_constructor.newInstance(context);
            }
            return this.createDefault(context);
        } catch (ClassCastException cce) {
            CustomaryContext.create((Context)context).throwConfigurationError(context, cce, "Factory implementation class '%(implclass)' instantiation failed", "implclass", this.factory_class.getName());
            throw (ExceptionConfigurationError) null; // compiler insists
        } catch (InstantiationException ie) {
            CustomaryContext.create((Context)context).throwConfigurationError(context, ie, "Factory implementation class '%(implclass)' instantiation failed", "implclass", this.factory_class.getName());
            throw (ExceptionConfigurationError) null; // compiler insists
        } catch (IllegalAccessException iae) {
            CustomaryContext.create((Context)context).throwConfigurationError(context, iae, "Factory implementation class '%(implclass)' instantiation failed", "implclass", this.factory_class.getName());
            throw (ExceptionConfigurationError) null; // compiler insists
        } catch (Error e) {
            throw e;
        } catch (RuntimeException re) {
            throw re;
        } catch (Throwable t) {
            CustomaryContext.create((Context)context).throwConfigurationError(context, t, "Factory implementation class '%(implclass)' instantiation failed", "implclass", this.factory_class.getName());
            throw (ExceptionConfigurationError) null; // compiler insists
        }
    }
}
