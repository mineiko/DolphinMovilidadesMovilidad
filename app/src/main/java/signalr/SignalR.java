package signalr;

import android.content.Context;

import java.util.concurrent.ExecutionException;

import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler1;

/**
 * Created by Gianella Milon on 21/06/2017.
 */

public class SignalR {

    public interface OnMensajeRecibidoListener{
        void MensajeRecibido(String msg);
    }

    // Hub connection
    public static HubConnection mHubConnection;
    public static HubProxy mHubProxy;
    private static Context context;
    public static String mConnectionID;

    public static OnMensajeRecibidoListener listener;

    public SignalR(Context context){
        this.context = context;
    }

    public static void startSignalR(){
        try {
            Platform.loadPlatformComponent(new AndroidPlatformComponent());
            mHubConnection = new HubConnection("http://movilidadessignalr20170616114841.azurewebsites.net/realtime");
            mHubProxy = mHubConnection.createHubProxy("MovilidadesHub");
            //ClientTransport clientTransport = new ServerSentEventsTransport(mHubConnection.getLogger());
            SignalRFuture<Void> signalRFuture = mHubConnection.start();
            signalRFuture.get();
            mConnectionID = mHubConnection.getConnectionId();

            mHubProxy.on("hello", new SubscriptionHandler1<String>() {//nombre del metodo, interfaz que se va a ejecutar,clase del parametro
                @Override
                public void run(String msg) {
                    //Toast.makeText(context , msg, Toast.LENGTH_SHORT).show();
                    listener.MensajeRecibido(msg);
                    //Log.i("SignalR",msg);
                }
            }, String.class);
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void enviarMensaje(String msg){
        mHubProxy.invoke("Hello", msg);
    }
}
