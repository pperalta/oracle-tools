/*
 * File: DeferredAssert.java
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * The contents of this file are subject to the terms and conditions of 
 * the Common Development and Distribution License 1.0 (the "License").
 *
 * You may not use this file except in compliance with the License.
 *
 * You can obtain a copy of the License by consulting the LICENSE.txt file
 * distributed with this file, or by consulting https://oss.oracle.com/licenses/CDDL
 *
 * See the License for the specific language governing permissions
 * and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file LICENSE.txt.
 *
 * MODIFICATIONS:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 */

package com.oracle.tools.deferred;

import org.hamcrest.Matcher;

import java.util.concurrent.TimeUnit;

import static com.oracle.tools.deferred.DeferredHelper.ensure;

/**
 * The {@link DeferredAssert} is a helper class that defines commonly used
 * "assertThat" methods for the purposes of unit, functional and integration
 * testing.
 * <p>
 * Copyright (c) 2012-2013. All Rights Reserved. Oracle Corporation.<br>
 * Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
 *
 * @author Brian Oliver
 */
public class DeferredAssert
{
    /**
     * Asserts that a {@link Deferred}, when it becomes available,
     * will eventually (after the default amount of time) satisfy the
     * specified {@link Matcher}.
     *
     * @param <T>       the type of value produced by the {@link Deferred}
     *
     * @param deferred  the {@link Deferred}
     * @param matcher   the {@link Matcher}
     *
     * @throws AssertionError if the assertion fails
     */
    public static <T> void assertThat(Deferred<T> deferred,
                                      Matcher<?>  matcher) throws AssertionError
    {
        assertThat(null, deferred, matcher);
    }


    /**
     * Asserts that a {@link Deferred}, when it becomes available,
     * will eventually (after the default amount of time) satisfy the
     * specified {@link Matcher}.
     *
     * @param <T>       the type of value produced by the {@link Deferred}
     *
     * @param message   the message for the AssertionError (<code>null</code> ok)
     * @param deferred  the {@link Deferred}
     * @param matcher   the {@link Matcher}
     *
     * @throws AssertionError if the assertion fails
     */
    public static <T> void assertThat(String      message,
                                      Deferred<T> deferred,
                                      Matcher<?>  matcher) throws AssertionError
    {
        assertThat(message,
                   deferred,
                   matcher,
                   Ensured.DEFAULT_RETRY_DURATION_MS,
                   TimeUnit.MILLISECONDS,
                   Ensured.DEFAULT_TOTAL_RETRY_DURATION_SECS,
                   TimeUnit.SECONDS);
    }


    /**
     * Asserts that a {@link Deferred}, when it becomes available,
     * will eventually (after the specified amount of time) satisfy the
     * specified {@link Matcher}.
     *
     * @param <T>       the type of value produced by the {@link Deferred}
     *
     * @param deferred                 the {@link Deferred}
     * @param matcher                  the {@link Matcher}
     * @param totalRetryDuration       the maximum duration for retrying
     * @param totalRetryDurationUnits  the {@link TimeUnit}s for the duration
     *
     * @throws AssertionError if the assertion fails
     */
    public static <T> void assertThat(Deferred<T>        deferred,
                                      Matcher<? super T> matcher,
                                      long               totalRetryDuration,
                                      TimeUnit           totalRetryDurationUnits) throws AssertionError
    {
        assertThat(null,
                   deferred,
                   matcher,
                   Ensured.DEFAULT_RETRY_DURATION_MS,
                   TimeUnit.MILLISECONDS,
                   totalRetryDuration,
                   totalRetryDurationUnits);
    }


    /**
     * Asserts that a {@link Deferred}, when it becomes available,
     * will eventually (after the specified amount of time) satisfy the
     * specified {@link Matcher}.
     *
     * @param <T>       the type of value produced by the {@link Deferred}
     *
     * @param message                  the message for the AssertionError (<code>null</code> ok)
     * @param deferred                 the {@link Deferred}
     * @param matcher                  the {@link Matcher}
     * @param totalRetryDuration       the maximum duration for retrying
     * @param totalRetryDurationUnits  the {@link TimeUnit}s for the duration
     *
     * @throws AssertionError if the assertion fails
     */
    public static <T> void assertThat(String             message,
                                      Deferred<T>        deferred,
                                      Matcher<? super T> matcher,
                                      long               totalRetryDuration,
                                      TimeUnit           totalRetryDurationUnits) throws AssertionError
    {
        assertThat(message,
                   deferred,
                   matcher,
                   Ensured.DEFAULT_RETRY_DURATION_MS,
                   TimeUnit.MILLISECONDS,
                   totalRetryDuration,
                   totalRetryDurationUnits);
    }


