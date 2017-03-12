package org.apache.dearbaby.ext;

import org.apache.dearbaby.impl.sql.compile.CompilerContextImpl;
import org.apache.dearbaby.impl.sql.compile.ParserImpl;
import org.apache.derby.iapi.services.context.ContextManager;
import org.apache.derby.iapi.services.context.ContextService;
import org.apache.derby.iapi.sql.compile.CompilerContext;
import org.apache.derby.iapi.sql.compile.Parser;
import org.apache.derby.iapi.sql.conn.LanguageConnectionContext;
 

public class DearContext {
	    
		public static Parser getParser(){
			try{
			 	return new ParserImpl( new CompilerContextImpl());
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
}
