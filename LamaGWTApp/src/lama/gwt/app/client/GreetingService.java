package lama.gwt.app.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;


@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	String solveEquation(int a,int b,int c) throws IllegalArgumentException;
}
