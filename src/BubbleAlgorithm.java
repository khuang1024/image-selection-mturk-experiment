

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.amazonaws.mturk.service.axis.RequesterService;
import com.amazonaws.mturk.requester.HIT;
import com.amazonaws.mturk.requester.HITStatus;

public class BubbleAlgorithm {
    private ArrayList<String> imageUrls;// the initial URLs of pictures

    private RequesterService service;
    private int k1;
    private int k2;
    private int f;
    private int g;
    private int o;
    private double reward;

    private String rootDir = System.getProperty("user.dir");
    private String alg = "alg2_";
    private String shuffleCount;
    private String logFile;
    private String hitLogFile;
    private String answerLogFile;

    /**
     * 
     * @param service
     * @param imageUrls
     * @param k1
     * @param k2
     * @param f
     * @param g
     * @param o
     * @param reward
     *            the atomic reward for each image, so for a normal HIT, the
     *            reward should be reward*f*g. but this is dealt in
     *            ImageSelectionHIT itself. So we just need to give out the
     *            atomic reward
     */
    public BubbleAlgorithm(RequesterService service, ArrayList<String> imageUrls,
	    int k1, int k2, int f, int g, int o, double reward, int shuffleCount) {

	this.imageUrls = new ArrayList<String>();
	this.service = service;
	this.imageUrls = imageUrls;
	this.k1 = k1;
	this.k2 = k2;
	this.f = f;
	this.g = g;
	this.o = o;
	this.reward = reward;

	this.shuffleCount = Integer.toString(shuffleCount);
	this.logFile = rootDir + java.io.File.separator + alg + "_"
		+ this.shuffleCount + "log.txt";
	this.hitLogFile = rootDir + java.io.File.separator + alg + "_"
		+ this.shuffleCount + "hit_log.txt";
	this.answerLogFile = rootDir + java.io.File.separator + alg + "_"
		+ this.shuffleCount + "answer_log.txt";

	this.resetLog(this.hitLogFile);
	this.resetLog(this.answerLogFile);
	this.resetLog(logFile);
    }

