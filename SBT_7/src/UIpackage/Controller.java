package UIpackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sbt4package.*;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private Squad squadTeam1 = new Squad("Team_1");
    private Squad squadTeam2 = new Squad("Team_2");
    private ObservableList<String> listWarrior = FXCollections.observableArrayList("Viking", "BarbarianJulia");
    private ObservableList<String> listSquad = FXCollections.observableArrayList("Team_1", "Team_2");
    Integer nameI = 1;//при создании нового бойца присваиваю ему номер заместо имени, для этого нужен метод toString
    // имя лучше не стало. и почему package local?

    @FXML
    private ComboBox<String> comboBoxWarrior;

    @FXML
    private ComboBox<String> comboBoxSquad;

    @FXML
    TextArea battleField;

    @FXML
    TextField field; //неинформативное имя

    @FXML
    private void buttonAddWarrior(ActionEvent event) {
        Warrior wr = null;
        battleField.clear();
        String nameWarrior = comboBoxWarrior.getValue();
        String nameSquad = comboBoxSquad.getValue();

        if (nameWarrior == null | nameSquad == null) {
            battleField.setText("Выберите отряд/тип бойца!");
            return;
        } else if (nameWarrior.equals("Viking")) {
            wr = new Viking(nameI.toString()); //тут был комментарий, что у вас после создания бойца его команда не меняется, несмотря на значение поля field. ничего не изменилось.
        } else if (nameWarrior.equals("BarbarianJulia")) {
            wr = new BarbarianJulia(nameI.toString()); //по-прежнему может остаться null...
        }
        nameI++;
        if (nameSquad.equals("Team_1") & wr != null) {
            addWarrior(squadTeam1, wr);
        } else if (nameSquad.equals("Team_2") & wr != null) { //что за мания писать else if? разве тут возможен третий вариант? нет - если отряд не первый, то точно второй.
            addWarrior(squadTeam2, wr); //все равно копипаста, хоть теперь и из 1 строки
        }
/*      вот что я хотел увидеть:
        Squad squadToAdd = squadTeam1;
        if(nameSquad.equals("Team_2")) {
            squadToAdd = squadTeam2;
        }
        addWarrior(squadToAdd, wr);
*/
    }

    public void addWarrior(Squad squad, Warrior wr) {
        if (!field.getText().equals("")) {
            squad.setNameSquad(field.getText());
            field.clear();
        }
        squad.addMassWarrior(wr);
        battleField.setText("\n" + wr.toString());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxWarrior.setItems(listWarrior);
        comboBoxSquad.setItems(listSquad);
    }

    public void buttonGO(ActionEvent event) {
        battleField.setText(String.valueOf(Battle.methodBattle(squadTeam1, squadTeam2)));
    }

}
