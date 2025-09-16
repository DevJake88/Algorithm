package study;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 9, 11 }; // 정렬된 배열
        int target = 7;

        int idx = binarySearch(arr, target);
        if (idx != -1) {
            System.out.println("find idx: " + idx);
        } else {
            System.out.println("no value");
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
