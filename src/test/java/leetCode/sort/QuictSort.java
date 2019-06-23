package leetCode.sort;

/**
 * 快排
 *
 * @author zzs .
 * @since 2019/4/21
 */
public class QuictSort {

    public static void main(String[] args) {
        int[] aa = {1,6,3,4,6,7,8};
        quickSort(aa,0,aa.length-1);
        for (int a : aa) {
            System.out.print(a+" ");
        }
    }

    private static void quickSort(int[] aa, int left, int right) {
        if (aa == null || aa.length <=1 || left>=right) {
            return;
        }
        int mid = partition(aa,left,right);
        quickSort(aa,mid+1,right);
        quickSort(aa,left,mid);
    }

    private static int partition(int[] aa, int left, int right) {
        int mid = aa[left];
        while(left<right){
            while(mid<=aa[right] && left<right){
                right--;
            }
            if (left<right) {
                aa[left] = aa[right];
                left++;
            }
            while(mid>=aa[left] && left<right){
                left++;
            }
            if (left<right) {
                aa[right] = aa[left];
                right--;
            }
        }
        aa[left] = mid;
        return left;
    }
}
