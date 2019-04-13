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
	private int pointx,pointy;	//�����ǿ��� �ڽ��� ��ġ


	public int getPointx() {
		return pointx;
	}

	public void setPointx(int pointx) {
		this.pointx = pointx;
	}

	public Box(int x, int y, Board board) {						//�ڽ������ڴ� Board.java ���� ���� ���� �����Ҷ� ���忡 ��ġ�ϴ� ��ġ�� ���ڷ� �־��ְ�
		this.setPointx(x); this.setPointy(y);		// �� �ڽ����� �� ��ġ�� ����ϰ� ����
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

	public void setClicked() { // Ŭ�� �Ǿ����� �ֺ��� ���ξ����� �׳� �������ϰ� �ֺ��� ���ڰ������� ���ڸ� ǥ���Ѵ�.
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
			////////////////////////////////////q)���⿡ getBoxes().clickedBoxes(this.pointx,this.pointy)�ϰ� �;�...���ۺ��ε� �ȵɱ�
		}
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (this.isMine()) {
			this.setBackground(Color.red);//���ڶ�� ���������� ����
			JOptionPane.showMessageDialog(null, " ���� ��ҽ��ϴ�! ", "����", JOptionPane.ERROR_MESSAGE);
///Q) ���⼭�� board �����ؼ� for�������� ��� isMine �� box�鿡 ����  ���ڻ�(����+�Ǵ� ���ڱ۾�) ���� ���ϰ� ���ְ�ʹ�.		�ٵ� �����̾ȵǴ�..	
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
