package complextableview;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bookmark {
    private final StringProperty name = new SimpleStringProperty();
    Bookmark(String value) {setName(value);}
    public String getName() {return name.get();}
    public void setName(String value) {name.set(value);}
    public StringProperty nameProperty() {return name;}
}