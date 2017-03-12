/*

   Derby - Class org.apache.derby.impl.sql.compile.AccessPathImpl

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

package	org.apache.dearbaby.impl.sql.compile;

import org.apache.derby.iapi.reference.SQLState;
import org.apache.derby.iapi.reference.StandardException; 
import org.apache.derby.iapi.sql.compile.AccessPath;
import org.apache.derby.iapi.sql.compile.JoinStrategy;
import org.apache.derby.iapi.sql.compile.Optimizer;
import org.apache.derby.iapi.sql.dictionary.ConglomerateDescriptor;
import org.apache.derby.iapi.sql.dictionary.ConstraintDescriptor;
import org.apache.derby.iapi.sql.dictionary.DataDictionary;
import org.apache.derby.iapi.sql.dictionary.TableDescriptor;

class AccessPathImpl implements AccessPath
{
	ConglomerateDescriptor	cd = null; 
	boolean					coveringIndexScan = false;
	boolean					nonMatchingIndexScan = false;
	JoinStrategy			joinStrategy = null;
	int						lockMode;
	Optimizer				optimizer;
    private String          accessPathName =  "";

	AccessPathImpl(Optimizer optimizer)
	{
		this.optimizer = optimizer;
	}

	/** @see AccessPath#setConglomerateDescriptor */
	public void setConglomerateDescriptor(ConglomerateDescriptor cd)
	{
		this.cd = cd;
	}

	/** @see AccessPath#getConglomerateDescriptor */
	public ConglomerateDescriptor getConglomerateDescriptor()
	{
		return cd;
	}

 

	/** @see AccessPath#setCoveringIndexScan */
	public void setCoveringIndexScan(boolean coveringIndexScan)
	{
		this.coveringIndexScan = coveringIndexScan;
	}

	/** @see AccessPath#getCoveringIndexScan */
	public boolean getCoveringIndexScan()
	{
		return coveringIndexScan;
	}

	/** @see AccessPath#setNonMatchingIndexScan */
	public void setNonMatchingIndexScan(boolean nonMatchingIndexScan)
	{
		this.nonMatchingIndexScan = nonMatchingIndexScan;
	}

	/** @see AccessPath#getNonMatchingIndexScan */
	public boolean getNonMatchingIndexScan()
	{
		return nonMatchingIndexScan;
	}

	/** @see AccessPath#setJoinStrategy */
	public void setJoinStrategy(JoinStrategy joinStrategy)
	{
		this.joinStrategy = joinStrategy;
	}

	/** @see AccessPath#getJoinStrategy */
	public JoinStrategy getJoinStrategy()
	{
		return joinStrategy;
	}

	/** @see AccessPath#setLockMode */
	public void setLockMode(int lockMode)
	{
		this.lockMode = lockMode;
	}

	/** @see AccessPath#getLockMode */
	public int getLockMode()
	{
		return lockMode;
	}

	/** @see AccessPath#copy */
	public void copy(AccessPath copyFrom)
	{
		setConglomerateDescriptor(copyFrom.getConglomerateDescriptor()); 
		setCoveringIndexScan(copyFrom.getCoveringIndexScan());
		setNonMatchingIndexScan(copyFrom.getNonMatchingIndexScan());
		setJoinStrategy(copyFrom.getJoinStrategy());
		setLockMode(copyFrom.getLockMode());
	}

	/** @see AccessPath#getOptimizer */
	public Optimizer getOptimizer()
	{
		return optimizer;
	}

    @Override
	public String toString()
	{
		 
		{
			return "";
		}
	}
	
	/** @see AccessPath#initializeAccessPathName */
	public void initializeAccessPathName(DataDictionary dd, TableDescriptor td)
	       throws StandardException
	{
		if (cd == null)
			return;

		if (cd.isConstraint())
		{
			ConstraintDescriptor constraintDesc = 
				dd.getConstraintDescriptor(td, cd.getUUID());
			if (constraintDesc == null)
			{
				throw StandardException.newException(
										SQLState.LANG_OBJECT_NOT_FOUND,
										"CONSTRAINT on TABLE",
										td.getName());
			}
			accessPathName = constraintDesc.getConstraintName();
		} 
		else if (cd.isIndex())
		{
			accessPathName = cd.getConglomerateName();
		} 
		else 
		{
			accessPathName = "";
		} 
	}
}
