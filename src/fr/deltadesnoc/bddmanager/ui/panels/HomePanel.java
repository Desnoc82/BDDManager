package fr.deltadesnoc.bddmanager.ui.panels;

import fr.deltadesnoc.bddmanager.ui.PanelManager;
import fr.deltadesnoc.bddmanager.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class HomePanel extends Panel {
	
	@Override
	public void init(PanelManager panelManager) {
		super.init(panelManager);
		
		GridPane connectPane = new GridPane();
		
		connectPane.setMaxWidth(1280);
		connectPane.setMinWidth(1280);
		connectPane.setMaxHeight(720);
		connectPane.setMinHeight(720);
		connectPane.setStyle("-fx-background-color: #3c3c3c;");
		
		GridPane.setHgrow(connectPane, Priority.ALWAYS);
        GridPane.setVgrow(connectPane, Priority.ALWAYS);
        GridPane.setHalignment(connectPane, HPos.CENTER);
        GridPane.setValignment(connectPane, VPos.CENTER);
        
        this.layout.getChildren().add(connectPane);
	}

}
