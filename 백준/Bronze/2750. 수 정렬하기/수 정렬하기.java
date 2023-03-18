import java.util.Scanner;

public class Main {

    private static final int MIN_RUN = 8;
    private static int[] numList;
    private static int[] buf;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();

            numList = new int[nums];
            buf = new int[nums];
            for (int n = 0; n < nums; n++) numList[n] = sc.nextInt();

            timSort(nums);

            for(int n : numList) System.out.println(n);
        
    }

    private static void timSort(int len) {
        if(len < 2) return;

        int minRun = minRunLength(MIN_RUN, len);

        for (int i = 0; i < len; i += minRun)
            insertSort(i, Math.min(i + minRun - 1, len - 1));

        for (int run = minRun; run < len; run *= 2) {
            for (int start = 0; start < len; start += run*2) {
                int mid = start + run - 1;
                int end = Math.min(start + run*2 - 1, len - 1);
                if(mid < end) merge(start, mid, end);
            }
        }
    }

    private static int minRunLength(int minMerge, int len) {
        int r = 0;
        while (len >= minMerge) {
            r |= len & 1;
            len >>= 1;
        }
        return len + r;
    }

    private static void insertSort(int start, int end) {
        for (int now = start + 1; now <= end; now++) {
            int temp = numList[now];
            int compare = now - 1;

            while (compare >= start && numList[compare] > temp) {
                numList[compare + 1] = numList[compare];
                compare--;
            }
            numList[compare + 1] = temp;
        }
    }

    private static void merge(int start, int mid, int end) {
        int s = start;
        int m = mid+1;
        int n = start;

        while(s <= mid && m <= end) {
            if(numList[s] <= numList[m]) buf[n++] = numList[s++];
            else buf[n++] = numList[m++];
        }

        if(s > mid) {
            for (int i = m; i <= end; i++)
                buf[n++] = numList[m++];
        } else {
            for (int i = s; i <= mid; i++)
                buf[n++] = numList[s++];
        }

        System.arraycopy(buf, start, numList, start, end + 1 - start);
    }
}