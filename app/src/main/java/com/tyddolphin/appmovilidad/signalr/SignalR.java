package com.tyddolphin.appmovilidad.signalr;

import android.content.Context;

import com.tyddolphin.appmovilidad.rest.Ubicacion;

import java.util.concurrent.ExecutionException;

import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler1;

/**
 * @author Alexis
 */

public class SignalR {

    //public interface OnNuevaUbicacionMovilidadListener{
    //    void OnUbicacionRecibida(Ubicacion ubicacion);
    //}

    public HubConnection mHubConnection;
    public HubProxy mHubProxy;
    private Context context;
    public static String mConnectionID;

    //public OnNuevaUbicacionMovilidadListener listener;

    public SignalR(Context context){
        this.context = context;
    }

    public void startSignalR(){
        try {
            Platform.loadPlatformComponent(new AndroidPlatformComponent());
            mHubConnection = new HubConnection("http://movilidadessignalr20170616114841.azurewebsites.net/realtime");
            mHubProxy = mHubConnection.createHubProxy("MovilidadesHub");
            //ClientTransport clientTransport = new ServerSentEventsTransport(mHubConnection.getLogger());
            SignalRFuture<Void> signalRFuture = mHubConnection.start();
            signalRFuture.get();
            mConnectionID = mHubConnection.getConnectionId();

            /*mHubProxy.on("Ubicacion", new SubscriptionHandler1<Ubicacion>() {//nombre del metodo, interfaz que se va a ejecutar,clase del parametro
                @Override
                public void run(Ubicacion ubicacion) {
                    listener.OnUbicacionRecibida(ubicacion);
                }
            }, Ubicacion.class);*/
        }catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public void NuevaUbicacion(Ubicacion ubicacion)
    {
        mHubProxy.invoke("NuevaUbicacion", ubicacion);
    }
}
