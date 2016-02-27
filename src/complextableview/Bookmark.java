package complextableview;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Bookmark {
    private final StringProperty name;
    private final IntegerProperty id;

    public Bookmark() {
        id = new SimpleIntegerProperty(this, "id", 0);
        name = new SimpleStringProperty(this, "name", "");
    }

    public Bookmark(Integer id, String name) {
        this();
        setId(id);
        setName(name);
    }

    public final Integer getId() {return id.get();}
    public final void setId(Integer value) {id.set(value);}
    public IntegerProperty getIdProperty() {return id;}
    public final String getName() {return name.get();}
    public final void setName(String value) {name.set(value);}
    public StringProperty getNameProperty() {return name;}
}