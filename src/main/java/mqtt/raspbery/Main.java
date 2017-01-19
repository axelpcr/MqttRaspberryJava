package mqtt.raspbery;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main implements MqttCallback {

    private MqttClient client;
    private final String topic = "JavaMqttLover";

    private Main() {
    }

    public static void main(String[] args) {
        new Main().doDemo();
    }

    private void doDemo() {
        while(true) {
            try {
                client = new MqttClient("tcp://localhost:1883", "Sending");
                client.connect();
                client.setCallback(this);
                MqttMessage mqttMessageDate = new MqttMessage(new Date().toString().getBytes());
                String topic = "JavaMqttLover";
                client.publish(topic, mqttMessageDate);
                TimeUnit.SECONDS.sleep(1);
            } catch (MqttPersistenceException e) {
                e.printStackTrace();
            } catch (MqttSecurityException e) {
                e.printStackTrace();
            } catch (MqttException e) {
                System.out.println("Rien à foutre");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void connectionLost(Throwable cause) {
        // TODO Auto-generated method stub

    }

    public void messageArrived(String topic, MqttMessage message)
            throws Exception {
        System.out.println(message);
    }

    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }

}