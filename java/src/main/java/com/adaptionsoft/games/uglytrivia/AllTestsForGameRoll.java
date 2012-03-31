package com.adaptionsoft.games.uglytrivia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestsForRoll.class,
	TestsForInternalRollWhenNotInPenaltyBox.class,
	TestGameInternalRollWhenInPenaltyBox.class
})
public class AllTestsForGameRoll {

}
