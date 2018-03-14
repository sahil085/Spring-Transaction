package Q1_and_Q2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TransactionMain {
    public static void main(String[] args) {


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TransactionConfig.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
 //accountService.Add("sahil",6000);

        //accountService.Get("sahil");
       // accountService.Update("sahil",5500);
        accountService.Delete("sahil");
    }
}
