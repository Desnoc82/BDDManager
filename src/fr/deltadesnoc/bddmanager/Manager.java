package fr.deltadesnoc.bddmanager;

import javax.swing.JOptionPane;

import fr.deltadesnoc.bddmanager.utils.Logger;
import javafx.application.Application;

public class Manager {
	
	private static Logger logger;

	public static void main(String[] args) {
		
		logger = new Logger("BDDManager");

		try {
            Class.forName("javafx.application.Application");
            Application.launch(FxApplication.class, args);
        }catch (ClassNotFoundException e){
            logger.warn("JavaFx not found :cry:");
            JOptionPane.showMessageDialog(null, "Une erreur avec Java à été détectée.\n" + e.getMessage() + "\nNot Found", "Erreur Java", JOptionPane.ERROR_MESSAGE);
        }
		
	}

}
