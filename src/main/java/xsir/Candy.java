package xsir;

public class Candy {

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        if (ratings.length == 1) {
            return 1;
        }
        int sum = 1;
        int cnt = 0;
        int last = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i - 1]) {
                if (cnt > 0) {
                    sum = sum + (cnt * (cnt + 1) / 2);
                    if (cnt >= last) {
                        sum = sum + cnt - last + 1;
                    }
                    cnt = 0;
                    last = 1;
                }
                last = ratings[i] == ratings[i - 1] ? 1 : last + 1;
                sum += last;
            } else {
                cnt++;
            }
        }
        if (cnt > 0) {
            sum = sum + (cnt * (cnt + 1) / 2);
            if (cnt >= last) {
                sum = sum + cnt - last + 1;
            }
        }
        return sum;
    }

//    private static int candy(int[] ratings, int cur, int last, int sum) {
//        if (cur >= ratings.length) {
//            return sum;
//        }
//        int newSum = -1;
//        int step = 1;
//        if (ratings[cur] > ratings[cur - 1]) {
//            while (newSum == -1) {
//                newSum = candy(ratings, cur + 1, last + step, sum + last + step);
//                step++;
//            }
//        } else if (ratings[cur] == ratings[cur - 1]){
//            while (newSum == -1) {
//                newSum = candy(ratings, cur + 1, step, sum + step);
//                step++;
//            }
//        } else {
//            while (newSum == -1 && step < last) {
//                newSum = candy(ratings, cur + 1, step, sum + step);
//                step++;
//            }
//        }
//        return newSum;
//    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1, 3, 2, 2, 1}));
    }
}
