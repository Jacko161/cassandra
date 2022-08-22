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

import java.util.UUID;

import org.junit.Assert;
import org.junit.Test;

public class PasswordValidatorTest
{

    @Test
    public void testWhenLowStrengthPasswordSupplied_PasswordValidatorReturnsFalse()
    {
        Assert.assertFalse(PasswordValidator.validatePasswordStength("password"));
    }

    @Test
    public void testWhenEmptyPasswordProvided_PasswordValidatorReturnsFalse()
    {
        Assert.assertFalse(PasswordValidator.validatePasswordStength(""));
    }

    @Test
    public void testWhenNullPasswordSupplied_PasswordValidatorReturnsFalse()
    {
        Assert.assertFalse(PasswordValidator.validatePasswordStength(null));
    }

    @Test
    public void testWhenStrongerPasswordSupplied_PasswordValidatorReturnsTrue()
    {
        //Compute a random 'Password' - UUIDs should meet the rules we outline.
        //TODO - replace this call below with an actual strong password when we finalise on approach and rules.
        Assert.assertFalse(PasswordValidator.validatePasswordStength(UUID.randomUUID().toString()));
    }

}
