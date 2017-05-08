package de.hdm.iWork.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Navigator extends HorizontalPanel {
	
	VerticalPanel navPanel = new VerticalPanel();
	
	
	public Navigator(){
		
		run();
		
		
	}
	
public void run(){
	
	this.add(navPanel);
	
	Button profilAnzeigenButton = new  Button("Mein Profil");
	profilAnzeigenButton.setStylePrimaryName("iWork-menubutton");
	
	profilAnzeigenButton.addClickHandler(new ClickHandler (){

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			ShowSuper showsuper = new ShowProfil();
			RootPanel.get("Details").clear();
	        RootPanel.get("Details").add(showsuper);
		}
			
	});
	
	Button stellenbeschreibungenAnzeigenButton = new Button("Jobs");
	stellenbeschreibungenAnzeigenButton.setStylePrimaryName("iWork-menubutton");
	
	stellenbeschreibungenAnzeigenButton.addClickHandler(new ClickHandler(){

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	});
	
	Button bewerbungenAnzeigenButton = new Button("Meine Bewerbungen");
	bewerbungenAnzeigenButton.setStylePrimaryName("iWork-menubutton");
	
	bewerbungenAnzeigenButton.addClickHandler(new ClickHandler(){

		@Override
		public void onClick(ClickEvent event) {
			// TODO Auto-generated method stub
			
		}
		
	});
	
	navPanel.add(profilAnzeigenButton);
	navPanel.add(stellenbeschreibungenAnzeigenButton);
	navPanel.add(bewerbungenAnzeigenButton);
	
	
	
}



}
