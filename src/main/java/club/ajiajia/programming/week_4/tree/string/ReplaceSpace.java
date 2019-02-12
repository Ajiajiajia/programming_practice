package club.ajiajia.programming.week_4.tree.string;
/*
    Solution 2
 */
public class ReplaceSpace {
    public String replace(StringBuffer str) {
        StringBuilder builder=new StringBuilder();
        if (str==null){
            return null;
        }
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                builder.append("%");
                builder.append("2");
                builder.append("0");
            }
            if (str.charAt(i)=='"'){
                builder.append(str.charAt(i));
            }
            else {
                builder.append(str.charAt(i));
            }
        }
    return builder.toString();
    }
    public static void main(String[] args) {
        ReplaceSpace test = new ReplaceSpace();
        StringBuffer str1 =new StringBuffer ("We are happy.");
        StringBuffer str2 = new StringBuffer (" Wearehappy.");
        StringBuffer str3 = new StringBuffer ("Wearehappy. ");
        StringBuffer str4 = new StringBuffer ("We   are   happy  .");
        StringBuffer str5=new StringBuffer ("");
        System.out.println(test.replace(str1));
        System.out.println(test.replace(str2));
        System.out.println(test.replace(str3));
        System.out.println(test.replace(str4));
        System.out.println(test.replace(str5));
        }
}
