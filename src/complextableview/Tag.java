package complextableview;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tag {
    private final StringProperty theTag = new SimpleStringProperty();
    Tag(String value) { setTheTag(value);}
    public String getTheTag() {return theTag.get();}
    public void setTheTag(String value) {theTag.set(value);}
    public StringProperty theTagProperty() {return theTag;}
}
