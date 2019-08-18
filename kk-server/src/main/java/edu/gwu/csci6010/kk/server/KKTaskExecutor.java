package edu.gwu.csci6010.kk.server;


import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class KKTaskExecutor implements ApplicationContextAware {

    @Autowired
    private TaskExecutor taskExecutor;
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public void printMessages() {
        for (int i = 0; i < 15; i++) {
            taskExecutor.execute(applicationContext.getBean(KKTask.class, "Message" + i));
        }
    }
}
