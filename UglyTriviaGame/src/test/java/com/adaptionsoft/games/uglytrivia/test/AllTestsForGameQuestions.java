package com.adaptionsoft.games.uglytrivia.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({
	TestGameQuestionsOutputMessage.class,
	TestGameQuestionsSizeOfQuestion.class,
	TestGameQuestionsInitialization.class,
	TestGameQuestionsCurrentCategory.class
})
public class AllTestsForGameQuestions {

}
