package com.adaptionsoft.games.trivia.runner.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	TestGoldenMaster.class,
	TestGoldenMasterWithGameRunner.class,
	TestGoldenMasterWithFolder.class
})
public class AllTests {

}
