package complextableview;

import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.ObservableList;

public class BookmarkTag {

    private final ObjectProperty<Bookmark> bookmark;
    private final ListProperty<Tag> tags;

    public BookmarkTag(Bookmark bm, ObservableList<Tag> tags ){
        this();
        setBookmark(bm);
        setTags(tags);
    }

    BookmarkTag() {
         bookmark = new SimpleObjectProperty<>(this, "bookmark", new Bookmark());
         tags = new SimpleListProperty<>(this, "tags", new SimpleListProperty<>());
    }
            
    public final ObservableList getTags() {
        return tags.get();
    }

    public final void setTags(ObservableList value) {
        tags.set(value);
    }
    
    public void addTag(Tag value) {
        tags.add(value);
    }

    public ListProperty tagsProperty() {
        return tags;
    }
    
    public final Bookmark getBookmark() {
        return bookmark.get();
    }

    public final void setBookmark(Bookmark value) {
        bookmark.set(value);
    }

    public ObjectProperty bookmarkProperty() {
        return bookmark;
    }
    
}
