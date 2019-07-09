import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class NameList
{


    public static void main(String[]args)
    {
       String []list  ={"Hollis","每日更新Java相关技术文章"};
        ArrayList list1=new ArrayList();
        list1.add(list[0]);
        list1.add(list[1]);
        String str1="1234";
        String str2="6789";
        String str3=str1.concat(str2);
        System.out.println(str1.length());

        System.out.println(list);
        String result= StringUtils.join(list1,",");
        System.out.println(list1+"这是字符串");
        int a='1';
        System.out.println(a);
    }
}