    public void run() {
	String[] answers = null;
	String para = "";
	para = "f=" + this.f + ", g=" + this.g + ", o=" + this.o + ", k1="
		+ this.k1 + ", k2=" + (15 / k1);
	para += "Number of active HITs in this account: "
		+ this.service.getTotalNumHITsInAccount();
	System.out.println(para);
	writeToLog(para, this.answerLogFile);
	writeToLog(para, this.logFile);
	while (this.imageUrls.size() > this.f * this.g) {
	    ArrayList<String> urlsForANewHIT = new ArrayList<String>();
	    for (int i = 0; i < this.f * this.g; i++) {
		urlsForANewHIT.add(this.imageUrls.get(0));
		this.imageUrls.remove(0);
	    }
	    ImageSelectionHIT imgHit = new ImageSelectionHIT(this.service,
		    this.alg, this.shuffleCount, urlsForANewHIT, 0, 0, this.k1,
		    this.k2, this.f, this.g, this.o, this.reward);
	    String hitId = imgHit.getImageSelectionHITID();
	    HIT hit = this.service.getHIT(hitId);
	    while (hit.getHITStatus() != HITStatus.Reviewable) {
		try {
		    Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		hit = this.service.getHIT(hitId);
	    }
	    answers = imgHit.getAnsweredUrls();
	    for (int i = answers.length - 1; i >= 0; i--) {
		this.imageUrls.add(0, answers[i]);
	    }
	    service.disableHIT(hit.getHITId());

	    // write log
	    String info = "The images in the queue are:("
		    + (new Date()).toString() + ")\n";
	    for (int i = 0; i < this.imageUrls.size(); i++) {
		info += "----" + this.imageUrls.get(i) + "\n";
	    }
	    info += "\n";
	    System.out.println(info);
	    this.writeToLog(info, this.hitLogFile);
	    this.writeToLog(info, this.logFile);
	}
	while (this.imageUrls.size() >= this.f) {
	    int num = this.imageUrls.size() / this.f;
	    ArrayList<String> urlsForANewHIT = new ArrayList<String>();
	    for (int i = 0; i < this.f * num; i++) {
		urlsForANewHIT.add(this.imageUrls.get(0));
		this.imageUrls.remove(0);
	    }
	    ImageSelectionHIT imgHit = new ImageSelectionHIT(this.service,
		    this.alg, this.shuffleCount, urlsForANewHIT, 0, 0, this.k1,
		    this.k2, this.f, num, this.o, this.reward);
	    String hitId = imgHit.getImageSelectionHITID();
	    HIT hit = this.service.getHIT(hitId);
	    while (hit.getHITStatus() != HITStatus.Reviewable) {
		try {
		    Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		hit = this.service.getHIT(hitId);
	    }
	    answers = imgHit.getAnsweredUrls();
	    for (int i = answers.length - 1; i >= 0; i--) {
		this.imageUrls.add(0, answers[i]);
	    }
	    service.disableHIT(hit.getHITId());

	    // write log
	    String info = "The images in the queue are:("
		    + (new Date()).toString() + ")\n";
	    for (int i = 0; i < this.imageUrls.size(); i++) {
		info += "----" + this.imageUrls.get(i) + "\n";
	    }
	    info += "\n";
	    System.out.println(info);
	    this.writeToLog(info, this.hitLogFile);
	    this.writeToLog(info, this.logFile);
	}
	if (this.imageUrls.size() > 1) {
	    int num = this.imageUrls.size();
	    ArrayList<String> urlsForANewHIT = new ArrayList<String>();
	    for (int i = 0; i < num; i++) {
		urlsForANewHIT.add(this.imageUrls.get(0));
		this.imageUrls.remove(0);
	    }
	    ImageSelectionHIT imgHit = new ImageSelectionHIT(this.service,
		    this.alg, this.shuffleCount, urlsForANewHIT, 0, 0, this.k1,
		    this.k2, num, 1, 1, this.reward);
	    String hitId = imgHit.getImageSelectionHITID();
	    HIT hit = this.service.getHIT(hitId);
	    while (hit.getHITStatus() != HITStatus.Reviewable) {
		try {
		    Thread.sleep(1000 * 10);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		hit = this.service.getHIT(hitId);
	    }
	    answers = imgHit.getAnsweredUrls();
	    for (int i = answers.length - 1; i >= 0; i--) {
		this.imageUrls.add(0, answers[i]);
	    }
	    service.disableHIT(hit.getHITId());

	    // write log
	    String info = "The images in the queue are:("
		    + (new Date()).toString() + ")\n";
	    for (int i = 0; i < this.imageUrls.size(); i++) {
		info += "----" + this.imageUrls.get(i) + "\n";
	    }
	    info += "\n";
	    System.out.println(info);
	    this.writeToLog(info, this.hitLogFile);
	    this.writeToLog(info, this.logFile);

	}
	String info = "";
	info = "The final answer is:\n";
	for (int i = 0; i < this.imageUrls.size(); i++) {
	    info += "---" + this.imageUrls.get(i) + "\n";
	}
	info += "Number of active HITs in this account: "
		+ service.getTotalNumHITsInAccount();
	System.out.println(info);
	this.writeToLog(info, this.answerLogFile);
	this.writeToLog(info, this.logFile);
	// for(int i = 0; i < answers.length; i++){
	// System.out.println("--"+answers[i]);
	// }
    }

    private void resetLog(String file) {
	FileOutputStream f;
	try {
	    f = new FileOutputStream(file);
	    f.close();
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private void writeToLog(String log, String file) {
	BufferedWriter bw = null;
	try {
	    bw = new BufferedWriter(new FileWriter(file, true));
	    bw.write(log);
	    bw.newLine();
	    bw.flush();
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		bw.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
    }
}
