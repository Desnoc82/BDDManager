package fr.deltadesnoc.bddmanager.ui;

import fr.deltadesnoc.bddmanager.ui.panels.PanelConnect;
import javafx.stage.Stage;

public class BDDLauncher {
	
	private PanelManager panelManager;
	
	public void init(Stage stage){
		this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();
        this.panelManager.showPanel(new PanelConnect());
	}

}