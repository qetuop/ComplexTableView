package complextableview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ComplexTableView extends Application {

    @Override
    public void start(Stage primaryStage) {

        ObservableList<Bookmark> bookmarks = FXCollections.observableArrayList();
        ObservableList<Tag> tags = FXCollections.observableArrayList();
        ObservableList<TagMap> tagMapList = FXCollections.observableArrayList();

        TableView<Bookmark> bookmarkTV = new TableView<>(bookmarks);        
        TableColumn<Bookmark, String> bookmarkNameCol = new TableColumn<>("URL");        
        // What to put here?
        //TableColumn<?, String> bookmarkTagCol = new TableColumn<>("Tags");

        bookmarkNameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));        
        // What to put here?
        //bookmarkTagCol.setCellValueFactory(new PropertyValueFactory<>("?"));

        bookmarkTV.getColumns().add(bookmarkNameCol);
        //bookmarkTV.getColumns().add(bookmarkTagCol);

        // Populate data
        bookmarks.add(new Bookmark(0, "stackoverflow.com"));
        bookmarks.add(new Bookmark(1, "reddit.com"));

        tags.add(new Tag(0, "work"));
        tags.add(new Tag(1, "home"));
        tags.add(new Tag(2, "fun"));

        tagMapList.add(new TagMap(0, 0, 0)); // 1st mapping = google & "work"
        tagMapList.add(new TagMap(1, 1, 1)); // 2nd mapping = reddit & "home"
        tagMapList.add(new TagMap(2, 1, 2)); // 3rd mapping = reddit & "fun"
        
        // Table Output
        // URL               Tags
        // stackoverflow.com  'work'
        // reddit.com         'home,fun'
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for ( TagMap tagMapping : tagMapList ){
            if ( tagMapping.getBookmarkId() == 1)
                sb1.append(tags.get(tagMapping.getTagId()).getString());            
            else
                sb2.append(tags.get(tagMapping.getTagId()).getString());            
        }
        
        System.out.println(sb1.toString());
        System.out.println(sb2.toString());

        StackPane root = new StackPane();
        root.getChildren().add(bookmarkTV);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("ComplexTableView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}