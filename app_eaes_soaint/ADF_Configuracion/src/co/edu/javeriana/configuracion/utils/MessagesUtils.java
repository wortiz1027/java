package co.edu.javeriana.configuracion.utils;

public class MessagesUtils {
    
    private Boolean display;
    private String  message;

    public MessagesUtils() {
        super();
    }

    public void clearMessages(){
        setDisplay(false);
        setMessage("");
    }
    
    public void addMessages(final String newMessage){
        setDisplay(true);
        setMessage(getMessage()+newMessage+".~");
    }
    
    public void addMessagesMandatoryFromBundle(final String bundlePath,final String bundle,final String bundleValidation){
        setDisplay(true);
        setMessage(getMessage()+"<b>"+ JsfUtils.getStringFromBundle(bundlePath,bundle)+"</b> "+JsfUtils.getStringFromBundle(bundlePath,bundleValidation)+".~");
    }
    
    public void addMessagesMandatoryFromBundle(final String bundlePath,final String bundleFrag,final String bundle,final String bundleValidation){
        setDisplay(true);
        setMessage(getMessage()+"<b>("+JsfUtils.getStringFromBundle(bundlePath,bundleFrag)+")</b> "+"<b>"+JsfUtils.getStringFromBundle(bundlePath,bundle)+"</b> "+JsfUtils.getStringFromBundle(bundlePath,bundleValidation)+".~");
    }
    
    public void addMessagesFromBundle(final String bundlePath,final String bundleFrag,final String bundle){
        setDisplay(true);
        setMessage(getMessage()+"<b>("+JsfUtils.getStringFromBundle(bundlePath,bundleFrag)+")</b> "+"<b>"+JsfUtils.getStringFromBundle(bundlePath,bundle)+"</b>.~");
    }

    public void setDisplay(final Boolean display) {
        this.display = display;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
