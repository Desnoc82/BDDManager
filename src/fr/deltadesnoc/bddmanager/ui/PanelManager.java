package fr.deltadesnoc.bddmanager.ui;

import fr.deltadesnoc.bddmanager.database.DataBase;
import fr.deltadesnoc.bddmanager.ui.panel.IPanel;
import fr.deltadesnoc.bddmanager.ui.panels.includes.TopPanel;
import fr.deltadesnoc.bddmanager.utils.ResizeHelper;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PanelManager {
	
	private final BDDLauncher launcher;
	private DataBase dataBase;
	private final Stage stage;
    private GridPane layout;
    private TopPanel topPanel = new TopPanel();
    private GridPane centerPanel = new GridPane();

    public PanelManager(BDDLauncher launcher, Stage stage) {
        this.launcher = launcher;
        this.stage = stage;
    }

    public void init(){
    	dataBase = new DataBase();
        this.stage.setTitle("BDD Manager");
        this.stage.setMinWidth(1280);
        this.stage.setWidth(1280);
        this.stage.setMinHeight(720);
        this.stage.setHeight(720);
        this.stage.initStyle(StageStyle.UNDECORATED);
        this.stage.centerOnScreen();
        this.stage.show();

        this.layout = new GridPane();
        this.stage.setScene(new Scene(this.layout));

        RowConstraints topPanelConstraints = new RowConstraints();
        topPanelConstraints.setValignment(VPos.TOP);
        topPanelConstraints.setMinHeight(25);
        topPanelConstraints.setMaxHeight(25);
        this.layout.getRowConstraints().addAll(topPanelConstraints, new RowConstraints());
        this.layout.add(this.topPanel.getLayout(), 0, 0);
        this.topPanel.init(this);

        this.layout.add(this.centerPanel, 0, 1);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);
        ResizeHelper.addResizeListener(this.stage);

    }

    public void showPanel(IPanel panel){
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(panel.getLayout());
        panel.init(this);
        panel.onShow();
    }


    public Stage getStage() { return stage; }
    public BDDLauncher getLauncher() { return launcher; }
    public DataBase getDataBase() { return dataBase; }
    public TopPanel getTopPanel() { return topPanel; }
}