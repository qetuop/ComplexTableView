package complextableview;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Tag {

    public final StringProperty string;
    public final IntegerProperty id;

    public Tag() {
        id = new SimpleIntegerProperty(this, "id", 0);
        string = new SimpleStringProperty(this, "string", "");
    }
    public Tag(Integer id, String string) {
        this();
        setId(id);
        setString(string);
    }

    Tag(Tag get) {
        this();
        setId(get.getId());
        setString(get.getString());
    }

    public final Integer getId() {return id.get();}
    public final void setId(Integer value) {id.set(value);}
    public IntegerProperty idProperty() {return id;}
    public final String getString() {return string.get();}
    public final void setString(String value) {string.set(value);}
    public StringProperty stringProperty() {return string;}
}
