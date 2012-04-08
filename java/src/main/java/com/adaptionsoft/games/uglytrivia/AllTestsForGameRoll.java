package com.adaptionsoft.games.uglytrivia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestGameRollWhenNotInPenaltyBox.class,
	TestGameRollWhenNotInPenaltyBoxOutputMessage.class,
	TestGameIsGettingOutOfPenaltyBoxWithRollOutputMessage.class,
	TestGameRoll.class,
	TestGameRollOutputMessage.class
})
public class AllTestsForGameRoll {

}
