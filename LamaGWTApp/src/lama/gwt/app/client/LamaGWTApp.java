package lama.gwt.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;


public class LamaGWTApp implements EntryPoint {
	
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	
	public void onModuleLoad() {
		final TextArea text_a=new TextArea();
		final TextArea text_b=new TextArea();
		final TextArea text_c=new TextArea();
	    Label label1=new Label("Parameter a");
	    Label label2=new Label("Parameter b");
	    Label label3=new Label("Parameter c");
	    final Button button = new Button("solve it!!!!");

		
	    RootPanel.get().add(label1);
		RootPanel.get().add(text_a);
		 RootPanel.get().add(label2);
		RootPanel.get().add(text_b);
		 RootPanel.get().add(label3);
		RootPanel.get().add(text_c);
		RootPanel.get().add(button);

		
		
	button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
			button.setEnabled(true);
			button.setFocus(true);
			}
		});

		
		class MyHandler implements ClickHandler, KeyUpHandler {
			
			public void onClick(ClickEvent event) {
				sendParamsToServer();
			}

			
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendParamsToServer();
				}
			}

			
			private void sendParamsToServer() {
								
				int aa=Integer.valueOf(text_a.getText());
		    	 int bb=Integer.valueOf(text_b.getText());
			     int cc=Integer.valueOf(text_c.getText());
				greetingService.solveEquation(aa,bb,cc,new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								Window.alert("fail to connect to server....");
							}

							public void onSuccess(String result) {
								Window.alert(result);
							}
						});
			}
		}

		
		MyHandler handler = new MyHandler();
		button.addClickHandler(handler);
		
	}
}
