package lama.gwt.app.server;

import lama.gwt.app.client.GreetingService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;


@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String solveEquation(int a,int b,int c) throws IllegalArgumentException {
		double  temp1;
	    String root1,root2;
	    String result;
		temp1 = Math.sqrt(b * b - 4 * a * c);
	if(temp1>0)
		{ 	root1 =(-b +  temp1) / (2*a)+" " ;
			root2 =(-b -  temp1) / (2*a)+" " ;
		   	result="the equation has two different roots"+"First root:"+root1+"Second root:"+root2;
	      	 return result;
	      	}
	
		else if(temp1==0)
		{root1 = (-b) / (2*a)+" " ;
		 result="the equation has one root:"+"  "+root1;
		 return result;
		 	}
	
		else 
		{result="the equation has no root = impossible to solve";
		return result;
		}
    
	}
}
