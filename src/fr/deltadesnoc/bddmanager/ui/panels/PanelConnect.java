package fr.deltadesnoc.bddmanager.ui.panels;

import fr.deltadesnoc.bddmanager.Manager;
import fr.deltadesnoc.bddmanager.ui.PanelManager;
import fr.deltadesnoc.bddmanager.ui.panel.Panel;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class PanelConnect extends Panel {
	
	
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
        
        
        TextField url = new TextField();
        url.setPromptText("URL");
        GridPane.setHgrow(url, Priority.ALWAYS);
        GridPane.setVgrow(url, Priority.ALWAYS);
        GridPane.setHalignment(url, HPos.CENTER);
        GridPane.setValignment(url, VPos.CENTER);
        url.setMinSize(300, 50);
        url.setMaxSize(300, 50);
        url.setTranslateX(-250);
        url.setTranslateY(-50);
        url.setFocusTraversable(false);
        
        TextField username = new TextField();
        username.setPromptText("Nom d'utilisateur");
        GridPane.setHgrow(username, Priority.ALWAYS);
        GridPane.setVgrow(username, Priority.ALWAYS);
        GridPane.setHalignment(username, HPos.CENTER);
        GridPane.setValignment(username, VPos.CENTER);
        username.setMinSize(300, 50);
        username.setMaxSize(300, 50);
        username.setTranslateX(-250);
        username.setTranslateY(50);
        username.setFocusTraversable(false);
        
        TextField dbName = new TextField();
        dbName.setPromptText("DB Name");
        GridPane.setHgrow(dbName, Priority.ALWAYS);
        GridPane.setVgrow(dbName, Priority.ALWAYS);
        GridPane.setHalignment(dbName, HPos.CENTER);
        GridPane.setValignment(dbName, VPos.CENTER);
        dbName.setMinSize(300, 50);
        dbName.setMaxSize(300, 50);
        dbName.setTranslateX(250);
        dbName.setTranslateY(-50);
        dbName.setFocusTraversable(false);
        
        PasswordField password = new PasswordField();
        password.setPromptText("Password");
        GridPane.setHgrow(password, Priority.ALWAYS);
        GridPane.setVgrow(password, Priority.ALWAYS);
        GridPane.setHalignment(password, HPos.CENTER);
        GridPane.setValignment(password, VPos.CENTER);
        password.setMinSize(300, 50);
        password.setMaxSize(300, 50);
        password.setTranslateX(250);
        password.setTranslateY(50);
        password.setFocusTraversable(false);
        
        Button connectButton = new Button("Connexion");
        GridPane.setHgrow(connectButton, Priority.ALWAYS);
        GridPane.setVgrow(connectButton, Priority.ALWAYS);
        GridPane.setHalignment(connectButton, HPos.CENTER);
        GridPane.setValignment(connectButton, VPos.BOTTOM);
        connectButton.setMinSize(400, 50);
        connectButton.setMaxSize(400, 50);
        connectButton.setTranslateY(-100);
        connectButton.setFocusTraversable(false);
        connectButton.setOnMouseClicked(e -> {
        	if(url.getText() != null && (!url.getText().trim().isEmpty()) 
        			&& dbName.getText() != null && (!dbName.getText().trim().isEmpty()) 
        			&& username.getText() != null && (!username.getText().trim().isEmpty())){
        		if(panelManager.getDataBase().connect(url.getText(), dbName.getText(), username.getText(), password.getText())){
            		panelManager.showPanel(new HomePanel());
            	}
        	}else{
        		Manager.getLogger().warn("Un des champs requis est vide !");
        	}
        });
        
        
        connectPane.getChildren().addAll(url, dbName, username, password, connectButton);
        this.layout.getChildren().add(connectPane);
	}

}
