/*import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimerAndStatus extends JPanel {
	JLabel timerLabel = null;
	JLabel allNumOfMine =new JLabel();

	public TimerAndStatus() {
		System.out.println("33333");

		this.setLayout(new FlowLayout());
		timerLabel = new JLabel("0");
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		this.add(timerLabel);
		this.add(allNumOfMine);
		int k = 0;
		while (true) {
			timerLabel.setText("" + k);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			k++;
		}
	}
}




//Java program to demonstrate 
//schedule method calls of Timer class 

import java.util.Timer; 
import java.util.TimerTask; 

class Helper extends TimerTask 
{ 
 public static int i = 0; 
 public void run() 
 { 
     System.out.println("Timer ran " + ++i); 
 } 
} 

public class Test 
{ 
 public static void main(String[] args) 
 { 
       
     Timer timer = new Timer(); 
     TimerTask task = new Helper(); 
       
     timer.schedule(task, 2000, 5000); 
       
 } 
*/