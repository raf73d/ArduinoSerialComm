package be.vdab.arduinoserialcomm;

import com.fazecast.jSerialComm.SerialPort;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Scanner;
@Service
public class SerialService {
    private SerialPort port;

@EventListener(ApplicationReadyEvent.class)
public void init() throws Exception {
        port = SerialPort.getCommPort("COM6");
        port.setBaudRate(9600);
        port.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
        if (port.openPort()) {
            System.out.println("Poort geopenend");
            Thread.sleep(5000);
            OutputStream out = port.getOutputStream();
            out.write("GeefNaam\n".getBytes());
            out.flush();
            System.out.println("Java-Service vraag naam");
            BufferedReader reader = new BufferedReader(new InputStreamReader(port.getInputStream()));
            String response = reader.readLine();
            System.out.println("Arduino antwoordt: " + response);
        } else {
            System.out.println("Kon de poort niet openen");
        }
    }
}
