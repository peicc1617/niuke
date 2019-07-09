import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        String str=sc.next();
        int k=(N-1)/3;
        int rows=2*k+1;
        int index=0;
        ArrayList list=new ArrayList();
        for(int i=0;i<rows;i++){
            StringBuilder sb=new StringBuilder();
            if(i<=k){
                for(int j=0;j<rows;j++){
                    if(j==i||j==rows-1-i){
                        sb.append(str.substring(index,index+1));
                        index++;
                    }else{
                        sb.append(" ");
                    }
                }

            }else{
                for(int j=0;j<rows;j++){
                    if(j==k){
                        sb.append(str.substring(index,index+1));
                        index++;
                    }else{
                        sb.append(" ");
                    }
                }
            }
            list.add(sb);
        }
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}