package com.tutorials.springboot.config;

import com.tutorials.springboot.domain.Events;
import com.tutorials.springboot.domain.States;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import java.util.Optional;

//http://antkorwin.com/statemachine/statemachine.html

@Configuration
@EnableStateMachine
public class StateMachineConfig extends EnumStateMachineConfigurerAdapter<States, Events> {

    Logger logger = LoggerFactory.getLogger(StateMachineConfig.class);

    @Override
    public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
        config.withConfiguration()
                .listener(listener()) // this line is only to configure hooks for transitions and errors in case of
                // erroneous order of events
                .autoStartup(true);
    }

    private StateMachineListener<States, Events> listener() {
        return new StateMachineListenerAdapter<States, Events>(){

            @Override
            public void transition(Transition<States, Events> transition) {
                logger.warn("move from: " + ofNullableObject(transition.getSource()) + " to: " +
                        ofNullableObject(transition.getTarget()));
//                System.out.println("move from: " + ofNullableObject(transition.getSource()) + " to: " +
//                        ofNullableObject(transition.getTarget()));
            }

            @Override
            public void eventNotAccepted(Message<Events> event) {
                logger.error("Event not accepted : " + event);
//                System.out.println("Event not accepted : " + event);
            }

            private Object ofNullableObject(State state){ // even initial value of null is a state
                // initially transition happens from null to BACKLOG. To handle the null value above, optional is required
                // in the console : 2020-09-07 23:34:08.099  WARN 1732 --- [           main] c.t.s.config.StateMachineConfig          : move from: null to: BACKLOG
                return Optional.ofNullable(state)
                        .map(State::getId)
                        .orElse(null);
            }
        };
    }

    @Override
    public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
        states.withStates().initial(States.BACKLOG).state(States.IN_PROGRESS)
                .state(States.TESTING, deployAction()) // deployAction is to take some action for a particular state
                .end(States.DONE);
    }

    private Action<States, Events> deployAction(){
        return stateContext -> {
            logger.warn("DEPLOYING : {}", stateContext.getEvent());
        };
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {

        transitions
                .withExternal().source(States.BACKLOG).target(States.IN_PROGRESS).event(Events.START_FEATURE)
                // .guard(checkGuard()) this can be used to check if
                .and()
                .withExternal().source(States.IN_PROGRESS).target(States.TESTING).event(Events.FINISH_FEATURE).and()
                .withExternal().source(States.TESTING).target(States.IN_PROGRESS).event(Events.QA_REJECTED_UC).and()
                .withExternal().source(States.TESTING).target(States.DONE).event(Events.QA_TEAM_APPROVE);
    }
}
