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
		ms.setLayout(new GridLayout(2,1));	//위아래로 StatusBar 과 Board 를 넣어준다.
		
		
	}

	public MineSweeper() {
		super("지뢰찾기");
		Scanner a= new Scanner(System.in);
		//int x=a.nextInt();
		//int y=a.nextInt();
		//int numMine=a.nextInt();
		//this.add(new Board(x,y,numMine));
		System.out.println("지뢰를 몇개로 할까요");
		Scanner scn = new Scanner(System.in);
		this.AllNumberOfMine=scn.nextInt();

		//this.add(new TimerAndStatus());

		this.add(new Board(10,10,this.AllNumberOfMine));

		
		this.setVisible(true);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}
