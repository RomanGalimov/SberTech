package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sbt4package.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    Squad squadTeam1 = new Squad("Barbarian team");
    Squad squadTeam2 = new Squad("Julia team");
    ObservableList<String> listWarrior = FXCollections.observableArrayList("Viking", "BarbarianJulia");
    ObservableList<String> listSquad = FXCollections.observableArrayList("Team_1", "Team_2");
    Integer i = 0;

    @FXML
    private ComboBox<String> comboBoxWarrior;

    @FXML
    private ComboBox<String> comboBoxSquad;

    @FXML
    TextArea battleField;

    @FXML
    TextField field;

    @FXML
    private void buttonAction(ActionEvent event) {
        Warrior wr = null;
        battleField.clear();
        String nameWarrior = comboBoxWarrior.getValue().toString();
        String nameSquad = comboBoxSquad.getValue().toString();
        i++;
        if (nameWarrior.equals("Viking")) {
            wr = new Viking(i.toString(), comboBoxSquad.getValue().toString());
        } else if (nameWarrior.equals("BarbarianJulia")) {
            wr = new BarbarianJulia(i.toString(), comboBoxSquad.getValue().toString());
        }
        if (nameSquad.equals("Team_1") & wr != null) {
            if (!field.getText().equals("")) {
                squadTeam1.setNameSquad(field.getText());
                field.clear();
            }
            squadTeam1.getMassWarior().add(wr);
            battleField.setText("\n" + squadTeam1.getMassWarior().toString());
        } else if (nameSquad.equals("Team_2") & wr != null) {
            if (!field.getText().equals("")) {
                squadTeam2.setNameSquad(field.getText());
                field.clear();
            }
            squadTeam2.getMassWarior().add(wr);
            battleField.setText("\n" + squadTeam2.getMassWarior().toString());
        }


        // battleField.setText("\n"+squadTeam1.getMassWarior().toString());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxWarrior.setItems(listWarrior);
        comboBoxSquad.setItems(listSquad);
    }

    public void buttonGO(ActionEvent event) {
        battleField.setText(String.valueOf(Battle.battleInterface.methodBattle(squadTeam1, squadTeam2)));
    }

}
