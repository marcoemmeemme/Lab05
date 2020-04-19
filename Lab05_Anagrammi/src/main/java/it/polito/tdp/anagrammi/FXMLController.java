package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import it.polito.tdp.anagrammi.model.ParolaSbagliataException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnAnagrammi;

    @FXML
    private TextArea areaCorretti;

    @FXML
    private TextArea areaErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	areaCorretti.clear();
    	areaErrati.clear();
    	String parola=txtParola.getText();
    	try
    	{
    		this.model.checkParola(parola);
    		Set<String> anagrammi=this.model.anagrammi(parola);
    		for(String s: anagrammi)
    		{
    			if(this.model.isCorrect(s))
    				areaCorretti.appendText(s+"\n");
    			else
    				areaErrati.appendText(s+"\n");
    		}
    	}
    	catch (ParolaSbagliataException pse)
    	{
    		areaCorretti.setText("Errore! Inserisci solo lettere");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtParola.clear();
    	this.areaCorretti.clear();
    	this.areaErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert areaCorretti != null : "fx:id=\"areaCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert areaErrati != null : "fx:id=\"areaErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        model=new Model();
    }
    public void setModel(Model model)
    {
    	this.model=model;
    }
}
