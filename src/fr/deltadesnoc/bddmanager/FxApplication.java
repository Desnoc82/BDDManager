package fr.deltadesnoc.bddmanager;

import fr.deltadesnoc.bddmanager.ui.BDDLauncher;
import javafx.application.Application;
import javafx.stage.Stage;

public class FxApplication extends Application{

	@Override
	public void start(Stage stage) throws Exception {
		new BDDLauncher().init(stage);
	}

}
