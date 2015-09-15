package programming;

/**
 * @author zhanyr
 *  ��һ����ά�����У�ÿһ�ж����մ����ҵ�����˳������
 *  ÿһ�ж����մ��ϵ��µ�����˳�����������һ��������
 *  ����������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class FindTargetFromArray {
	public boolean Find(int[][] array, int target) {
		boolean isFind = false;
		int row = array.length;
		int column = array[array.length - 1].length;
		int x = 0;
		while (row > 0 && column > 0 && !isFind) {
			if (target > array[x][column - 1]) {
				// �������Ͻǵ����֣�������
				x = x + 1;
				row = row - 1;
			} else if (target < array[x][column - 1]) {
				// С�����Ͻ����֣������
				column = column - 1;
			} else {
				// ����
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
