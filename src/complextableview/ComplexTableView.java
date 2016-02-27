package complextableview;

import java.util.List;
import java.util.stream.Collectors;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ComplexTableView extends Application {

    @Override
    public void start(Stage primaryStage) {

        ObservableList<Bookmark> bookmarks = FXCollections.observableArrayList();
        ObservableList<Tag> tags = FXCollections.observableArrayList();
        ObservableList<TagMap> tagMapList = FXCollections.observableArrayList();
        ObservableList<BookmarkTag> bookmarkTags = FXCollections.observableArrayList();

        TableView<BookmarkTag> bookmarkTV = new TableView<>(bookmarkTags);
        TableColumn<BookmarkTag, Bookmark> bookmarkNameCol = new TableColumn<>("URL");
        //TableColumn<BookmarkTag, Object> bookmarkTagCol = new TableColumn<>("Tags");

        //bookmarkNameCol.setCellValueFactory(new PropertyValueFactory<>("bookmark"));
        //bookmarkTagCol.setCellValueFactory(new PropertyValueFactory<>("tags"));
//        firstNameCol.setCellValueFactory(new Callback<CellDataFeatures<Person, String>, ObservableValue<String>>() {
//            public ObservableValue<String> call(CellDataFeatures<Person, String> p) {
//                // p.getValue() returns the TreeItem<Person> instance for a particular TreeTableView row,
//                // p.getValue().getValue() returns the Person instance inside the TreeItem<Person>
//                return p.getValue().getValue().firstNameProperty();
//            }
//        });
//    }
        bookmarkNameCol.setCellValueFactory(new Callback<CellDataFeatures<BookmarkTag, Bookmark>, ObservableValue<Bookmark>>() {
            public ObservableValue<Bookmark> call(CellDataFeatures<BookmarkTag, Bookmark> p) {
                return (ObservableValue<Bookmark>) p.getValue().getBookmark();
            }

        });

//        bookmarkNameCol.setCellFactory(column -> {
//            return new TableCell<BookmarkTag, String>() {
//                @Override
//                protected void updateItem(String item, boolean empty) {
//                    super.updateItem(item, empty);
//
//                    if (item == null || empty) {
//                        System.out.println("whaa");
//                        
//                    } else {
//                        System.out.println("huh");
//                        
//                    }
//                }
//            };
//        });
        bookmarkTV.getColumns().add(bookmarkNameCol);
        //bookmarkTV.getColumns().add(bookmarkTagCol);

        // Populate data
//        Bookmark bm0 = (new Bookmark(0, "stackoverflow.com"));
//        Bookmark bm1 = (new Bookmark(1, "reddit.com"));
//
//        Tag t0 = (new Tag(0, "work"));
//        Tag t1 = (new Tag(1, "home"));
//        Tag t2 = (new Tag(2, "fun"));
//        Tag t3 = (new Tag(3, "informative"));
        // Populate data
        bookmarks.add(new Bookmark(0, "stackoverflow.com"));
        bookmarks.add(new Bookmark(1, "reddit.com"));

        tags.add(new Tag(0, "work"));
        tags.add(new Tag(1, "home"));
        tags.add(new Tag(2, "fun"));


        tagMapList.add(new TagMap(0, 0, 0)); // 1st mapping = google & "work"
        tagMapList.add(new TagMap(1, 1, 1)); // 2nd mapping = reddit & "home"
        tagMapList.add(new TagMap(2, 1, 2)); // 3rd mapping = reddit & "fun"
        tagMapList.add(new TagMap(3, 0, 2)); // 4th mapping = google & "fun"


        // Table Output
        // URL                Tags
        // stackoverflow.com  'work,fun'
        // reddit.com         'home,fun'
        
        for (Bookmark bm : bookmarks) {
            BookmarkTag bt = new BookmarkTag();
            bt.setBookmark(bm);

            // create tagMapList of just the tags for this bookmark
            List<TagMap> tmpTagMap = tagMapList.stream()
                    .filter(p -> p.getTagId().compareTo(bm.getId()) == 0).collect(Collectors.toList());

            // crate a Tag object for each tag and add to BookmarkTag object's list
            for (TagMap tm : tmpTagMap) {
                int i = tm.getTagId();
                //Tag t = new Tag(tags.get(i));
                //bt.addTag(tags.get(tm.getTagId()));
                //bt.addTag(new Tag(1,"foo"));
            }

            bookmarkTags.add(bt);
        }

        StackPane root = new StackPane();

        root.getChildren().add(bookmarkTV);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle(
                "ComplexTableView");
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
