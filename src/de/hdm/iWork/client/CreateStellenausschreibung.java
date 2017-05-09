package de.hdm.iWork.client;

import java.util.List;
import java.util.Vector;

import com.google.gwt.cell.client.TextInputCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
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

	/**
	 * Panels erzeugen.
	 */
	private VerticalPanel verPanel = new VerticalPanel();
	private HorizontalPanel horPanel = new HorizontalPanel();

	private Button addButton = new Button("AddValue");

	private Label ueberschrift = new Label("Stellenbeschreibung anlegen");
	TextBox valueBox = new TextBox();

	private CellTable<Stellenausschreibung> celltable = new CellTable<Stellenausschreibung>();
	ListDataProvider<Stellenausschreibung> dataProvider = new ListDataProvider<Stellenausschreibung>();
	TextInputCell inputcell = new TextInputCell();

	public CreateStellenausschreibung() {
		run();
	}

	public void run() {
		this.add(verPanel);
		this.add(horPanel);

		TextColumn<Stellenausschreibung> stellenausschreibungColumn = new TextColumn<Stellenausschreibung>() {

			@Override
			public String getValue(Stellenausschreibung ausschreibung) {
				return ausschreibung.getBezeichnung();
			}
		};

		celltable.addColumn(stellenausschreibungColumn, "Bezeichnung");
		celltable.addColumn(stellenausschreibungColumn, "Ausschreibungstext");
		celltable.addColumn(stellenausschreibungColumn, "Frist");

		dataProvider.addDataDisplay(celltable);

		
		createStellenausschreibung();

		verPanel.add(ueberschrift);
		verPanel.add(celltable);
		verPanel.add(valueBox);
		horPanel.add(verPanel);

	}

	public void createStellenausschreibung() {

	}

}
