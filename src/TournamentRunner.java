

import java.util.ArrayList;
import java.util.Collections;

import com.amazonaws.mturk.service.axis.RequesterService;
import com.amazonaws.mturk.util.PropertiesClientConfig;

public class TournamentRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int k1 = Integer.parseInt(args[0]);
		int k2 = Integer.parseInt(args[1]);
		int f = Integer.parseInt(args[2]);
		int g = Integer.parseInt(args[3]);
		int o = Integer.parseInt(args[4]);
		double reward = Double.parseDouble(args[5]);
		boolean useTag = Boolean.parseBoolean(args[6]);
		int shuffleCount = Integer.parseInt(args[7]);
		
		String rootDir = System.getProperty("user.dir");
		
		//test
		RequesterService service = new RequesterService(new PropertiesClientConfig(rootDir + java.io.File.separator + "mturk.properties"));
		
		//real
//		RequesterService service = new RequesterService(new PropertiesClientConfig(rootDir + java.io.File.separator + "real_mturk.properties"));
		
		ArrayList<String> urls1 = new ArrayList<String>();
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (0).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (1).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (2).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (3).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (4).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (5).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (6).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (7).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (8).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (9).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (10).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (11).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (12).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (13).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (14).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (15).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (16).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (17).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (18).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (19).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (20).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (21).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (22).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (23).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (24).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (25).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (26).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (27).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (28).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (29).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (30).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (31).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (32).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (33).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (34).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (35).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (36).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (37).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (38).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (39).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (40).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (41).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (42).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (43).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (44).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (45).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (46).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (47).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (48).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (49).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (50).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (51).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (52).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (53).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (54).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (55).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (56).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (57).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (58).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (59).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (60).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (61).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (62).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (63).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (64).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (65).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (66).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (67).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (68).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (69).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (70).JPG");
		urls1.add("http://users.soe.ucsc.edu/~khuang/testpic/testpic (71).JPG");
		
		
		ArrayList<String> originalUrls = (ArrayList<String>) urls1.clone();
		TournamentAlgorithm tournamentAlg;
		for(int i =0; i < shuffleCount; i++){
			Collections.shuffle(urls1);
			tournamentAlg = new TournamentAlgorithm(service, urls1, k1, k2, f, g, o, reward, useTag, i+1);
			//2 1 4 2 1 0.01 true 3
			tournamentAlg.run();
			while(!tournamentAlg.isDone()){
				try {
					Thread.sleep(1000*5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("No."+i+" algorithm instance is done.");
			urls1 = (ArrayList<String>) originalUrls.clone();
		}
		
	}

}
