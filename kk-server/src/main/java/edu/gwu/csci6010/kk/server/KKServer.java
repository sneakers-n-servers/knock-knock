package edu.gwu.csci6010.kk.server;

import edu.gwu.csci6010.kk.object.KKObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("edu.gwu.csci6010.kk")
@EnableJpaRepositories(basePackages = "edu.gwu.csci6010.kk.object")
@EntityScan(basePackages = "edu.gwu.csci6010.kk.object")
public class KKServer implements CommandLineRunner {

    @Autowired
    KKObjectRepository objectRepository;

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        SpringApplication.run(KKServer.class, args);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            KKTaskExecutor taskExecutor = (KKTaskExecutor) ctx.getBean("KKTaskExecutor");
//            taskExecutor.printMessages();
//        };
//    }

    @Override
    public void run(String... args) throws Exception {
//        KKObject kkObject = new KKObject("foo", "bar");
//        objectRepository.save(kkObject);
//        for (KKObject kk : objectRepository.findAll()) {
//            System.out.println(kk.toString());
//        }

        ServerSocket serverSocket = new ServerSocket(1928);
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream());
        BufferedReader in = new BufferedReader(inputStreamReader);

        KKTaskExecutor taskExecutor = (KKTaskExecutor) context.getBean("KKTaskExecutor");



//        try (ServerSocket serverSocket = new ServerSocket(1511);
//             Socket clientSocket = serverSocket.accept();
//             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
//             InputStreamReader inputStreamReader = new InputStreamReader(clientSocket.getInputStream();
//             BufferedReader in = new BufferedReader(inputStreamReader);
//        ) {
//
//            String inputLine, outputLine;
//
//            // Initiate conversation with client
//            KnockKnockProtocol kkp = new KnockKnockProtocol();
//            outputLine = kkp.processInput(null);
//            out.println(outputLine);
//
//            while ((inputLine = in.readLine()) != null) {
//                outputLine = kkp.processInput(inputLine);
//                out.println(outputLine);
//                if (outputLine.equals("Bye."))
//                    break;
//            }
//        } catch (IOException e) {
//            System.out.println("Exception caught when trying to listen on port "
//                    + 1511 + " or listening for a connection");
//            System.out.println(e.getMessage());
//        }
    }


}
