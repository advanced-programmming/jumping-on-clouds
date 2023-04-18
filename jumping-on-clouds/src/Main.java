import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> c = List.of(0, 0, 1, 0, 0, 1, 0);
        //List<Integer> c = List.of(0, 1, 0, 0, 0, 1, 0);
        //List<Integer> c = List.of(0, 0, 0, 0, 1, 0);
        //List<Integer> c = List.of(0, 0, 0, 1, 0, 0);
        int res = jumpingOnClouds(c);
        System.out.printf(String.valueOf(res));
    }

    public static int jumpingOnClouds(List<Integer> c) {
        return jumpToPos(c, 0, 1, 2, 0);
    }

    public static int jumpToPos(List<Integer> c, int curr, int next, int nextNext, int val) {
        int res = 1;
        if (next < c.size()) {
            int currVal = c.get(curr);
            int nextVal = c.get(next);
            int nextNextVal = nextNext >= c.size() ? 1 : c.get(nextNext);
            if ((currVal == 0 && nextVal == 0 && nextNextVal == 0) || (currVal == 0 && nextVal == 1 && nextNextVal == 0))
                res = 0;

            if (res == 1) {
                val = jumpToPos(c, next, nextNext, nextNext + 1, val + 1);
            }

            if (res == 0) {
                val = jumpToPos(c, nextNext, nextNext + 1, nextNext + 2, val + 1);
            }
        }

        return val;
    }

    public static int jumpingOnClouds2(List<Integer> c) {
        int count = 0;
        for (int i = 0; i < c.size() - 1; i++) {
            count++;
            if ((i + 2) < c.size() && c.get(i + 2) == 0) i++;
        }
        return count;
    }
}