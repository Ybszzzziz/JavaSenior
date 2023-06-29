import java.util.*;

/**
 * @author Yan
 * @create 2023-03-19 21:33
 **/
public class test {
    static int times = 0;
    public static void main(String[] args) {
        //1 2 3 4 5 6 left:0 mid:3 1
        //4 5 6 1 2 3 l:0 r:2 mid:1
        //6 4 5 3 1 2
        //6 5 4 3 2 1
        //12345
        //54321
        //12345678 0 7 3
        //56781234
        //78563412
        //87654321
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int left = 0;
        int right = n - 1;
        System.out.println(n-1);
        reverse(nums, left, right);
        System.out.println(Arrays.toString(nums));

    }

    public static void reverse(int[] nums, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            int i = left + 1;
            int j = mid;
            int k = right + 1;
            int temp = 0;
            int l = left;
            if (l != 0) {
                if (right - left == 1) {
                    while (l <= mid) {
                        if (l != 0) {
                            temp = nums[l + mid % l + 1];
                            nums[l + mid % l + 1] = nums[l];
                            nums[l] = temp;
                            l++;
                            times++;
                        }
                    }
                } else {
                    if(right % 2 == 0){
                        while (l < mid) {
                            if (l != 0) {
                                temp = nums[l + mid / l + 1];
                                nums[l + mid / l + 1] = nums[l];
                                nums[l] = temp;
                                l++;
                                times++;
                            }
                        }
                    }else{
                        while (l <= mid) {
                            if (l != 0) {
                                temp = nums[l + mid % l + 1];
                                nums[l + mid % l + 1] = nums[l];
                                nums[l] = temp;
                                l++;
                                times++;
                            }
                        }
                    }

                }
            } else {
                if(right % 2 == 0){
                    while (l < mid) {
                        temp = nums[l + mid + 1];
                        nums[l + mid + 1] = nums[l];
                        nums[l] = temp;
                        l++;
                        times++;
                    }
                }else{
                    while (l <= mid) {
                        temp = nums[l + mid + 1];
                        nums[l + mid + 1] = nums[l];
                        nums[l] = temp;
                        l++;
                        times++;
                    }
                }
            }
            if(j < i){
                j++;
            }
            System.out.println(i+" "+j+" "+k);
            reverse(nums, left, mid);
            if (mid != 0) {
                reverse(nums, mid + 1, right);
            }
        }
    }
}
