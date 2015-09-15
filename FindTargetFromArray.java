package programming;

/**
 * @author zhanyr
 *  在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 *  每一列都按照从上到下递增的顺序排序。请完成一个函数，
 *  输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindTargetFromArray {
	public boolean Find(int[][] array, int target) {
		boolean isFind = false;
		int row = array.length;
		int column = array[array.length - 1].length;
		int x = 0;
		while (row > 0 && column > 0 && !isFind) {
			if (target > array[x][column - 1]) {
				// 大于右上角的数字，在下面
				x = x + 1;
				row = row - 1;
			} else if (target < array[x][column - 1]) {
				// 小于右上角数字，在左边
				column = column - 1;
			} else {
				// 等于
				isFind = true;
				break;
			}
		}
		return isFind;
	}

	public static void main(String[] args) {
		FindTargetFromArray solution = new FindTargetFromArray();
		int[][] array = new int[2][3];
		int num = 0;
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 3; j++)
				array[i][j] = num++;

		if (solution.Find(array, 3))
			System.out.println("find");
		else
			System.out.println("no");
	}
}
