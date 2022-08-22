/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.cassandra.utils;

import java.util.regex.Pattern;


//TODO - finalise naming of class
public class PasswordValidator
{

    //TODO - Need to find an agreed set of rules, symbols might get complex, given there's a lot fo them.
    private static final Pattern PASSWORD_STRENGTH_PATTERN = Pattern.compile("^[(.?[a-z]{1,})(.?[A-Z]{1,})(.?[0-9]{1,})]{8,}$");


    //TODO - After discussion with Stefan, abandon Regex approach for a configurable warn/err guardrails approach.
    /**
     * Validate a string against the following rules:
     * - Inputted value is not null.
     * - Password contains atleast one lower case character.
     * - Password contains atleast one uppercase character.
     * - Password contains atleast one numeric character.
     * @param str - The inbound string to validate
     * @return - True if all validations pass, false if not.
     */
    public static boolean validatePasswordStength(final String str)
    {
       return str != null && PASSWORD_STRENGTH_PATTERN.matcher(str).matches();
    }
}
