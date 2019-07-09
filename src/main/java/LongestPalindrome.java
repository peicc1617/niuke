public class LongestPalindrome {
    public static  void main(String args[]){
        System.out.println(lonestPalindrome("aabaad"));
        System.out.println(longestPalindrome("aabaad"));
    }
    public static String lonestPalindrome(String  s){
        if(s.length()<2) return s;
        String result="";
        int j,k;

        //如果字符串为基数==奇数
        if((s.length()&1)==1){

            for(int i=1;i<s.length();i++){
                int sum=1;
                for(j=i-1,k=i+1;j>=0&&k<s.length();j--,k++){
                    if(s.charAt(j)!=s.charAt(k)){
                        break;
                    }
                    sum=sum+2;

                }

                if(sum>result.length()){
                    result=s.substring(j+1,k);
                }


            }
            return result;

        }
        else{

            for(int i=1;i<s.length();i++){
                int sum1=0;
                for(j=i-1,k=i;j>=0&k<s.length();j--,k++) {
                    if (s.charAt(j) != s.charAt(k)) {
                        break;
                    }
                    sum1 = sum1 + 2;

                }
                if(sum1>result.length()){
                    result=s.substring(j+1,k);

                }


            }
            return result;

        }


    }
    public static String longestPalindrome(String s) {
        // 如果回字符串长度小于2直接返回
        if(s.length() < 2) {
            return s;
        }
        // 记录最长的回文串
        String palindromic = "";
        int j, k;
        for(int i = 1; i < s.length(); i++) {
            if(s.length() - i <= palindromic.length() / 2) {
                break;
            }
            int sum = 1;
            // 奇数长度判断
            for(j = i - 1, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
                if(s.charAt(j) != s.charAt(k)) {
                    break;
                }
                sum = sum + 2;
            }
            if(sum > palindromic.length()) {
                palindromic = s.substring(j + 1, k);
            }
            sum = 0;
            // 偶数长度判断
            for(j = i - 1, k = i; j >= 0 && k < s.length(); j--, k++) {
                if(s.charAt(j) != s.charAt(k)) {
                    break;
                }
                sum = sum + 2;
            }
            if(sum > palindromic.length()) {
                palindromic = s.substring(j + 1, k);
            }
        }
        return palindromic;
    }

}
