package co.edu.javeriana.configuracion.conf.bean.configuracion;

public class OSBConf {
    private String host;
    private String port;
    private String protocol;
    
    public OSBConf() {
        super();
    }

    public void setHost(final String host) {
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public void setPort(final String port) {
        this.port = port;
    }

    public String getPort() {
        return port;
    }

    public void setProtocol(final String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }
}