    /**
     * Asserts that a {@link Deferred}, when it becomes available,
     * will eventually (after the specified amount of time) satisfy the
     * specified {@link Matcher}.
     *
     * @param <T>       the type of value produced by the {@link Deferred}
     *
     * @param deferred                 the {@link Deferred}
     * @param matcher                  the {@link Matcher}
     * @param retryDelayDuration       the time to wait between retrying
     * @param retryDelayDurationUnits  the {@link TimeUnit}s for the retry delay duration
     * @param totalRetryDuration       the maximum duration for retrying
     * @param totalRetryDurationUnits  the {@link TimeUnit}s for the duration
     *
     * @throws AssertionError if the assertion fails
     */
    public static <T> void assertThat(Deferred<T> deferred,
                                      Matcher<?>  matcher,
                                      long        retryDelayDuration,
                                      TimeUnit    retryDelayDurationUnits,
                                      long        totalRetryDuration,
                                      TimeUnit    totalRetryDurationUnits) throws AssertionError
    {
        assertThat(deferred,
                   matcher,
                   retryDelayDuration,
                   retryDelayDurationUnits,
                   totalRetryDuration,
                   totalRetryDurationUnits);
    }


    /**
     * Asserts that a {@link Deferred}, when it becomes available,
     * will eventually (after the specified amount of time) satisfy the
     * specified {@link Matcher}.
     *
     * @param <T>       the type of value produced by the {@link Deferred}
     *
     * @param message                  the message for the AssertionError (<code>null</code> ok)
     * @param deferred                 the {@link Deferred}
     * @param matcher                  the {@link Matcher}
     * @param retryDelayDuration       the time to wait between retrying
     * @param retryDelayDurationUnits  the {@link TimeUnit}s for the retry delay duration
     * @param totalRetryDuration       the maximum duration for retrying
     * @param totalRetryDurationUnits  the {@link TimeUnit}s for the duration
     *
     * @throws AssertionError if the assertion fails
     */
    public static <T> void assertThat(String      message,
                                      Deferred<T> deferred,
                                      Matcher<?>  matcher,
                                      long        retryDelayDuration,
                                      TimeUnit    retryDelayDurationUnits,
                                      long        totalRetryDuration,
                                      TimeUnit    totalRetryDurationUnits) throws AssertionError
    {
        // a DeferredMatcher does the heavy lifting
        DeferredMatch<T> deferredMatch = new DeferredMatch<T>(deferred, matcher);

        try
        {
            ensure(deferredMatch,
                   retryDelayDuration,
                   retryDelayDurationUnits,
                   totalRetryDuration,
                   totalRetryDurationUnits);
        }
        catch (ObjectNotAvailableException e)
        {
            AssertionError error;

            if (deferredMatch.getLastUsedMatchValue() == null)
            {
                error = new AssertionError((message == null ? "" : message + ": ") + "Failed to resolve a value for ["
                                           + deferredMatch.getDeferred() + "] to evaluate with matcher ["
                                           + deferredMatch.getMatcher() + "]");
                error.initCause(e);
            }
            else
            {
                error = new AssertionError((message == null ? "" : message + ": ") + "Matcher [" + matcher
                                           + "] failed to match last resolved value ["
                                           + deferredMatch.getLastUsedMatchValue() + "] for ["
                                           + deferredMatch.getDeferred() + "]");
                error.initCause(e);
            }

            throw error;
        }
        catch (Exception e)
        {
            AssertionError error = new AssertionError((message == null ? "" : message + ": ")
                                                      + "Unexpected exception when attempting to resolve a value for ["
                                                      + deferredMatch.getDeferred() + "] to evaluate with matcher ["
                                                      + deferredMatch.getMatcher() + "]");

            error.initCause(e);

            throw error;
        }
    }
}
