package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {
    @FXML
    TableView<StudentRecord> idTable;
    @FXML
    TableColumn<StudentRecord, String> idStudentID;
    @FXML
    TableColumn<StudentRecord, Float> idAssignments;
    @FXML
    TableColumn<StudentRecord, Float> idMidterm;
    @FXML
    TableColumn<StudentRecord, Float> idFinalExam;
    @FXML
    TableColumn<StudentRecord, Float> idFinalMark;
    @FXML
    TableColumn<StudentRecord, Character> idLetterGrade;

    public void initialize(){
        idStudentID.setCellValueFactory(new PropertyValueFactory<StudentRecord, String>("StudentID"));
        idAssignments.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("Assignments"));
        idMidterm.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("Midterm"));
        idFinalExam.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("FinalExam"));
        idFinalMark.setCellValueFactory(new PropertyValueFactory<StudentRecord, Float>("FinalMark"));
        idLetterGrade.setCellValueFactory(new PropertyValueFactory<StudentRecord, Character>("LetterGrade"));
        idTable.setItems(DataSource.getAllMarks());
    }
}
