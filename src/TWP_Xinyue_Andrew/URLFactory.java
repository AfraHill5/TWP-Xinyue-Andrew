package TWP_Xinyue_Andrew;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Administrator on 2016/9/22 0022.
 */
public class URLFactory {

	public static String UrlUserNumber = "10";
	protected static boolean allowUserInteraction;

	private static String UrlFirstPart1 = "https://en.wikipedia.org/w/api.php?action=query&format=xml&prop=revisions&titles=";
	private static String UrlFirstPart2 = "&rvprop=timestamp|comment|user&rvlimit=";

	public static InputStream getStreamFromSesearchTopic(String SesearchTopicName) throws IOException {

		allowUserInteraction  = true;

		URL url = new URL(UrlFirstPart1 + SesearchTopicName + UrlFirstPart2 + UrlUserNumber);
		InputStream inputStream = url.openStream();
		return inputStream;
	}
}
