package complextableview;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class TagMap {

    public final IntegerProperty id;
    public final IntegerProperty bookmarkId;
    public final IntegerProperty tagId;

    public TagMap(){
        id = new SimpleIntegerProperty(this, "id", 0);
        bookmarkId = new SimpleIntegerProperty(this, "bookmarkId", 0);
        tagId = new SimpleIntegerProperty(this, "tagId", 0);
    }
    
    public TagMap(Integer id, Integer bmId, Integer tagId) {
        this();
        
        setId(id);
        setBookmarkId(bmId);
        setTagId(tagId);
    }

    public final Integer getId() {return id.get();}
    public final void setId(Integer value) {id.set(value);}
    public IntegerProperty idProperty() {return id;}
    public final Integer getTagId() {return tagId.get();}
    public final void setTagId(Integer value) {tagId.set(value);}
    public IntegerProperty tagIdProperty() {return tagId;}
    public final Integer getBookmarkId() {return bookmarkId.get();}
    public final void setBookmarkId(Integer value) {bookmarkId.set(value);}
    public IntegerProperty bookmarkIdProperty() {return bookmarkId;}
}