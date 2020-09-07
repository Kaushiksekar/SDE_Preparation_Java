package com.tutorials.springboot;

import com.tutorials.springboot.domain.Events;
import com.tutorials.springboot.domain.States;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;

@SpringBootTest
class SpringStateMachineExampleApplicationTests {

	@Autowired
	private StateMachine<States, Events> stateMachine;

	@Test
	void initTest() {

		Assertions.assertEquals(stateMachine.getState().getId(), States.BACKLOG);
		Assertions.assertNotNull(stateMachine);
	}

	@Test
	void testGreenFlow() {
		stateMachine.sendEvent(Events.START_FEATURE);
		stateMachine.sendEvent(Events.FINISH_FEATURE);
		stateMachine.sendEvent(Events.QA_TEAM_APPROVE);
		Assertions.assertEquals(stateMachine.getState().getId(), States.DONE);
	}

	@Test
	void testWrongWay() {
		stateMachine.sendEvent(Events.START_FEATURE);
		stateMachine.sendEvent(Events.QA_TEAM_APPROVE);
		Assertions.assertEquals(stateMachine.getState().getId(), States.IN_PROGRESS);
	}

}
