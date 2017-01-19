package mqtt.raspbery;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import java.util.Date;

public class Main implements MqttCallback {

    private MqttClient  client = new MqttClient("tcp://localhost:1883", "Sending");
    private final String topic = "JavaMqttLover";

    private Main() throws MqttException {
    }

    public static void main(String[] args) {
        try {
            new Main().doDemo();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    private void doDemo() {
        try {

            client.connect();
            client.setCallback(this);
            client.subscribe(topic);
            MqttMessage message = new MqttMessage();
            message.setPayload("A single message from my computer fff"
                    .getBytes());
            client.publish(topic, message);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        // TODO Auto-generated method stub

    }

    @Override
    public void messageArrived(String topic, MqttMessage message)
            throws Exception {
        System.out.println(message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }

}