package lama.gwt.app.client;

import com.google.gwt.user.client.rpc.AsyncCallback;


public interface GreetingServiceAsync {
	
	void solveEquation(int a, int b, int c, AsyncCallback<String> callback);
}
