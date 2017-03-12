/*

   Derby - Class org.apache.derby.iapi.error.ExceptionSeverity

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to you under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

      http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */

package org.apache.derby.iapi.reference;

/**
 * This is a refactoring wrapper around the common ExceptionSeverity class
 * and may be removed at some point in the future.
 *
 * See org.apache.derby.common.error.ExceptionSeverity
 */
public interface ExceptionSeverity 
  
{

	  // Field descriptor #4 I
	  public static final int NO_APPLICABLE_SEVERITY = 0;
	  
	  // Field descriptor #4 I
	  public static final int WARNING_SEVERITY = 10000;
	  
	  // Field descriptor #4 I
	  public static final int STATEMENT_SEVERITY = 20000;
	  
	  // Field descriptor #4 I
	  public static final int TRANSACTION_SEVERITY = 30000;
	  
	  // Field descriptor #4 I
	  public static final int SESSION_SEVERITY = 40000;
	  
	  // Field descriptor #4 I
	  public static final int DATABASE_SEVERITY = 45000;
	  
	  // Field descriptor #4 I
	  public static final int SYSTEM_SEVERITY = 50000;
	
}

