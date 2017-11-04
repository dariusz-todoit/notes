package com.tutorialspoint.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.PopupPanel;

public class Panel implements EntryPoint {
	
	private static class MyPopup extends PopupPanel {
		public MyPopup() {
		// PopupPanel's constructor takes 'auto-hide' as its boolean
		// parameter. If this is set, the panel closes itself
		// automatically when the user clicks outside of it.
		super(true);
		// PopupPanel is a SimplePanel, so you have to set it's widget
		// property to whatever you want its contents to be.
		setWidget(new Label("Click outside of this popup to close it"));
		}
		}

	@Override
	public void onModuleLoad() {
		
		Button b1 = new Button("Click me to show popup");
		
		
		
		final MyPopup myPopup = new MyPopup();
		final TextArea textArea1 = new TextArea();
		textArea1.setCharacterWidth(20);
		textArea1.setVisibleLines(5);
		final VerticalPanel vPanel = new VerticalPanel();
		vPanel.add(textArea1);
		Button redButton = new Button("Red");
    	redButton.setWidth("100px");
    	vPanel.add(redButton);
    	myPopup.setWidget(vPanel);
		b1.addClickHandler(new ClickHandler() {
		public void onClick(ClickEvent event) {		
		myPopup.center();
		}
		});
		
		final String[] notesContent = new String[100];
		notesContent[0] = "lorem ipsum dolor";
		notesContent[1] = "inna notatka";
		notesContent[2] = "blah blah blah";
		final FlexTable flexTable = new FlexTable();
		for (int i = 0; i < 3; i++) {
			   if (notesContent[i] != null) {
				   flexTable.setHTML(i, 0, "" + (i + 1));
				   flexTable.setHTML(i, 1, notesContent[i]);
		   }
		}
		
			   
		
				
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.add(b1);
		verticalPanel.add(flexTable);
		
		
    	
    	
    	
    	//final Label label1 = new Label("This is first GWT Label");
    	//verticalPanel.add(label1);
		
		RootPanel.get().add(verticalPanel);
		
		redButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				int i = 0;
				while (notesContent [i] != null) i++;
				notesContent [i] = textArea1.getText();
				flexTable.setHTML(i, 0, "" + (i + 1));
				flexTable.setHTML(i, 1, notesContent[i]);
				myPopup.hide();
			}
		});
	}
	
	
}

