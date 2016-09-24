import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import org.junit.Test;
/**
 * Created by Administrator on 2016/9/23 0023.
 */
public class RevisionViewTest {

	@Test
	public void newVBoxTest(){
		VBox vbox = new VBox(8);
		vbox.getChildren().addAll(new Button("Cut"), new Button("Copy"), new Button("Paste"));
	}

}
