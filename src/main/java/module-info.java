module cardshop.finalprojectcardshop {
    requires javafx.controls;
    requires javafx.fxml;


    opens cardshop.finalprojectcardshop to javafx.fxml;
    exports cardshop.finalprojectcardshop;
}