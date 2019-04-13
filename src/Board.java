import java.awt.GridLayout;
import java.util.Random;

import javax.swing.JPanel;

public class Board extends JPanel {

	int col, row;

	private Box[][] boxes;

	public Box[][] getBoxes() {
		return boxes;
	}

	Board(int x, int y, int numMine) { // 보드 생성자
		Random random = new Random();
		this.col = x;
		this.row = y; // 보드의 크기

		this.setLayout(new GridLayout(x, y));

		boxes = new Box[x][y]; // boxes생성(보드판)
		for (int i = 0; i < x; i++)
			for (int j = 0; j < y; j++) {

				boxes[j][i] = new Box(j,i, this);
				this.add(boxes[j][i]);// i,j안쓰면 어떻게되나
			}

		for (int k = 0; k < numMine; k++) {
			int a = random.nextInt(x);
			int b = random.nextInt(y);
			boxes[a][b].setMine(true);
		}

		for (int i = 0; i < x; i++) // 보드판인 boxes 생성이 끝났다. 하나하나 돌면서 주변의 마인갯수를 확인
			for (int j = 0; j < y; j++) {
				checkNumOfMine(i, j);

			}

	}

	public void checkNumOfMine(int x, int y) { // 주변의 8개씩 돌면서 자신의 numofmine 을 1씩 증가시킨다.
		if (x == 0 && y == 0) {
			if (boxes[1][0].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
			if (boxes[0][1].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
			if (boxes[1][1].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}

		} else if (x == 0 && y == this.row - 1) {
			if (boxes[0][this.row - 2].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
			if (boxes[1][this.row - 1].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
			if (boxes[1][this.row - 2].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}

		} else if (x == this.col - 1 && y == 0) {
			if (boxes[col - 2][0].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
			if (boxes[col - 1][1].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
			if (boxes[col - 2][1].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
		} else if (x == this.col - 1 && y == this.row - 1) {
			if (boxes[col - 1][row - 2].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
			if (boxes[col - 2][row - 1].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
			if (boxes[col - 2][row - 2].isMine()) {
				boxes[x][y].increaseNumOfMine();
			}
		}

		else if (x == 0) {
			for (int k = y - 1; k <= y + 1; k++) {
				if (boxes[0][k].isMine()) {
					boxes[x][y].increaseNumOfMine();
				}
				if (boxes[1][k].isMine()) {
					boxes[x][y].increaseNumOfMine();
				}
			}
		}

		else if (x == this.col - 1) {
			for (int k = y - 1; k <= y + 1; k++) {
				if (boxes[col - 2][k].isMine()) {
					boxes[x][y].increaseNumOfMine();
				}
				if (boxes[col - 1][k].isMine()) {
					boxes[x][y].increaseNumOfMine();
				}
			}

		} else if (y == 0) {
			for (int k = x - 1; k <= x + 1; k++) {
				if (boxes[k][0].isMine()) {
					boxes[x][y].increaseNumOfMine();
				}
				if (boxes[k][1].isMine()) {
					boxes[x][y].increaseNumOfMine();
				}
			}
		} else if (y == row - 1) {

			for (int k = x - 1; k <= x + 1; k++) {
				if (boxes[k][row - 2].isMine()) {
					boxes[x][y].increaseNumOfMine();
				}
				if (boxes[k][row - 1].isMine()) {
					boxes[x][y].increaseNumOfMine();
				}
			}
		}

		else {
			for (int k = x - 1; k <= x + 1; k++) {
				for (int l = y - 1; l <= y + 1; l++) {
					if (boxes[k][l].isMine()) {
						boxes[x][y].increaseNumOfMine();
					}

				}
			}
		}

	}

	public void checkAround(int x, int y) {
		System.out.println("x= "+x + "y= "+y );
		if (x == 0 && y == 0) {

			this.boxes[1][0].setClicked();
			this.boxes[0][1].setClicked();
			this.boxes[1][1].setClicked();

		} else if (x == 0 && y == this.row - 1) {

			this.boxes[0][this.row - 2].setClicked();
			this.boxes[1][this.row - 1].setClicked();
			this.boxes[1][this.row - 2].setClicked();

		} else if (x == this.col - 1 && y == 0) {

			this.boxes[col - 2][0].setClicked();
			this.boxes[col - 1][1].setClicked();
			this.boxes[col - 2][1].setClicked();
		} else if (x == this.col - 1 && y == this.row - 1) {

			this.boxes[col - 1][row - 2].setClicked();
			this.boxes[col - 2][row - 1].setClicked();
			this.boxes[col - 2][row - 2].setClicked();
		}

		else if (x == 0) {
			for (int k = y - 1; k <= y + 1; k++) {
				if (k != y)
					this.boxes[0][k].setClicked();				
				this.boxes[1][k].setClicked();
			}
		}

		else if (x == this.col - 1) {
			System.out.println("4");

			for (int k = y - 1; k <= y + 1; k++) {
				this.boxes[col - 2][k].setClicked();
				if (k != y)
					this.boxes[col - 1][k].setClicked();
			}

		} else if (y == 0) {
			for (int k = x - 1; k <= x + 1; k++) {
				if (k != x) {
					System.out.println("1");
					this.boxes[k][0].setClicked();
				}

				this.boxes[k][1].setClicked();
			}
		} else if (y == row - 1) {

			for (int k = x - 1; k <= x + 1; k++) {
				System.out.println("2");

				this.boxes[k][row-2].setClicked();
				if(x!=k)
					this.boxes[k][row-1].setClicked();
			}
		}

		else {

			System.out.println("3");

			for (int k = x - 1; k <= x + 1; k++) {
				for (int l = y - 1; l <= y + 1; l++) {
					if (k == x && l == y)
						continue;
					this.boxes[k][l].setClicked();
				}
			}
		}
	}
}