/*

   Derby - Class org.apache.derby.impl.sql.compile.AlterTableNode

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
import org.apache.derby.iapi.services.context.ContextManager;
import org.apache.derby.iapi.sql.compile.Visitor;
import org.apache.derby.iapi.sql.dictionary.ConstraintDescriptorList;
import org.apache.derby.iapi.sql.dictionary.DataDictionary;
import org.apache.derby.iapi.sql.dictionary.SchemaDescriptor;
import org.apache.derby.iapi.sql.dictionary.TableDescriptor;  
/**
 * A AlterTableNode represents a DDL statement that alters a table.
 * It contains the name of the object to be created.
 *
 */

class AlterTableNode extends DDLStatementNode
{
	// The alter table action
	public	TableElementList	tableElementList = null;
     char               lockGranularity;

	/**
	 * updateStatistics will indicate that we are here for updating the
	 * statistics. It could be statistics of just one index or all the
	 * indexes on a given table. 
	 */
	private	boolean				updateStatistics = false;
	/**
	 * The flag updateStatisticsAll will tell if we are going to update the 
	 * statistics of all indexes or just one index on a table. 
	 */
	private	boolean				updateStatisticsAll = false;
	/**
	 * dropStatistics will indicate that we are here for dropping the
	 * statistics. It could be statistics of just one index or all the
	 * indexes on a given table. 
	 */
	private	    boolean					    dropStatistics;
	/**
	 * The flag dropStatisticsAll will tell if we are going to drop the 
	 * statistics of all indexes or just one index on a table. 
	 */
	private	    boolean					    dropStatisticsAll;
	/**
	 * If statistic is getting updated/dropped for just one index, then 
	 * indexNameForStatistics will tell the name of the specific index 
	 * whose statistics need to be updated/dropped.
	 */
	private	String				indexNameForStatistics;
	
	public	boolean				compressTable = false;
	public	boolean				sequential = false;
	//The following three (purge, defragment and truncateEndOfTable) apply for 
	//inplace compress
	public	boolean				purge = false;
	public	boolean				defragment = false;
	public	boolean				truncateEndOfTable = false;
	
	public	int					behavior;	// currently for drop column

	public	TableDescriptor		baseTable;

	protected	int						numConstraints;

	private		int				changeType = UNKNOWN_TYPE;

	private boolean             truncateTable = false;

	// constant action arguments

	protected	SchemaDescriptor			schemaDescriptor = null; 


	/**
     * Constructor for TRUNCATE TABLE
	 *
     * @param tableName The name of the table being truncated
     * @param cm Context manager
     * @exception StandardException
	 */
    AlterTableNode(TableName tableName,
                   ContextManager cm) throws StandardException {
        super(tableName, cm);
		truncateTable = true;
		schemaDescriptor = getSchemaDescriptor();
	}
	
	/**
     * Constructor  for COMPRESS using temporary tables
     * rather than in place compress
	 *
     * @param tableName The name of the table being altered
     * @param sequential Whether or not the COMPRESS is SEQUENTIAL
     * @param cm Context manager
	 *
	 * @exception StandardException		Thrown on error
	 */
    AlterTableNode(TableName tableName,
                   boolean sequential,
                   ContextManager cm) throws StandardException {
        super(tableName, cm);
        this.sequential = sequential;
		compressTable = true;
		schemaDescriptor = getSchemaDescriptor();
	}

	/**
     * Constructor for INPLACE COMPRESS
	 *
     * @param tableName The name of the table being altered
     * @param purge PURGE during INPLACE COMPRESS?
     * @param defragment DEFRAGMENT during INPLACE COMPRESS?
     * @param truncateEndOfTable TRUNCATE END during INPLACE COMPRESS?
     * @param cm Context manager
	 *
	 * @exception StandardException		Thrown on error
	 */
    AlterTableNode(TableName tableName,
                   boolean purge,
                   boolean defragment,
                   boolean truncateEndOfTable,
                   ContextManager cm) throws StandardException {
        super(tableName, cm);
        this.purge = purge;
        this.defragment = defragment;
        this.truncateEndOfTable = truncateEndOfTable;
		compressTable = true;
		schemaDescriptor = getSchemaDescriptor(true, false);
	}

