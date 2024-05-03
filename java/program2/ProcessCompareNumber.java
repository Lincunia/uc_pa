package program2;

/*
 * NOTE: This code is horrible, you may do it better than this. The reason why
 * I put that thing right there is because the code is a reference of how
 * my Sir wants me to write (my Sir has a nasty code taste)
 */

public class ProcessCompareNumber {
  private Print imp;
  ProcessCompareNumber() { imp = new Print(); }
  public void compareTheNumbers(int A, int B, int C) {
    if (A > B) {
      if (B > C)
        imp.printIt(A, B, C);
      else {
        if (A > C)
          imp.printIt(A, C, B);
        else {
          imp.printIt(C, A, B);
        }
      }
    } else {
      if (A > C)
        imp.printIt(B, A, C);
      else {
        if (B > C)
          imp.printIt(B, C, A);
        else {
          imp.printIt(C, B, A);
        }
      }
    }
  }
}
