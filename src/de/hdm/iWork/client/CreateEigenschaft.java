package de.hdm.iWork.client;

import java.util.List;
import java.util.Vector;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.view.client.ListDataProvider;

import de.hdm.iWork.shared.bo.Eigenschaft;


public class CreateEigenschaft extends VerticalPanel {
	
	private VerticalPanel verPanel = new VerticalPanel();
	private HorizontalPanel horPanel = new HorizontalPanel();
	
	private Label ueberschrift = new Label("Profil anlegen");
	
	private RadioButton sucheButton = new RadioButton("Ich suche einen Job");
	private RadioButton anbietenButton = new RadioButton("Ich biete einen Job an");
	private Button speichernButton = new Button("Speichern");
	private Button abbrechenButton = new Button("Abbrechen");
	
	private CellTable<Eigenschaft> table = new CellTable<Eigenschaft>();
	// Create a data provider.
    ListDataProvider<Eigenschaft> dataProvider = new ListDataProvider<Eigenschaft>();
	
	
	
	
	public CreateEigenschaft(){
		run();
	}
	
	public void run(){
		
		this.add(verPanel);
		this.add(horPanel);
		
		TextColumn<Eigenschaft> bezeichnungColumn = new TextColumn<Eigenschaft>(){
			
			@Override
			public String getValue(Eigenschaft eigenschaft) {
				return eigenschaft.getBezeichnung();
			}
			
		};
		
		table.addColumn(bezeichnungColumn, "Bezeichnung");
		
		
	    
	 // Connect the table to the data provider.
	    dataProvider.addDataDisplay(table);
	    
	    getBezeichnung();
	    
	    verPanel.add(ueberschrift);
	    verPanel.add(table);
	    horPanel.add(verPanel);
	    
	    RootPanel.get("Details").add(horPanel);
		
		
	}
	
	public void getBezeichnung(){
		
		ClientsideSettings.getIWorkAdministration().getAllEigenschaften(new AsyncCallback<Vector<Eigenschaft>>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Vector<Eigenschaft> result) {
				
				List<Eigenschaft> list = dataProvider.getList();
			    for (Eigenschaft eigenschaft : result) {
			      list.add(eigenschaft);
			    }
				
			}

		
			
			
		});
	}
	
	

}
