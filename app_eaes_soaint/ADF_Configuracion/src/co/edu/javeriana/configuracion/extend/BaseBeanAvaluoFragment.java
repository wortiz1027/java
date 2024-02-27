package co.edu.javeriana.configuracion.extend;

import co.edu.javeriana.configuracion.utils.JsfUtils;

import java.util.Map;

import javax.faces.event.ValueChangeEvent;

public abstract class BaseBeanAvaluoFragment extends BaseBeanFragment {
    @SuppressWarnings("compatibility:3447474605162411194")
    private static final long serialVersionUID = 1L;
    private Map<String,String> campos;

    @SuppressWarnings("unchecked")
    public BaseBeanAvaluoFragment() {
        super();
        this.campos=(Map<String,String>)JsfUtils.resolveExpression("#{pageFlowScope.campos}");
    }
    public void onChangeCampos(ValueChangeEvent valueChangeEvent) {
        System.out.println("onChangeCampos  ");
        final Boolean valor = (Boolean)valueChangeEvent.getNewValue();
        final String id = valueChangeEvent.getComponent().getId().substring(3);
        System.out.println("onChangeCampos  "+id+" "+valor);
        if(valor){
            this.campos.put(id,id);
        }else{
            this.campos.remove(id);
        }  
        
        this.campos.forEach((k,v) -> System.out.println("Key: " + k + ": Value: " + v));
    }

    public void setCampos(Map<String, String> campos) {
        this.campos = campos;
    }

    public Map<String, String> getCampos() {
        return campos;
    }

}
