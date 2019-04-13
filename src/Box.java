import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Box extends JButton implements ActionListener {

	
	private static Board board;
	private boolean mine;
	private int numOfMine ;
	private boolean flag;
	private int pointx,pointy;	//보드판에서 박스의 위치


	public int getPointx() {
		return pointx;
	}

	public void setPointx(int pointx) {
		this.pointx = pointx;
	}

	public Box(int x, int y, Board board) {						//박스생성자는 Board.java 에서 사용됨 따라서 생성할때 보드에 위치하는 위치를 인자로 넣어주고
		this.setPointx(x); this.setPointy(y);		// 각 박스마다 그 위치를 기억하게 만듬
		this.setBackground(Color.yellow);
		this.setPreferredSize(new Dimension(50, 50));
		this.mine = false;
		this.numOfMine = 0;
		this.flag = false;
		this.board = board;
		this.addActionListener(this);
	}

	public boolean isMine() {
		return mine;
	}

	public void setMine(boolean isMine) {
		this.mine = isMine;
		this.setBackground(Color.yellow);
	}

	public int getNumOfMine() {
		return numOfMine;
	}

	public void increaseNumOfMine() {
		this.numOfMine++;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void setClicked() { // 클릭 되었을때 주변에 마인없으면 그냥 색만변하고 주변에 지뢰가있으면 숫자를 표현한다.
		System.out.println("x ="+this.pointx + "y="+this.pointy);
		if(this.isEnabled()==false) {
			return;
		}
		if (this.numOfMine == 0) {
			this.setBackground(Color.green);
			this.setEnabled(false);
			board.checkAround(this.pointx,this.pointy);
		}
		
		else {
			this.setBackground(Color.green);			
			this.setText("" + this.numOfMine);
			this.setEnabled(false);
			////////////////////////////////////q)여기에 getBoxes().clickedBoxes(this.pointx,this.pointy)하고 싶어...왜퍼블릭인데 안될까
		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (this.isMine()) {
			this.setBackground(Color.red);//지뢰라면 빨간색으로 만듬
			JOptionPane.showMessageDialog(null, " 지뢰 밟았습니다! ", "종료", JOptionPane.ERROR_MESSAGE);
///Q) 여기서도 board 접근해서 for문돌려서 모든 isMine 인 box들에 대해  지뢰색(빨강+또는 지뢰글씨) 으로 변하게 해주고싶다.		근데 접근이안되니..	
			System.exit(1);
		} else {
			setClicked();

		}

	}

	public int getPointy() {
		return pointy;
	}

	public void setPointy(int pointy) {
		this.pointy = pointy;
	}


}
