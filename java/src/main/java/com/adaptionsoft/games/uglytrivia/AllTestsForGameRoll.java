package com.adaptionsoft.games.uglytrivia;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestGameRollWhenNotInPenaltyBox.class,
	TestGameIsGettingOutOfPenaltyBoxWithRoll.class,
	TestGameRoll.class,
	TestGameRollOutputMessage.class
})
public class AllTestsForGameRoll {

}
