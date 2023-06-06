package day0605;

public class YangHui {
    public static void main(String[] args) {
        int[][] tri = new int[10][];

        for (int i = 0; i < 10; i++) {
            tri[i] = new int[i+1];
            tri[i][0] = 1;
            tri[i][i] = 1;
            for (int j = 1; j < i; j++) {
                tri[i][j] = tri[i - 1][j] + tri[i - 1][j - 1];
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(tri[i][j] + " ");
            }
            System.out.println();
        }
    }
}
