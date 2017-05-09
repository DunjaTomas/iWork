package de.hdm.iWork.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class Navigator extends HorizontalPanel {

	VerticalPanel navPanel = new VerticalPanel();

	public Navigator() {

		run();

	}

	public void run() {

		this.add(navPanel);

		Button profilAnzeigenButton = new Button("Mein Profil");
		profilAnzeigenButton.setStylePrimaryName("iWork-menubutton");

		profilAnzeigenButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				ShowSuper showsuper = new ShowProfil();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(showsuper);
			}

		});

		Button stellenausschreibungenErstellenButton = new Button("Stellenausschreibung erstellen");
		stellenausschreibungenErstellenButton.setStylePrimaryName("iWork-menubutton");

		stellenausschreibungenErstellenButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				CreateStellenausschreibung stelle = new CreateStellenausschreibung();
				RootPanel.get("Details").clear();
				RootPanel.get("Details").add(stelle);
			}

		});

		Button stellenausschreibungenAnzeigenButton = new Button("Jobs");
		stellenausschreibungenAnzeigenButton.setStylePrimaryName("iWork-menubutton");

		stellenausschreibungenAnzeigenButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

			}

		});

		Button bewerbungenAnzeigenButton = new Button("Meine Bewerbungen");
		bewerbungenAnzeigenButton.setStylePrimaryName("iWork-menubutton");

		bewerbungenAnzeigenButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub

			}

		});

		navPanel.add(profilAnzeigenButton);
		navPanel.add(stellenausschreibungenErstellenButton);
		navPanel.add(stellenausschreibungenAnzeigenButton);
		navPanel.add(bewerbungenAnzeigenButton);

	}

}
