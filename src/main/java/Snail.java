import java.util.Arrays;
public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        int len = array2d.length;
        int[] returnArr = new int[len * len];
        if (array2d == null){
            return returnArr;
        }


        int top = 0, bottom = len - 1, left = 0, right = len - 1;
        int count = 0;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                returnArr[count] = array2d[top][i];
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                returnArr[count] = array2d[i][right];
                count++;
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    returnArr[count] = array2d[bottom][i];
                    count++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    returnArr[count] = array2d[i][left];
                    count++;
                }
                left++;
            }
        }
        return returnArr;
    }
    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {

        if (array1d == null){
            return new int[0][0];
        }
        int len = array1d.length;
        int[][] returnArr = new int[(int) Math.sqrt(len)][(int) Math.sqrt(len)];


        int top = 0, bottom = len - 1, left = 0, right = len - 1;
        int count = 0;
        while (count < len) {
            for (int i = left; i <= right; i++) {
                returnArr[top][i] = array1d[count];
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                returnArr[top][i] = array1d[count];
                count++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                returnArr[bottom][i] = array1d[count];
                count++;
            }
            bottom--;

            // Traverse left column
            for (int i = bottom; i >= top; i--) {
                returnArr[i][left] = array1d[count];
                count++;
            }
            left++;
        }
        return returnArr;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int i : array1d) {
            System.out.println(i);
        }
    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] a : array2d) {
            print1dArray(a);
        }
    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        return Math.sqrt(array1d.length)-Math.floor(Math.sqrt(array1d.length))==0;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        for (int[] i : array2d) {
            if (i.length!=array2d.length) {
                return false;
            }
        }
        return true;
    }


}
