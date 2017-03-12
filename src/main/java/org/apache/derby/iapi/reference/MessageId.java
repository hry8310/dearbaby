/*

   Derby - Class org.apache.derby.iapi.reference.MessageId

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
 * This class is a refactoring wrapper around the new location
 * in shared/common/reference
 */
public interface MessageId   {
	// Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_BEGIN_ERROR = "L001";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_END_ERROR = "L002";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_BEGIN_CORRUPT_STACK = "L003";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_END_CORRUPT_STACK = "L004";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_BEGIN_ERROR_STACK = "L005";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_END_ERROR_STACK = "L006";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_LOG_NOT_FOUND = "L007";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_DELETE_INCOMPATIBLE_FILE = "L008";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_DELETE_OLD_FILE = "L009";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_INCOMPLETE_LOG_RECORD = "L010";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_CHECKPOINT_EXCEPTION = "L011";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_RECORD_NOT_FIRST = "L012";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_RECORD_FIRST = "L013";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_BAD_START_INSTANT = "L014";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_NEW_LOGFILE_EXIST = "L015";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_CANNOT_CREATE_NEW = "L016";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_CANNOT_CREATE_NEW_DUETO = "L017";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_MAYBE_INCONSISTENT = "L018";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_WAS_IN_DURABILITY_TESTMODE_NO_SYNC = "L020";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_DURABILITY_TESTMODE_NO_SYNC_ERR = "L021";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String LOG_CHANGED_DB_TO_READ_ONLY = "L022";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String BINARY_DATA_HIDDEN = "BIN01";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_BOOT_MSG_READ_ONLY = "D000";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_BOOT_MSG = "D001";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_SHUTDOWN_MSG = "D002";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_BACKUP_STARTED = "D004";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_MOVED_BACKUP = "D005";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_DATA_SEG_BACKUP_COMPLETED = "D006";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_EDITED_SERVICEPROPS = "D007";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_ERROR_EDIT_SERVICEPROPS = "D008";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_COPIED_LOG = "D009";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_BACKUP_ABORTED = "D010";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_REMOVED_BACKUP = "D011";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_BACKUP_COMPLETED = "D012";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_DURABILITY_TESTMODE_NO_SYNC = "D013";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_STREAM_OVERFLOW_PAGE_NOT_FOUND = "D015";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STORE_PAGE_DUMP = "D016";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_WROTE_CLASS_FILE = "C000";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_UNKNOWN_CERTIFICATE = "C001";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_SECURITY_EXCEPTION = "C002";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_LOAD_JAR_EXCEPTION = "C003";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_STALE_LOADER = "C004";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_CLASS_LOADER_START = "C005";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_CLASS_LOAD = "C006";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_CLASS_LOAD_EXCEPTION = "C007";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CM_CANNOT_LOAD_CLASS = "C008";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_SHUT_DOWN_ENGINE = "J003";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DATABASE_IDENTITY = "J004";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_SHUT_DOWN_CLOUDSCAPE = "J005";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DEREGISTER_AUTOLOADEDDRIVER = "J006";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_CREATE_DATABASE = "J007";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_NO_DETAILS = "J008";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DATA_ENCRYPTION = "J010";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_UPGRADE_DATABASE = "J013";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_CRYPTO_PROVIDER = "J016";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_CRYPTO_ALGORITHM = "J017";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_CRYPTO_KEY_LENGTH = "J018";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_CRYPTO_EXTERNAL_KEY = "J019";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_BOOT_PASSWORD = "J020";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_LOCALE = "J021";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_COLLATION = "J031";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_USERNAME_ATTR = "J022";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_PASSWORD_ATTR = "J023";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_LOG_DEVICE = "J025";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_ROLL_FORWARD_RECOVERY_FROM = "J028";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_CREATE_FROM = "J029";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_RESTORE_FROM = "J030";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_NETWORK_SERVER_CLASS_FIND = "J100";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_NETWORK_SERVER_CLASS_LOAD = "J101";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_NETWORK_SERVER_START_EXCEPTION = "J102";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_NETWORK_SERVER_SHUTDOWN_EXCEPTION = "J103";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String OBJECT_CLOSED = "J104";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_PRECISION_TOO_LARGE = "J105";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String BATCH_POSITION_ID = "J107";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String SECURITY_MANAGER_NO_ACCESS_ID = "J108";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String UNKNOWN_HOST_ID = "J109";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_SECMECH_NOT_SUPPORTED = "J110";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_PASSWORD_MISSING = "J111";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_USERID_MISSING = "J112";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_USERID_OR_PASSWORD_INVALID = "J113";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_USERID_REVOKED = "J114";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_NEW_PASSWORD_INVALID = "J115";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_SECSVC_NONRETRYABLE_ERR = "J116";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_SECTKN_MISSING_OR_INVALID = "J117";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_PASSWORD_EXPIRED = "J118";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_NOT_SPECIFIED = "J120";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_USER_NOT_AUTHORIZED_TO_DB = "J121";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DRDA_RDBNACRM = "J122";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DRDA_CMDCHKRM = "J123";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DRDA_RDBACCRM = "J124";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DRDA_DTARMCHRM = "J125";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DRDA_PRCCNVRM = "J126";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_CURSOR_NOT_OPEN = "J128";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DRDA_QRYOPEN = "J129";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DRDA_INVALIDFDOCA = "J130";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DRDA_DATASTREAM_SYNTAX_ERROR = "J131";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_USERNAME_DESCRIPTION = "J132";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_PASSWORD_DESCRIPTION = "J133";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_NEGATIVE_MAXSTATEMENTS = "J134";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_XA_TRANSACTION_TIMED_OUT = "J135";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_CLOSE_XA_TRANSACTION_ROLLED_BACK = "J136";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CONN_DEREGISTER_NOT_PERMITTED = "J137";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String AUTH_NO_SERVICE_FOR_SYSTEM = "A001";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String AUTH_NO_SERVICE_FOR_DB = "A002";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String AUTH_NO_LDAP_HOST_MENTIONED = "A011";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String AUTH_INVALID = "A020";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CORE_DATABASE_NOT_AVAILABLE = "I024";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CORE_DRIVER_NOT_AVAILABLE = "I025";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String JDBC_DRIVER_REGISTER_ERROR = "I026";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STREAM_MARK_UNSET_OR_EXCEEDED = "I027";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STREAM_DRDA_CLIENTSIDE_EXTDTA_READ_ERROR = "I028";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String STREAM_PREMATURE_EOF = "I029";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String SERVICE_PROPERTIES_DONT_EDIT = "M001";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String SERVICE_PROPERTIES_RESTORED = "M002";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String SERVICE_PROPERTIES_BACKUP_DELETED = "M003";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String SERVICE_PROPERTIES_BACKUP_DEL_FAILED = "M004";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String README_AT_DB_LEVEL = "M005";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String README_AT_LOG_LEVEL = "M006";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String README_AT_SEG_LEVEL = "M007";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CANNOT_READ_SECURITY_PROPERTY = "M008";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CANNOT_CREATE_FILE_OR_DIRECTORY = "M009";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String CAUSED_BY = "N001";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_ERROR_BEGIN = "R001";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_ERROR_END = "R002";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_SLAVE_STARTED = "R003";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_SLAVE_STOPPED = "R004";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_FATAL_ERROR = "R005";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_SLAVE_LOST_CONN = "R006";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_MASTER_STARTED = "R007";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_MASTER_STOPPED = "R008";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_LOGSHIPPER_EXCEPTION = "R009";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_MASTER_RECONN = "R010";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_SLAVE_NETWORK_LISTEN = "R011";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_INVALID_CONNECTION_HANDLE = "R012";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_ONELINE_MSG_HEADER = "R013";
	  
	  // Field descriptor #4 Ljava/lang/String;
	  public static final java.lang.String REPLICATION_FAILOVER_SUCCESSFUL = "R020";
	
}
