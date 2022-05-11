package fr.deltadesnoc.bddmanager.ui.panel;

import fr.deltadesnoc.bddmanager.ui.PanelManager;
import javafx.scene.layout.GridPane;

public interface IPanel {
	
	void init(PanelManager panelManager);
    GridPane getLayout();
    void onShow();

}
