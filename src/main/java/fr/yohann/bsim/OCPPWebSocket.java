package fr.yohann.bsim;

import java.util.concurrent.CompletionStage;

public class OCPPWebSocket implements java.net.http.WebSocket.Listener
{

    @Override
    public void onOpen(java.net.http.WebSocket webSocket) {

    }

    @Override
    public CompletionStage<?> onText(java.net.http.WebSocket webSocket, CharSequence data, boolean last) {
        return null;
    }

    @Override
    public CompletionStage<?> onClose(java.net.http.WebSocket webSocket, int statusCode, String reason) {
        return null;
    }

    @Override
    public void onError(java.net.http.WebSocket webSocket, Throwable error) {

    }
}
