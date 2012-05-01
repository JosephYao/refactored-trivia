package com.adaptionsoft.games.uglytrivia.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	TestGameAdd.class,
	TestGameRoll.class,
	TestGameWrongAnswer.class,
	TestGameWasCorrectlyAnswered.class,
	AllTestsForGameQuestions.class,
	TestGamePlayers.class
})
public class AllTests {

}
