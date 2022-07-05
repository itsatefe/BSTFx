package ir.ac.kntu;

import ir.ac.kntu.BST.BST;
import ir.ac.kntu.BST.Node;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NodeController.class.getResource("Node.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}


/*public class HelloApplication {
    public static void main(String[] args) {
        BST bst = new BST(new Node(50));
        //bst.insert(50);
        bst.insert(27);
        bst.insert(12);
        bst.insert(37);
        bst.insert(30);
        bst.insert(40);



        bst.inOrder(bst.getRoot());

        bst.search(12);
        //launch();
    }
}*/
