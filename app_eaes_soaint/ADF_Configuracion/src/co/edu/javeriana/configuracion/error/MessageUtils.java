package co.edu.javeriana.configuracion.error;

import co.edu.javeriana.configuracion.utils.BundleUtil;

import co.edu.javeriana.configuracion.utils.error.ProcessError;

import co.edu.javeriana.configuracion.utils.error.ProcessError;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MessageUtils implements Serializable{
    @SuppressWarnings("compatibility:-7032184438660535596")
    private static final long serialVersionUID = 1L;
    public static final Integer TYPE_MSJ_INFO=1;
    public static final Integer TYPE_MSJ_WARNING=2;
    public static final String MSJ_OBLIGATORIO="Los siguientes campos son requeridos:";
    private ProcessError process;
    private List<String> listaCampos;
    private List<MensajeTipificado> mensajes;
    private Boolean error;
    private Boolean msj;
    public MessageUtils() {
        super();
        this.process= new ProcessError();
    }
    public Boolean error() {
        return error;
    }
    public Boolean msj() {
        return msj;
    }
    public void clean(){
        if(this.listaCampos!=null){
            this.listaCampos.clear();
        }
        if(this.mensajes!=null){
            this.mensajes.clear();
        }
        this.error=Boolean.FALSE;
        this.msj=Boolean.FALSE;
    }
    public void addMessageWithType(final String variable,final String key,final Integer type){
        if(this.mensajes==null){
            this.mensajes= new ArrayList<MensajeTipificado>();
        }
        this.mensajes.add(new MensajeTipificado(type,BundleUtil.getString(variable, key)));
        this.msj=Boolean.TRUE;
    }
    public void addMessageWithType(final String msj,final Integer type){
        if(this.mensajes==null){
            this.mensajes= new ArrayList<MensajeTipificado>();
        }
        this.mensajes.add(new MensajeTipificado(type,msj));
        this.msj=Boolean.TRUE;
    }
    public void agregarCampoObligatorio(String variable,String key){
        if(this.listaCampos==null){
            this.listaCampos= new ArrayList<String>();
        }
        String label = BundleUtil.getString(variable, key).replace(":", "");
        this.listaCampos.add(label);
        this.error=Boolean.TRUE;
    }
    
    public String[] getMessage(){
        String[] res= new String[2];
        StringBuilder inf= new StringBuilder ("");
        StringBuilder warning= new StringBuilder ("");
        Iterator<MensajeTipificado> it=this.mensajes.iterator();
        while(it.hasNext()){
            MensajeTipificado item=it.next();
            if(item.getTipo().equals(MessageUtils.TYPE_MSJ_INFO)){
                inf.append(item.getMsj()+"<br/>");
            }
            if(item.getTipo().equals(MessageUtils.TYPE_MSJ_WARNING)){
                warning.append(item.getMsj()+"<br/>");
            }
        }
        res[0]=inf.toString();
        res[1]=warning.toString();
        return res;
    }
    public void process(){
        this.process.process(this);
    }
    public String getListMessage(){
        StringBuilder res= new StringBuilder ("<p>"+MessageUtils.MSJ_OBLIGATORIO+"</p>");
        Iterator<String> it=this.listaCampos.iterator();
        while(it.hasNext()){
            String tmp=it.next();
            res.append(tmp+"<br/>");
        }
        return res.toString();
    }

    public void setProcess(ProcessError process) {
        this.process = process;
    }

    public ProcessError getProcess() {
        return process;
    }
}
