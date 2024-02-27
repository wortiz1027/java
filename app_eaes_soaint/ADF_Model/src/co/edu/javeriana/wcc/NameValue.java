package co.edu.javeriana.wcc;

import java.io.Serializable;

public class NameValue implements Serializable {
    @SuppressWarnings("compatibility:7343713284120922036")
    private static final long serialVersionUID = 1L;
    
    private String name;
    private String value;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public NameValue() {
        super();
    }
}
