package org.apache.dearbaby.task;

import java.util.List;

import org.apache.dearbaby.impl.sql.compile.QueryTreeNode;
import org.apache.dearbaby.join.ResultMap;
import org.apache.dearbaby.query.QueryMananger;
import org.apache.dearbaby.query.SinQuery;

public class JoinTask implements Runnable{
	QueryTreeNode qt ;
	
	public JoinTask(QueryTreeNode _qt ){
		qt=_qt;
	
	}
	public void run(){
		try{
		
			qt.resList=qt.getMatchRows();
			System.out.println("qt......... :  "+qt);;
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			System.out.println("qt-size:  "+qt.resList.size());;
			if(qt.taskCtrl!=null){
				qt.taskCtrl.finishOne();
			}
			//qm.getTaskCtrl().finishOne();
		}
		
	}
	
}
