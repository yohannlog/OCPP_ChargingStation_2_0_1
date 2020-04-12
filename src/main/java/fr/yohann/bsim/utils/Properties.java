package fr.yohann.bsim.utils;

import com.google.gson.annotations.SerializedName;

public class Properties {
    private transient Runnable onPropertyUpdated;

    @SerializedName("ip")
    private String ip;

    @SerializedName("port")
    private int port;

    @SerializedName("exp")
    private String exp;

    @SerializedName("key")
    private String key;

    @SerializedName("url")
    private String url;

    public String getIp() { return ip; }
    public void setPort(int port) {
        this.port = port;
        onPropertyUpdated.run();
    }

    public String getRef() { return ref; }
    public void setIp(String ip) {
        this.ip = ip;
        onPropertyUpdated.run();
    }

    public String getExp() { return exp; }
    public void setExp(String value) {
        exp = value;
        onPropertyUpdated.run();
    }

    public String getKey() { return key; }
    public void setKey(String value) {
        key = value;
        onPropertyUpdated.run();
    }

    public String getUrl() { return url; }
    public void setUrl(String value) {
        url = value;
        onPropertyUpdated.run();
    }

    Properties(){
        this.onPropertyUpdated = Configuration::updateProperties;
    }

    Properties(String acc, String ref, String exp, String key, String url) {
        this.onPropertyUpdated = Configuration::updateProperties;
        this.acc = acc;
        this.ref = ref;
        this.exp = exp;
        this.key = key;
        this.url = url;
    }
}
