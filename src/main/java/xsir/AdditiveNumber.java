package xsir;

public class AdditiveNumber {
    public static boolean isAdditiveNumber(String num) {
        if (num == null || num.length() < 3) {
            return false;
        }
        for (int i = 0; i < num.length() - 2; i++) {
            for (int j = i + 2; j < num.length(); j++) {
                String first = num.substring(0, i + 1);
                String second = num.substring(i + 1, j);
                if (first.length() > 1 && first.charAt(0) == '0') {
                    continue;
                }
                if (second.length() > 1 && second.charAt(0) == '0') {
                    continue;
                }
                if (isAdditive(num.substring(j), first, second)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isAdditive(String num, String first, String second) {
        if (num.isEmpty()) {
            return true;
        }
        String target = String.valueOf(Long.valueOf(first) + Long.valueOf(second));
        if (target.length() > num.length()) {
            return false;
        }
        for (int i = 0; i < target.length(); i++) {
            if (num.charAt(i) != target.charAt(i)) {
                return false;
            }
        }
        return isAdditive(num.substring(target.length()), second, target);
    }

    public static void main(String[] args) {
        System.out.println(isAdditiveNumber("198019823962"));
    }
}
