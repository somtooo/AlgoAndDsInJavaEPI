package scoring;

public class Score {

  public static String scoreSolution(int timeToSolve, int didYouNeedHints, int optimalSolutions, int howManyBugs) {
    if ((timeToSolve < 0 | timeToSolve > 5) | (didYouNeedHints < 0 | didYouNeedHints > 5) | (optimalSolutions < 0 | optimalSolutions > 5) | (howManyBugs < 0 | howManyBugs > 5)) {
      throw new IllegalArgumentException("Values must be less than 5 and greater than 0");
    }
    return String.format("The score is %d",(timeToSolve + didYouNeedHints + optimalSolutions + howManyBugs)/4);
  }
}
