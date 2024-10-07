package com.sphenon.basics.validation.returncodes;

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
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.message.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.notification.*;
import com.sphenon.basics.customary.*;

import com.sphenon.basics.validation.*;

public class ValidationFailure extends ReturnCode {
    static protected long notification_level;
    static public    long adjustNotificationLevel(long new_level) { long old_level = notification_level; notification_level = new_level; return old_level; }
    static public    long getNotificationLevel() { return notification_level; }
    static { notification_level = NotificationLocationContext.getLevel(com.sphenon.basics.context.classes.RootContext.getInitialisationContext(), "com.sphenon.basics.validation.returncodes.ValidationFailure"); };

    protected ValidationFailure (CallContext context, Throwable cause, Message message) {
        super(context, cause, message, message.getMessageText(context));
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, Message message) {
        if ((notification_level & Notifier.MORE_VERBOSE) != 0) { CustomaryContext.create(Context.create(context)).sendTrace(context, Notifier.MORE_VERBOSE, "returning 'ValidationFailure' : %(message)", "message", message == null ? (Object) "(no details)" : (Object) message); }
        return new ValidationFailure(context, cause, message);
    }

    static public ValidationFailure createValidationFailure (CallContext context) {
        return createValidationFailure(context, (Throwable) null, (Message) null);
    }

    static public void createAndThrow (CallContext context) throws ValidationFailure {
        throw createValidationFailure(context);
    }

    static public ValidationFailure createValidationFailure (CallContext context, String message) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message));
        return createValidationFailure(context, (Throwable) null, msg);
    }
    
    static public ValidationFailure createValidationFailure (CallContext context, MessageText message_text) {
        Message msg = DetailMessage.create(context, message_text);
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, String message) throws ValidationFailure {
        throw createValidationFailure(context, message);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, String message) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, String message) throws ValidationFailure {
        throw createValidationFailure(context, cause, message);
    }

    static public ValidationFailure createValidationFailure (CallContext context, String message, Object[][] attributes) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, attributes));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, String message, Object[][] attributes) throws ValidationFailure {
        throw createValidationFailure(context, message, attributes);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, String message, Object[][] attributes) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, attributes));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, String message, Object[][] attributes) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, attributes);
    }

    static public ValidationFailure createValidationFailure (CallContext context, String message, String an1, Object av1) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, String message, String an1, Object av1) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, String message, String an1, Object av1) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, String message, String an1, Object av1) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1);
    }

    static public ValidationFailure createValidationFailure (CallContext context, String message, String an1, Object av1, String an2, Object av2) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, String message, String an1, Object av1, String an2, Object av2) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2);
    }

    static public ValidationFailure createValidationFailure (CallContext context, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2, an3, av3);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2, an3, av3);
    }

    static public ValidationFailure createValidationFailure (CallContext context, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2, an3, av3, an4, av4);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2, an3, av3, an4, av4);
    }

    static public ValidationFailure createValidationFailure (CallContext context, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5);
    }

    static public ValidationFailure createValidationFailure (CallContext context, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, String message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5, String an6, Object av6) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5, an6, av6);
    }

    static public ValidationFailure createValidationFailure (CallContext context, VariativeString message) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, VariativeString message) throws ValidationFailure {
        throw createValidationFailure(context, message);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, VariativeString message) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, VariativeString message) throws ValidationFailure {
        throw createValidationFailure(context, cause, message);
    }

    static public ValidationFailure createValidationFailure (CallContext context, VariativeString message, Object[][] attributes) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, attributes));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, VariativeString message, Object[][] attributes) throws ValidationFailure {
        throw createValidationFailure(context, message, attributes);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, VariativeString message, Object[][] attributes) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, attributes));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, VariativeString message, Object[][] attributes) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, attributes);
    }

    static public ValidationFailure createValidationFailure (CallContext context, VariativeString message, String an1, Object av1) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, VariativeString message, String an1, Object av1) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, VariativeString message, String an1, Object av1) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, VariativeString message, String an1, Object av1) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1);
    }

    static public ValidationFailure createValidationFailure (CallContext context, VariativeString message, String an1, Object av1, String an2, Object av2) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, VariativeString message, String an1, Object av1, String an2, Object av2) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, VariativeString message, String an1, Object av1, String an2, Object av2) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, VariativeString message, String an1, Object av1, String an2, Object av2) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2);
    }

    static public ValidationFailure createValidationFailure (CallContext context, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2, an3, av3);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2, an3, av3);
    }

    static public ValidationFailure createValidationFailure (CallContext context, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2, an3, av3, an4, av4);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2, an3, av3, an4, av4);
    }

    static public ValidationFailure createValidationFailure (CallContext context, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5));
        return createValidationFailure(context, (Throwable) null, msg);
    }

    static public void createAndThrow (CallContext context, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) throws ValidationFailure {
        throw createValidationFailure(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5);
    }

    static public ValidationFailure createValidationFailure (CallContext context, Throwable cause, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) {
        Message msg = DetailMessage.create(context, MessageText.create(context, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5));
        return createValidationFailure(context, cause, msg);
    }

    static public void createAndThrow (CallContext context, Throwable cause, VariativeString message, String an1, Object av1, String an2, Object av2, String an3, Object av3, String an4, Object av4, String an5, Object av5) throws ValidationFailure {
        throw createValidationFailure(context, cause, message, an1, av1, an2, av2, an3, av3, an4, av4, an5, av5);
    }

    protected boolean is_container;

    public boolean getIsContainer (CallContext context) {
        return this.is_container;
    }

    public void setIsContainer (CallContext context, boolean is_container) {
        this.is_container = is_container;
    }

    static public ValidationFailure mergeException (CallContext context, Throwable exception, ValidationFailure vf, String info) {
        if (exception != null) {
            boolean is_vf = (exception instanceof ValidationFailure ? true : false);
            if (vf == null) {
                if (is_vf) {
                    vf = (ValidationFailure) exception;
                } else {
                    vf = ValidationFailure.createValidationFailure(context, null, DetailMessage.create(context, MessageText.create(context, ValidationStringPool.get(context, "0.0.1"), "field", info)));
                    vf.setIsContainer(context, true);
                    vf.addCause(context, exception);
                }
            } else {
                if (vf.getIsContainer(context)) {
                    vf.addCause(context, exception);
                } else {
                    ValidationFailure first_vf = vf;
                    vf = ValidationFailure.createValidationFailure(context, null, DetailMessage.create(context, MessageText.create(context, ValidationStringPool.get(context, "0.0.1"), "field", info)));
                    vf.setIsContainer(context, true);
                    vf.addCause(context, first_vf);
                    vf.addCause(context, exception);
                }
            }
            if (is_vf == false) {
                if ((notification_level & Notifier.OBSERVATION) != 0) { CustomaryContext.create((Context)context).sendNotice(context, "Validation code of %(info) threw an Exception which is not a ValidationFailure: %(exception)", "info", info, "exception", exception); }
            }
        }
        return vf;
    }

    static public void assertValidationOk(CallContext context, ValidationFailure vf) {
        if (vf != null) {
            CustomaryContext.create((Context)context).throwAssertionProvedFalse(context, vf, "Validation failed");
            throw (ExceptionAssertionProvedFalse) null; // compiler insists
        }
    }

}
