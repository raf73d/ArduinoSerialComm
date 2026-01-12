package be.vdab.arduinoserialcomm;

import com.fazecast.jSerialComm.SerialPort;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ArduinoSerialCommApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArduinoSerialCommApplication.class, args);
    }

}
