import java.awt.GridLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class MineSweeper extends JFrame {

	
	private int AllNumberOfMine;
	public int getAllNumberOfMine() {
		return AllNumberOfMine;
	}

	public void setAllNumberOfMine(int allNumberOfMine) {
		AllNumberOfMine = allNumberOfMine;
	}

	public static void main(String[] args) {
	
	
		
		
		MineSweeper ms =new MineSweeper();
		ms.setLayout(new GridLayout(2,1));	//���Ʒ��� StatusBar �� Board �� �־��ش�.
		
		
	}

	public MineSweeper() {
		super("����ã��");
		Scanner a= new Scanner(System.in);
		//int x=a.nextInt();
		//int y=a.nextInt();
		//int numMine=a.nextInt();
		//this.add(new Board(x,y,numMine));
		System.out.println("���ڸ� ��� �ұ��");
		Scanner scn = new Scanner(System.in);
		this.AllNumberOfMine=scn.nextInt();

		//this.add(new TimerAndStatus());

		this.add(new Board(10,10,this.AllNumberOfMine));

		
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
