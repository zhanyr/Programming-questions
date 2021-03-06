package programming;
/**
 * @author zhanyr
 *请实现一个函数，将一个字符串中的空格替换成“%20”。
 *例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
	public String replaceSpace(StringBuffer str) {
		StringBuffer sb = new StringBuffer();
		int length = str.toString().length();
		//依次获取字符，进行判断
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
