package de.hdm.iWork.client;

import com.google.gwt.user.client.ui.*;


/**
 * Superklasse für alle Klassen im Client, die das Anzeigen einer Seite realisieren
 * @author Carolin
 *
 */
public abstract class ShowSuper extends VerticalPanel {
	
	/**
	 * Methode die beim Aufrufen eines GWT-Widgets ausgeführt wird
	 */
	public void onLoad(){
		
		super.onLoad();
		
		this.add(this.createHeadline(this.getHeadlineText()));
		
		run();
	}
	
	/**
	 * Erzeugung einer Überschrift für die Seite
	 * @param headlineText
	 * @return
	 */
	protected HTML createHeadline(String headlineText) {
	    HTML content = new HTML(headlineText);
	    //content.setStylePrimaryName(""); für Styledefinition später ausfüllen
	    return content;
	}
	
	/**
	 * Hinzufügen von Text auf der Seite
	 * @param text
	 */
	protected void append(String text) {
		HTML content = new HTML(text);
		//content.setStylePrimaryName(""); für Styledefiniton
		this.add(content);
	}

	/**
	 * Wird in den Supklassen initialisiert
	 * @return
	 */
	protected abstract String getHeadlineText();
	
	/**
	 * Wird in den Supklassen initialisiert
	 * @return
	 */
	protected abstract void run();
	
}