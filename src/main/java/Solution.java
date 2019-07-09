import java.util.ArrayList;
public class Solution {
    public static  void main(String args[]){
        Solution s=new Solution();

        System.out.println(s.FindContinuousSequence(9));

    }
    public ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
        if(sum<3) return null;
        ArrayList<ArrayList<Integer>> result=new  ArrayList<ArrayList<Integer>>();
//        ArrayList<Integer> current=new ArrayList<Integer>();
//        ArrayList<Integer> temp=new ArrayList<Integer>();
        for(int i=1;i<=sum/2;i++){
            ArrayList<Integer> current=new ArrayList<Integer>();
            int resultSum=0;
            int j=i-1;
            while(resultSum!=sum&&resultSum<sum){
                j++;
                resultSum=resultSum+j;

            }
            if(resultSum==sum){
                for(int m=i;m<=j;m++){
                    current.add(m);
                }

                result.add(current);
            }

        }
        return result;
    }
}