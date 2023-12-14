package saur.memebot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class PollTimer implements ActionListener {
	
	Timer t = new Timer(1000, this);
	int timeLimit = 60;
	
	public PollTimer(int time) {
		
		timeLimit = time;
		
		t.start();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}

}