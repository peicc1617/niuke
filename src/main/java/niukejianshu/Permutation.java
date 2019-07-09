package niukejianshu;
import java.util.ArrayList;
import java.util.TreeSet;

public class Permutation {
    static ArrayList<String> result=new ArrayList<String>();
    static TreeSet<String> res=new TreeSet<String>();
    public static ArrayList<String> permutation(String str) {

        int len=str.length();
        if(len<1){
            return result;
        }
        if(len==1){
            result.add(str);
            return result;
        }else{
            permutations(result,str.toCharArray(),0,len);
            return result;
        }

    }
    static void permutations(ArrayList<String> result,char[] chars,int index,int len){
        if(index==len){
            result.add(String.valueOf(chars));
            return ;
        }
        for(int i=index;i<len;i++){
            //交换i,index的位置
            if(i!=index&&chars[i]==chars[index]) continue;
            swap(chars,index,i);
            permutations(result,chars,index+1,len);
            swap(chars,index,i);
        }
    }
    public static void swap(char[] chars,int a,int b){
        if(a!=b){
            char temp = chars[a];
            chars[a]=chars[b];
            chars[b]=temp;
        }

    }

    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }

}