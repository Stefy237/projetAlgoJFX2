package application;

import java.net.URL;
import java.util.ResourceBundle;

import backend.ArbreBin;
import backend.CreateArbreBin;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class MainController implements Initializable{

	@FXML
	private Label prefixeResult;
	
	@FXML
	private Label infixeResult;

	
	@FXML
	private Label postfixeResult;
	
	@FXML
    private Pane treePane;
	
	private ArbreBin arbre;
    private int nodeRadius = 20;
    private int nodeGap = 35;
    
	private CreateArbreBin A = new CreateArbreBin();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		arbre = A.getArbreBin();
		
	    treePane.layoutBoundsProperty().addListener((observable, oldBounds, newBounds) -> {
	        drawTree(arbre);
	    });
	}
	
	private void drawTree(ArbreBin arbre) {
	    if (arbre == null) {
	        return;
	    }
	    drawNode(arbre, treePane.getWidth() / 2, nodeGap, treePane.getWidth() / 4);
	}
	
	private void drawNode(ArbreBin arbre, double x, double y, double hGap) {
	    if (arbre == null) {
	        return;
	    }

	    // Crée un cercle pour représenter le nœud
	    Circle nodeCircle = new Circle(x, y, nodeRadius);
	    nodeCircle.setFill(Color.RED);
	    nodeCircle.setStroke(Color.BLACK);
	    treePane.getChildren().add(nodeCircle);

	    // Crée un texte pour afficher la valeur du nœud
	    Text nodeText = new Text(String.valueOf(arbre.getRoot()));
	    nodeText.setFont(Font.font("Arial", FontWeight.BOLD, 20));
	    nodeText.setFill(Color.WHITE);
	    nodeText.setX(x - nodeRadius / 2);
	    nodeText.setY(y + nodeRadius / 2);
	    
	    treePane.getChildren().add(nodeText);

	    // Calcule les positions des nœuds fils et crée les liens entre les nœuds
	    double leftX = x - hGap;
	    double leftY = y + 2*nodeGap;
	    double rightX = x + hGap;
	    double rightY = y + 2*nodeGap;
	    
	    drawNode(arbre.getLeftChild(), leftX, leftY, hGap / 2);
	    drawNode(arbre.getRightChild(), rightX, rightY, hGap / 2);
	    
	    if (arbre.getLeftChild() != null) {
	        Line leftLine = new Line(x- nodeRadius, y, leftX, leftY - nodeRadius);
	        treePane.getChildren().add(leftLine);
	    }
	    if (arbre.getRightChild() != null) {
	        Line rightLine = new Line(x+ nodeRadius, y, rightX, rightY - nodeRadius);
	        treePane.getChildren().add(rightLine);
	    }
	}
	        
	public void prefixe(ActionEvent e) {
		prefixeResult.setText(arbre.depthRoutePre());
	}
	
	public void infixe(ActionEvent e) {
		infixeResult.setText(arbre.depthRouteIn());
	}
	
	public void postfixe(ActionEvent e) {
		postfixeResult.setText(arbre.depthRoutePost());
	}
}

