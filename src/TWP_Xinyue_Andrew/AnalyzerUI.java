package TWP_Xinyue_Andrew;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class AnalyzerUI extends Application{

	private TextField inputField = new TextField();
	private TextField outputField = new TextField();

	private Button goButton = new Button("Go");
//	public VBox vBox = new VBox(outputField);

	@Override
	public void start(Stage primaryStage) {

		outputField.setEditable(false);

//		goButton = new Button("Search");
		Label LabeName1 = new Label("Search Topic:");
		HBox pageHBox = new HBox(LabeName1, inputField);
		primaryStage.setTitle("TWP_Xinyue_Andrew.Revision Information Analyzer");
		VBox vbox = new VBox(pageHBox, goButton, outputField);
		Scene scene = new Scene(vbox, 500, 500);
		primaryStage.setScene(scene);
		primaryStage.show();
//		outputField();
		goButton.setOnAction(event -> {
			try {
				getRevision();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			}
		});
	}




	public void getRevision() throws IOException, ParserConfigurationException, SAXException {
		URLFactory factory = new URLFactory();
		RevisionParser parser = new RevisionParser();

		InputStream inputStream = factory.getStreamFromSesearchTopic(inputField.getText());
		parser.setUpDocument(inputStream);

		ArrayList<Revision> revisionList = parser.getRevisionList();
		for(Revision revision: revisionList){
		}

	}




}
