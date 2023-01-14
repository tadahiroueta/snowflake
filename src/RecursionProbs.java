import java.util.Stack;

public class RecursionProbs {
    public double sumReciprocals(int n) {
        if (n == 1) return 1;

        return 1.0 / n + sumReciprocals(n - 1);
    }

    public int productOfEvens(int n) {
        if (n == 1) return 2;

        return 2 * n * productOfEvens(n - 1);
    }

    public String conversation(int num, int base) {
        if (num == 0) return "";
        
        return conversation(num / base, base) + num % base;
    }

    public int matchingDigits(int a, int b) {
        if (a == 0 || b == 0) return (a % 10 == b % 10) ? 1 : 0;

        return ((a % 10 == b % 10) ? 1 : 0) + matchingDigits(a / 10, b / 10);
    }

    public void doubleUp(Stack<Integer> nums) {
        if (nums.isEmpty()) return;
        
        int last = nums.pop();
        doubleUp(nums);
        for (int i = 0; i < 2; i++) nums.push(last);
    }

    public String printThis(int n) {
        if (n == 0) return "";
        if (n == 1 || n == 2) return "*" + printThis(n - 1);

        return "<" + printThis(n - 2) + ">";
    }

    public void printNums2(int n) {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        if (n == 2) {
            System.out.print((n - 1) + " " + (n - 1));
            return;
        }

        System.out.print((n + 1) / 2 + " ");
        printNums2(n - 2);
        System.out.print(" " + (n + 1) / 2);
    }
}
