package com.adaptionsoft.games.uglytrivia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AllTestsForGameRoll.class,
	TestGameWrongAnswer.class,
	TestGameWasCorrectlyAnswered.class,
	TestGameWasCorrectlyAnsweredWhenCurrentPlayerNotInPenaltyBox.class,
	TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox.class,
	TestGameWasCorrectlyAnsweredWhenCurrentPlayerInPenaltyBox_When_Not_isGettingOutOfPenaltyBox.class
})
public class AllTests {

}
