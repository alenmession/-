public class _03ÈıÑòÏ×Èğ {
  public static void main(String[] args) {
    for (int b = 2; b < 9; ++b) {
      for (int d = 2; d < 9; ++d) {
        if (b == d) continue;
        for (int g = 2; g < 9; ++g) {
          if (g == b || g == d) continue;
          int c = b + 1;
          if (c == b || c == d || c == g) continue;
          if (c + g <= 10) continue;
/*
      a b c d
  +   e f g b
-------------------
    e f c b i
   e=1,a=9,f=0,c=b+1,c+g>10
   */
          int sum = 9000 + b * 100 + c * 10 + d + 1000 + g * 10 + b;
          for (int i = 2; i < 9; ++i) {
            if (i == b || i == d || i == g || i == c) continue;
            if (sum == 10000 + c * 100 + b * 10 + i) {
              System.out.printf("%2d%d%d%d\n", 9, b, c, d);
              System.out.printf("%2d%d%d%d\n", 1, 0, g, b);
              System.out.printf("%d\n", sum);
              System.out.printf("---------\n");
            }
          }

        }
      }
    }

  }
}
