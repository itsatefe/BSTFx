package ir.ac.kntu;

import ir.ac.kntu.BST.BST;
import ir.ac.kntu.BST.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;

public class BSTController {
    @FXML
    public Label heightVal;
    @FXML
    public Label inOrder;
    @FXML
    private Pane pane;
    private BST bst;
    private double x;
    private double y;
    private LinkedList<Location> locs = new LinkedList<>();

    public static void GoToBst(BST bst, Control object){

        try {
            Stage currentStage = (Stage) object.getScene().getWindow();
            currentStage.close();
            FXMLLoader loader = new FXMLLoader(BSTController.class.getResource("BST.fxml"));
            Parent root = loader.load();
            BSTController ac = loader.getController();
            ac.setBst(bst);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("نمایش درخت");
            stage.show();
        }catch (IOException exception){
            System.out.println(exception);
        }
    }

    private void setBst(BST bst) {
        this.bst = bst;
        var inOrder = bst.getInOrder();
        this.inOrder.setText(inOrder.substring(1));
        var height = bst.getHeight();
        this.heightVal.setText(String.valueOf(height));
        y = this.inOrder.getLayoutY() + this.inOrder.getPrefHeight() + 60;
        x = this.pane.getPrefWidth() / 2;
        Location RootLoc = new Location(x,y);
        drawNode(bst.getRoot().getData(),RootLoc,new Line(0,0,0,0));
        makeBst(bst.getRoot(),x,y);
    }


    private void drawNode(int data, Location loc,Line line) {
        Group group = new Group();
        Circle circle = new Circle(15);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        int i = 0;
        while (i < locs.size()){
            double tx = locs.get(i).getX();
            if (tx == loc.getX()){
                double ty = locs.get(i).getY();
                if (ty == loc.getY()){
                    line.setEndX(loc.getX() + 30);
                    loc.setX(loc.getX() + 30);
                }
            }
            i++;
        }
        locs.add(loc);
        circle.setCenterX(loc.getX());
        circle.setCenterY(loc.getY());
        Label label = new Label(String.valueOf(data));
        label.setLayoutX(circle.getCenterX() + 3 * label.getPrefWidth());
        label.setLayoutY(circle.getCenterY() + 3 * label.getPrefWidth());
        group.getChildren().add(circle);
        pane.getChildren().add(group);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(line);
        pane.getChildren().add(circle);
        pane.getChildren().add(label);


    }

    private void makeBst(Node root,double x,double y) {
        if (root == null)
            return;
        double t1x = x - 60;
        double t1y = y + 30;
        Location leftLoc  = new Location(t1x,t1y);
        makeBst(root.getLeft(),t1x,t1y);
        Node left = root.getLeft();
        if (left != null) {
            Line leftEdge = new Line(x,y, t1x,t1y);
            drawNode(left.getData(),leftLoc,leftEdge);
        }
        double t2x = t1x + 120;
        double t2y = y + 30;
        Location rightLoc  = new Location(t2x,t2y);
        makeBst(root.getRight(),t2x,t2y);
        Node right = root.getRight();
        if (right != null){
            Line rightEdge = new Line(x,y, t2x,t2y);
            drawNode(right.getData(),rightLoc,rightEdge);

        }

    }


    @FXML
    public void Search(ActionEvent actionEvent) {
    }
}
