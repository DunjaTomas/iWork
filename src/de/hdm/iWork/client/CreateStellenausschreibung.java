package de.hdm.iWork.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import com.google.gwt.view.client.ListDataProvider;

import de.hdm.iWork.shared.bo.Benutzer;
import de.hdm.iWork.shared.bo.Eigenschaft;
import de.hdm.iWork.shared.bo.Stellenausschreibung;

/**
 * Diese Klasse dient dazu, eine Stellenausschreibung anzulegen.
 */
public class CreateStellenausschreibung extends VerticalPanel {

	private Stellenausschreibung stelle = null;
	private int stellenid = 0;

	/**
	 * Panels erzeugen.
	 */
	private VerticalPanel verPanel = new VerticalPanel();
	private HorizontalPanel horPanel = new HorizontalPanel();

	private Button addButton = new Button("AddValue");

	private Label ueberschrift = new Label("Stellenbeschreibung anlegen");
	private TextBox valueBoxBezeichnung = new TextBox();
	private TextBox valueBoxBeschreibung = new TextBox();
	private TextBox valueBoxFrist = new TextBox();
	private FlexTable showStellenausschreibungFlexTable = new FlexTable();

	List<String> list = new ArrayList<String>();
	private List<Stellenausschreibung> listS = new ArrayList<Stellenausschreibung>();

	private CellTable<Stellenausschreibung> celltable = new CellTable<Stellenausschreibung>();
	private ListDataProvider<Stellenausschreibung> dataProvider = new ListDataProvider<Stellenausschreibung>();
	private TextInputCell inputcell = new TextInputCell();

	private Button createStellenausschreibungButton = new Button("Stellenausschreibung anlegen");

	public CreateStellenausschreibung() {
		System.out.println("CreateStellenausschreibung Klasse Create betreten");
		// this.stellenid = 0;
		run();
	}

	public void run() {
		System.out.println("RUN BETRETEN");
		this.add(verPanel);
		 this.add(horPanel);

		 TextColumn<Stellenausschreibung> beschreibungColumn = new
		 TextColumn<Stellenausschreibung>() {
		
		 @Override
		 public String getValue(Stellenausschreibung ausschreibung) {
		 celltable.setEmptyTableWidget(valueBoxBeschreibung);
		 return ausschreibung.getBezeichnung();
		 }
		 };
		
		 celltable.addColumn(beschreibungColumn, "Bezeichnung");
		 celltable.addColumn(beschreibungColumn, "Ausschreibungstext");
		 celltable.addColumn(beschreibungColumn, "Frist");
		
		 celltable.setEmptyTableWidget(valueBoxBezeichnung);
		
		 dataProvider.addDataDisplay(celltable);

		// NEUE TABELLE FLEX
		// -----------------------------------------------------------------
		FlexTable createStellenausschreibungFlexTable = new FlexTable();

		createStellenausschreibungFlexTable.setText(0, 0, "Bezeichnung");
		createStellenausschreibungFlexTable.setText(1, 0, "Ausschreibungstext");
		// createStellenausschreibungFlexTable.setText(2, 0, "Frist");

		createStellenausschreibungFlexTable.setWidget(0, 2, valueBoxBezeichnung);
		createStellenausschreibungFlexTable.setWidget(1, 2, valueBoxBeschreibung);
		// createStellenausschreibungFlexTable.setWidget(2, 2, valueBoxFrist);

		createStellenausschreibungButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				createStellenausschreibung();
			}
		});

		showStellenausschreibungFlexTable.setText(0, 0, "Bezeichnung");
		showStellenausschreibungFlexTable.setText(1, 0, "Ausschreibungstext");
		 showStellenausschreibungFlexTable.setText(2, 0, "Frist");

//		showStellenausschreibung();

		horPanel.add(createStellenausschreibungButton);

		verPanel.add(ueberschrift);
		// verPanel.add(celltable);
		// verPanel.add(valueBoxBeschreibung);
		// verPanel.add(valueBoxBezeichnung);
		// verPanel.add(valueBoxFrist);
		// horPanel.add(verPanel);
		verPanel.add(createStellenausschreibungFlexTable);
		verPanel.add(showStellenausschreibungFlexTable);
		verPanel.add(horPanel);

	}

	public void createStellenausschreibung() {
		Label testLabel = new Label("createStellenausschreibung betreten!");
		verPanel.add(testLabel);

		ClientsideSettings.getIWorkAdministration().createStellenausschreibung(stellenid,
				valueBoxBezeichnung.getText(), valueBoxBeschreibung.getText(),
				new AsyncCallback<Stellenausschreibung>() {

					@Override
					public void onFailure(Throwable caught) {
						Label failLabel = new Label("onFailure wurde betreten");
						verPanel.add(failLabel);
					}

					@Override
					public void onSuccess(Stellenausschreibung result) {
						Label successLabel = new Label("onSuccess wurde betreten");
						verPanel.add(successLabel);
					}

				});

	}

	public void showStellenausschreibung() {
		Label testLabel = new Label("showStellenausschreibung betreten!");
		verPanel.add(testLabel);

		ClientsideSettings.getIWorkAdministration().getStellenanzeige(stellenid,
				new AsyncCallback<Stellenausschreibung>() {

					public void onFailure(Throwable caught) {
						Label failLabel = new Label("onFailure wurde betreten");
						verPanel.add(failLabel);
					}

					public void onSuccess(Stellenausschreibung result) {
						Label successLabel = new Label("onSuccess wurde betreten");
						verPanel.add(successLabel);

//						showStellenausschreibungFlexTable.setText(0, 1, result.getBezeichnung());
//						showStellenausschreibungFlexTable.setText(1, 1, result.getBeschreibungstext());

					}
				});
	}

}
