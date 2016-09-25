package TWP_Xinyue_Andrew;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by Administrator on 2016/9/25 0025.
 */
public class RevisionUserView extends VBox {

	public RevisionUserView(Revision revision){
		getChildren().addAll(
				new Label("User: " + revision.user),
				new Label("Time Stamp: " + revision.timeStamp),
				new Label("Comment: " + revision.comment)
		);
	}

}
