//随机生成6位数密码
public class code {

	public static void main(String[] args) {
		String source="abcdefghjkmnpqrstuvwxyz123456789";
		StringBuilder code=new StringBuilder();
		for(int i=0;i<6;i++) {
			int index=(int)(Math.random()*source.length());
			code.append(source.charAt(index));
		}
		System.out.println(code);

	}
}
