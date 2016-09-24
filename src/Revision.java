/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class Revision {

	public String user;
	public String timeStamp;
	public String comment;


	public Revision(){
		user = "";
		timeStamp = "";
		comment = "";
	}

	public Revision setUpRevision(String user, String timeStamp, String comment) {
		this.user = user;
		this.timeStamp = timeStamp;
		this.comment = comment;
		return this;
	}

}
