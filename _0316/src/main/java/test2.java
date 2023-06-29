import java.util.*;
public class test2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] numsS = sc.nextLine().split(" ");
        Arrays.sort(numsS);
        int res = 0;
        long temp = 0;
        temp = Math.min(1,Long.parseLong(numsS[0])) + 1;
        for(int i = 1; i < n ; i++){
            if(temp <= Long.parseLong(numsS[i])){
                temp = Math.min(temp,Long.parseLong(numsS[i])) + 1;
            }
        }
        System.out.println(temp);
    }
}