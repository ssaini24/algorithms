package meetingRoomsII;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MeetingRoomsII {

  public static void main() {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter No of rows:");
    Integer userInputRows = Integer.valueOf(myObj.nextLine());
    System.out.println("Enter " + userInputRows * 2 + "  values");

    int[][] twoDArray = new int[userInputRows][2];

    for (int i = 0; i < userInputRows; i++) {
      System.out.println("Enter First value:");
      Integer firstValue = Integer.valueOf(myObj.nextLine());

      System.out.println("Enter Second Value:");
      Integer secondValue = Integer.valueOf(myObj.nextLine());

      twoDArray[i] = new int[]{firstValue, secondValue};
    }

    Integer requiredMeetingRooms = mainLogic(twoDArray);
    System.out.println(requiredMeetingRooms);
  }

  private static Integer mainLogic(int[][] twoDArray) {
    Arrays.sort(twoDArray, (int[] a, int[] b) -> a[0] - b[0]);
    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (int[] a1, int[] a2) -> Integer.compare(a1[1], a2[1])
    );

    pq.add(twoDArray[0]);
    for (int i = 1; i < twoDArray.length; i++) {
      int[] peek = pq.peek();
      if (twoDArray[i][0] > peek[1]) {
        pq.poll();
      }

      pq.add(twoDArray[i]);
    }

    return pq.size();
  }
}
