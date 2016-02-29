package complextableview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComplexTableView extends Application {

    @Override
    public void start(Stage primaryStage) {

        HashMap<Bookmark, List<Tag>> tagMap = new HashMap<>();
        ObservableList<BookmarkTag> bookmarkTags = FXCollections.observableArrayList();

        TableView<BookmarkTag> bookmarkTV = new TableView<>(bookmarkTags);

        TableColumn<BookmarkTag, String> bookmarkNameCol = new TableColumn<>("URL");
        TableColumn<BookmarkTag, String> bookmarkTagCol = new TableColumn<>("Tags");

        bookmarkNameCol.setCellValueFactory((CellDataFeatures<BookmarkTag, String> p)
                -> (ObservableValue<String>) p.getValue().getBookmark().nameProperty());
        bookmarkTagCol.setCellValueFactory(new PropertyValueFactory<BookmarkTag, String>("tagList"));

        bookmarkTV.getColumns().add(bookmarkNameCol);
        bookmarkTV.getColumns().add(bookmarkTagCol);

        // Populate data
        ArrayList<Tag> tmpTag = new ArrayList<>();
        tmpTag.add(new Tag("work"));
        tmpTag.add(new Tag("fun"));
        tagMap.put(new Bookmark("stackoverflow.com"), tmpTag);

        tmpTag = new ArrayList<>();
        tmpTag.add(new Tag("home"));
        tmpTag.add(new Tag("fun"));
        tagMap.put(new Bookmark("reddit.com"), tmpTag);

        for (Bookmark bm : tagMap.keySet()) {
            BookmarkTag bt = new BookmarkTag();
            bt.setBookmark(bm);
            bt.setTags(FXCollections.observableArrayList(tagMap.get(bm)));

            bookmarkTags.add(bt);
        }

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                ObservableList<Tag> tags = FXCollections.observableArrayList();
                tags.add(new Tag("foo"));
                tags.add(new Tag("bar"));

                bookmarkTags.get(0).setTags(tags);
                System.out.println(bookmarkTags + "." + bookmarkTags.get(0).getTagList());
                
                // better way to force table to redraw?
                bookmarkTV.getColumns().get(0).setVisible(false);
                bookmarkTV.getColumns().get(0).setVisible(true);

                // Add new bookmark
                ArrayList<Tag> tmpTag = new ArrayList<>();
                tmpTag.add(new Tag("new"));
                tmpTag.add(new Tag("fun"));

                Bookmark bm = new Bookmark("slashdot.com");

                BookmarkTag bt = new BookmarkTag();
                bt.setBookmark(bm);
                bt.setTags(FXCollections.observableArrayList(tmpTag));
                
                // this will also cause table to redraw
                //bookmarkTags.add(bt);

            }
        });

        VBox box = new VBox();
        box.getChildren().add(bookmarkTV);
        box.getChildren().add(btn);

        StackPane root = new StackPane();
        root.getChildren().add(box);
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("ComplexTableView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