    /**
     * Constructor for UPDATE_STATISTICS or DROP_STATISTICS
     *
     * @param tableName The name of the table being altered
     * @param changeType update or drop statistics
     * @param statsAll {@code true} means update or drop
     *        the statistics of all the indexes on the table.
     *        {@code false} means update or drop the statistics of
     *        only the index name provided by next parameter.
     * @param indexName Name of the index for which statistics is to be updated
     *                  or dropped
     * @param cm Context manager
     * @throws StandardException
     */
    AlterTableNode(
            TableName tableName,
            int changeType,
            boolean statsAll,
            String indexName,
            ContextManager cm) throws StandardException {
        super(tableName, cm);
        this.changeType = changeType;
        this.indexNameForStatistics = indexName;

        switch (changeType) {
            case UPDATE_STATISTICS:
                this.updateStatisticsAll = statsAll;
                updateStatistics = true;
                break;
            case DROP_STATISTICS:
                this.dropStatisticsAll = statsAll;
                dropStatistics = true;
                break;
            default:;
                 
        }

        schemaDescriptor = getSchemaDescriptor();
    }

    /**
     * Constructor for ADD_TYPE, DROP_TYPE, MODIFY_TYPE and LOCK_TYPE
     * @param tableName  The name of the table being altered
     * @param changeType add, drop, modify or lock
     * @param impactedElements list of table elements impacted
     * @param lockGranularity lock granularity encoded in a single character
     * @param behavior cascade or restrict (for DROP_TYPE)
     * @param cm Context Manager
     * @throws StandardException
     */
    AlterTableNode(
            TableName tableName,
            int changeType,
            TableElementList impactedElements,
            char lockGranularity,
            int behavior,
            ContextManager cm) throws StandardException {
        super(tableName, cm);
        this.changeType = changeType;

        switch (changeType) {
            case ADD_TYPE:
		    case DROP_TYPE:
		    case MODIFY_TYPE:
		    case LOCKING_TYPE:
                this.tableElementList = impactedElements;
                this.lockGranularity = lockGranularity;
                this.behavior = behavior;
				break;
		    default:;
        }
        schemaDescriptor = getSchemaDescriptor();
    }

     

	/**
	 * Prints the sub-nodes of this object.  See QueryTreeNode.java for
	 * how tree printing is supposed to work.
	 * @param depth		The depth to indent the sub-nodes
	 */
     

public String statementToString()
	{
		if(truncateTable)
			return "TRUNCATE TABLE";
		else
			return "ALTER TABLE";
	}

	public	int	getChangeType() { return changeType; }

	// We inherit the generate() method from DDLStatementNode.

	 

	/**
	 * Return true if the node references SESSION schema tables (temporary or permanent)
	 *
	 * @return	true if references SESSION schema tables, else false
	 *
	 * @exception StandardException		Thrown on error
	 */
    @Override
	public boolean referencesSessionSchema()
		throws StandardException
	{
		//If alter table is on a SESSION schema table, then return true. 
		return isSessionSchema(baseTable.getSchemaName());
	}

	 

	/**
	  *	Generate arguments to constant action. Called by makeConstantAction() in this class and in
	  *	our subclass RepAlterTableNode.
	  *
	  *
	  * @exception StandardException		Thrown on failure
	  */
	private void	prepConstantAction() throws StandardException
	{
		if (tableElementList != null)
		{
			genColumnInfo();
		}
 
	}
	  
	/**
	  *	Generate the ColumnInfo argument for the constant action. Return the number of constraints.
	  */
	public	void	genColumnInfo()
        throws StandardException
	{
		 
	}


	/**
	 * Accept the visitor for all visitable children of this node.
	 * 
	 * @param v the visitor
	 *
	 * @exception StandardException on error
	 */
    @Override
	void acceptChildren(Visitor v)
		throws StandardException
	{
		super.acceptChildren(v);

		if (tableElementList != null)
		{
			tableElementList.accept(v);
		}
	}

	/*
	 * class interface
	 */
}




