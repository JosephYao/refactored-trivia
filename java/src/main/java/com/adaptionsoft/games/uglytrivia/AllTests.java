package com.adaptionsoft.games.uglytrivia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.adaptionsoft.games.uglytrivia.test.AllTestsForGameQuestions;
import com.adaptionsoft.games.uglytrivia.test.TestGameAdd;
import com.adaptionsoft.games.uglytrivia.test.TestGameRoll;

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
