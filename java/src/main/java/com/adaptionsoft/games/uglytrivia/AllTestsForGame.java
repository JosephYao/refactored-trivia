package com.adaptionsoft.games.uglytrivia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestGameInitialization.class,
	TestGameAdd.class,
	TestGameRoll.class,
	TestGameInternalRollWhenNotInPenaltyBox.class
})
public class AllTestsForGame {

}
