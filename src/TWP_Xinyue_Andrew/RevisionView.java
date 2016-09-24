package TWP_Xinyue_Andrew;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Created by Administrator on 2016/9/22 0022.
 */

public class RevisionView extends VBox{

//	public RevisionView(Revision revision){
//
//	}
	public RevisionView(Revision revision){
		getChildren().addAll(
				new Label("Title: " + revision.user),
				new Label("Time Stamp: " + revision.timeStamp),
				new Label("Time Stamp: " + revision.comment)
		);
	}
}
