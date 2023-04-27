import java.util.Scanner;
import java.util.Stack;

public class SkyscraperConstruction {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of floors in the building:");
        int n = sc.nextInt();
        int[] floors = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the floor size given on day " + (i+1) + ":");
            floors[i] = sc.nextInt();
        }
        sc.close();
        
        Stack<Integer> stack = new Stack<Integer>();
        int currentFloor = 0;
        for (int i = 0; i < n; i++) {
            if (floors[i] > currentFloor) {
                for (int j = currentFloor+1; j < floors[i]; j++) {
                    System.out.println();
                }
                currentFloor = floors[i];
            }
            stack.push(floors[i]);
            while (!stack.empty() && stack.peek() == currentFloor) {
                System.out.print(stack.pop() + " ");
                currentFloor--;
            }
            System.out.println();
        }
    }
}