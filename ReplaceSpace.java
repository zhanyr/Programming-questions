package programming;
/**
 * @author zhanyr
 *��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 *���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		StringBuffer sb = new StringBuffer();
		int length = str.toString().length();
		//���λ�ȡ�ַ��������ж�
		for(int i = 0 ;i<length ;i++){
			if(str.charAt(i) == ' ')sb.append("%20");
			else sb.append(str.charAt(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		ReplaceSpace replaceSpace = new ReplaceSpace();
		StringBuffer sBuffer =new StringBuffer("We Are Happy");
		System.out.println(replaceSpace.replaceSpace(sBuffer));
	}
}
