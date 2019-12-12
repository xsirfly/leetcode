package xsir;

public class RectangleArea {
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int w1 = C - A, w2 = G - E;
        int h1 = D - B, h2 = H - F;

        int area1 = w1 * h1, area2 = w2 * h2;

        if ((long)(w1 + w2) <= Math.max((long)C, (long)G) - Math.min((long)A, (long)E)) {
            return area1 + area2;
        }

        if ((long)(h1 + h2) <= Math.max((long)D, (long)H) - Math.min((long)B, (long)F)) {
            return area1 + area2;
        }

        return area1 + area2 - ((Math.max(C, G) - Math.min(A, E) - w1 - w2) * (Math.max(D, H) - Math.min(B, F) - h1 - h2));
    }

    public static void main(String[] args) {
        System.out.println(computeArea(-1500000001 ,0, -1500000000 ,1 ,1500000000 ,0 ,1500000001 ,1));
    }
}
