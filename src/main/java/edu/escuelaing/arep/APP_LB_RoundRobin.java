package edu.escuelaing.arep;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.PriorityQueue;

public class APP_LB_RoundRobin {
    private final PriorityQueue  cola = new PriorityQueue<>();

    String URLE1 = "http://http://ec2-184-72-215-232.compute-1.amazonaws.com:34001/";
    String URLE2 = "http://ec2-34-227-27-239.compute-1.amazonaws.com:34002/";
    String respu = "";

    public APP_LB_RoundRobin() {
        cola.add(URLE1);
        cola.add(URLE2);
    }

    private String turnoCola() {
        String ADDI = (String) cola.poll();
        cola.add(ADDI);
        return ADDI;
    }

    public String enviaratan (Double doublev){
        try {
            URL URLE = new URL(turnoCola()+"/atan?value="+doublev);
            HttpURLConnection conecionG = (HttpURLConnection) URLE.openConnection();
            conecionG.setRequestMethod("GET");
            if (conecionG.getResponseCode() != 200) {
                throw new RuntimeException("Fallo");
            }
            InputStreamReader in = new InputStreamReader(conecionG.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                respu =  output;
            }
            conecionG.disconnect();

        } catch (Exception e) {
            System.out.println("Error al conectar");
        }
        return respu;
    }

    public String enviarsqrt (Double doublep){
        try {
            URL URLEs = new URL(turnoCola()+"/sqrt?value="+doublep);
            HttpURLConnection conecionG = (HttpURLConnection) URLEs.openConnection();
            conecionG.setRequestMethod("GET");
            if (conecionG.getResponseCode() != 200) {
                throw new RuntimeException("Fallo");
            }
            InputStreamReader in = new InputStreamReader(conecionG.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                respu =  output;
            }

            conecionG.disconnect();

        } catch (Exception e) {
            System.out.println("Error al conectar");
        }
        return respu;
    }
}
