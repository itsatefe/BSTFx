package ir.ac.kntu;

import ir.ac.kntu.BST.BST;
import ir.ac.kntu.BST.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

import static ir.ac.kntu.BSTController.GoToBst;

public class NodeController {
    @FXML
    private Pane pane;
    @FXML
    private TextField node;
    @FXML
    private Button addBtn;
    @FXML
    private Button createBtn;
    @FXML
    private Label success;
    @FXML
    private Label error;

    BST bst;
    LinkedList<Node> nodes = new LinkedList<>();


    @FXML
    public void AddNode(ActionEvent actionEvent) {
        int data = Integer.parseInt(node.getText());
        Node newNode = new Node(data);
        boolean isAdd = nodes.add(newNode);
        if (isAdd){
            node.clear();
            success.setVisible(true);
            Timer timer = new Timer();
            TimerTask task = new TimerTask()
            {
                public void run()
                {
                    success.setVisible(false);

                }
            };
            timer.schedule(task, 1000);
        }else {
            error.setVisible(true);
            Timer timer = new Timer();
            TimerTask task = new TimerTask()
            {
                public void run()
                {
                    error.setVisible(false);
                }
            };
            timer.schedule(task, 1000);
        }
    }

    @FXML
    public void Create(ActionEvent actionEvent) {
        node.setVisible(false);
        addBtn.setVisible(false);
        createBtn.setVisible(false);
        success.setVisible(false);
        error.setVisible(false);
        bst = new BST(nodes.get(0));
        for (Node node:nodes.subList(1,nodes.size())) {
            bst.insert(node.getData());
        }
       GoToBst(bst,createBtn);
    }
}
