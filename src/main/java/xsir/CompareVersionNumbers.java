package xsir;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int cur1 = 0, cur2 = 0, res;
        String p1, p2;
        while (cur1 < v1.length || cur2 < v2.length) {
            p1 = cur1 >= v1.length ? "0" : v1[cur1];
            p2 = cur2 >= v2.length ? "0" : v2[cur2];
            res = compare(p1, p2);
            if (res != 0) {
                return res;
            }
            cur1++;
            cur2++;
        }
        return 0;
    }

    private static int compare(String p1, String p2) {
        int cur1 = 0, cur2 = 0;
        while (cur1 < p1.length() || cur2 < p2.length()) {
            if (cur1 < p1.length() && p1.charAt(cur1) == '0') {
                cur1++;
                continue;
            }
            if (cur2 < p2.length() && p2.charAt(cur2) == '0') {
                cur2++;
                continue;
            }
            if (p1.length() - cur1 > p2.length() - cur2) {
                return 1;
            } else if (p1.length() - cur1 < p2.length() - cur2) {
                return -1;
            }
            if (cur1 >= p1.length()) {
                return -1;
            }
            if (cur2 >= p2.length()) {
                return 1;
            }
            if (p1.charAt(cur1) > p2.charAt(cur2)) {
                return 1;
            } else if (p1.charAt(cur1) < p2.charAt(cur2)) {
                return -1;
            } else {
                cur1++;
                cur2++;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.3"));
        System.out.println(compareVersion("1.01", "1.001"));
        System.out.println(compareVersion("1.0", "1.0.0"));
    }
}
