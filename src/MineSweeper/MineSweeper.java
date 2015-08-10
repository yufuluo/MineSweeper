package MineSweeper;

public class MineSweeper {
	private final int MINE = -1;
	private int[][] mine;
	private boolean[][] shown;
	
	public Status click(int x, int y) {
		if (shown[x][y] || x>=mine[0].length || y>=mine.length || x<0 || y<0) {
			return Status.CONTINUE;
		}
		if (mine[x][y] == MINE) {
			return Status.LOSS;
		}
		if (mine[x][y] != 0) {
			shown[x][y] = true;
			return Status.CONTINUE;
		} else {
			shown[x][y] = true;
			click(x-1,y+1);
			click(x-1,y);
			click(x-1,y-1);
			click(x,y+1);
			click(x,y-1);
			click(x+1,y+1);
			click(x+1,y);
			click(x+1,y-1);
			return Status.CONTINUE;
		}
	}
	
}

