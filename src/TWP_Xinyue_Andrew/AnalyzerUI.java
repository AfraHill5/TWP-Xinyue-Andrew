package TWP_Xinyue_Andrew;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class AnalyzerUI extends Application{

	private TextField inputSearch = new TextField();
	private TextField inputUser = new TextField();
	private Button searchButton = new Button("Search");
	private Button userButton = new Button("User Search");
	public VBox searchViewOutput = new VBox();
	public VBox userViewOutput = new VBox();

	@Override
	public void start(Stage primaryStage) {

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);

		grid.setPadding(new Insets(25, 25, 25, 25));

		primaryStage.setTitle("Revision Information");
		Scene scene = new Scene(grid,400,300);
		scene.setFill(Color.LIGHTGRAY);

		Label topicSearchName = new Label("Search Topic：");
		grid.add(topicSearchName, 0, 1);
		inputSearch = new TextField();
		grid.add(inputSearch, 1, 1);

		HBox searchTopicHBox = new HBox(searchButton);
		searchTopicHBox.setAlignment(Pos.BOTTOM_RIGHT);
		grid.add(searchTopicHBox, 1, 2);

		Label userSearchName= new Label("Search User:");
		grid.add(userSearchName, 0, 3);
		inputUser = new TextField();
		grid.add(inputUser, 1, 3);

		HBox searchUserHBox = new HBox(userButton);
		searchUserHBox.setAlignment(Pos.BOTTOM_RIGHT);
		grid.add(searchUserHBox, 1, 4);

		primaryStage.setScene(scene);
		primaryStage.show();

		searchTopicAction();
		searchUserAction();
	}

	public void searchTopicAction(){
		searchButton.setOnAction(event -> {
			try {
				getTopicRevision();
				showTopicOutput();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
		});
	}

	public void searchUserAction(){
		userButton.setOnAction(event -> {
			try {
				getUserRevision();
				showUserOutput();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
		});
	}

	public void getTopicRevision() throws IOException, ParserConfigurationException, SAXException {
		URLFactory factory = new URLFactory();
		RevisionParser parser = new RevisionParser();

		InputStream inputStream = factory.getStreamFromSesearchTopic(inputSearch.getText());
		parser.setUpDocument(inputStream);

		ArrayList<Revision> revisionTopicList = parser.getRevisionTopicList();
		for(Revision revision: revisionTopicList){
			RevisionTopicView revisionView = new RevisionTopicView(revision);
			searchViewOutput.getChildren().add(revisionView);
		}
	}

	public void getUserRevision() throws IOException, ParserConfigurationException, SAXException {
		URLFactory factory = new URLFactory();
		RevisionParser parser = new RevisionParser();

		InputStream inputStream = factory.getStreamFromSesearchTopic(inputSearch.getText());
		parser.setUpDocument(inputStream);

		ArrayList<Revision> revisionUserList = parser.getRevisionUserList(inputUser.getText());
		for(Revision revision: revisionUserList){
			RevisionUserView revisionUserView = new RevisionUserView(revision);
			userViewOutput.getChildren().add(revisionUserView);
		}
	}

	public void showTopicOutput() {
		VBox vBox = new VBox(searchViewOutput);
		ScrollPane scrollPane = new ScrollPane(vBox);
		Scene scene = new Scene(scrollPane, 400, 700);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

	public void showUserOutput() {
		VBox vBox = new VBox(userViewOutput);
		ScrollPane scrollPane = new ScrollPane(vBox);
		Scene scene = new Scene(scrollPane, 400, 700);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

}
