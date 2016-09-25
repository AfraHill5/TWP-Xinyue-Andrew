package TWP_Xinyue_Andrew;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by Administrator on 2016/9/22 0022.
 */

public class RevisionView extends VBox{

	private Button button;

	public RevisionView(Revision revision){
		Label label = new Label("User: ");
		button = new Button(revision.user);
		HBox hBox = new HBox(label,button);
		getChildren().addAll(
				hBox,
				new Label("Title: " + revision.user),
				new Label("Time Stamp: " + revision.timeStamp),
				new Label("Time Stamp: " + revision.comment)
		);
	}
}
