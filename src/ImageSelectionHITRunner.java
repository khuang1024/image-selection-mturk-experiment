
import java.util.ArrayList;

import com.amazonaws.mturk.requester.HIT;
import com.amazonaws.mturk.requester.HITStatus;
import com.amazonaws.mturk.service.axis.RequesterService;
import com.amazonaws.mturk.util.PropertiesClientConfig;

public class ImageSelectionHITRunner {

    /**
     * @param args
     */
    public static void main(String[] args) {
	String rootDir = System.getProperty("user.dir");
	RequesterService service = new RequesterService(
		new PropertiesClientConfig(rootDir + java.io.File.separator
			+ "mturk.properties"));

	try {
	    service.disableHIT("2MTMJTUHYW2GK2H38EJ5ZM16AVBJOJ");
	} catch (Exception e) {
	}

	ArrayList<String> urls1 = new ArrayList<String>();
	urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (1).jpg");
	urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (2).jpg");
	urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (3).jpg");
	urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (4).jpg");
	urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (5).jpg");
	urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (6).jpg");

	ArrayList<String> urls2 = new ArrayList<String>();
	urls2.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (7).jpg");
	urls2.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (8).jpg");
	urls2.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (9).jpg");
	urls2.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (10).jpg");
	urls2.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (11).jpg");
	urls2.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (12).jpg");

	ImageSelectionHIT imageHit1 = new ImageSelectionHIT(service, "alg",
		"1", urls1, 1, 1, 2, 1, 3, 2, 2, 0);
	ImageSelectionHIT imageHit2 = new ImageSelectionHIT(service, "alg",
		"1", urls2, 1, 1, 2, 1, 3, 2, 2, 0);

	HIT temp1 = service.getHIT(imageHit1.getImageSelectionHITID());
	HIT temp2 = service.getHIT(imageHit2.getImageSelectionHITID());

	while (temp1.getHITStatus() != HITStatus.Reviewable
		|| temp2.getHITStatus() != HITStatus.Reviewable) {
	    System.out.println("The number of active HITs: "
		    + service.getTotalNumHITsInAccount());
	    temp1 = service.getHIT(imageHit1.getImageSelectionHITID());
	    temp2 = service.getHIT(imageHit2.getImageSelectionHITID());
	    System.out.println("temp1 Status:"
		    + temp1.getHITStatus().toString());
	    System.out.println("temp2 Status:"
		    + temp2.getHITStatus().toString());
	    try {
		Thread.sleep(1000 * 5);
	    } catch (Exception e) {
		System.err.println(e.getMessage());
	    }
	}

	imageHit1.getAnsweredUrls();
	imageHit2.getAnsweredUrls();

	service.disableHIT(imageHit1.getImageSelectionHITID());
	service.disableHIT(imageHit2.getImageSelectionHITID());
	System.out
		.println("After disable all HITs are done, the number of active HITs is: "
			+ service.getTotalNumHITsInAccount());
    }

}
