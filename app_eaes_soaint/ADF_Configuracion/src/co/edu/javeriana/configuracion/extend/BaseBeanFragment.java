package co.edu.javeriana.configuracion.extend;

import co.edu.javeriana.configuracion.utils.RenderedFragment;

import co.edu.javeriana.configuracion.utils.JsfUtils;

import co.edu.javeriana.configuracion.utils.error.ProcessError;

import java.io.Serializable;

public abstract class BaseBeanFragment implements Serializable {
    @SuppressWarnings("compatibility:5929542354054215963")
    private static final long serialVersionUID = 1L;
    protected RenderedFragment renderedFragment;

    public void setRenderedFragment(final RenderedFragment renderedFragment) {
        this.renderedFragment = renderedFragment;
    }

    public RenderedFragment getRenderedFragment() {
        return renderedFragment;
    }

    public BaseBeanFragment() {
        super();
        this.renderedFragment = (RenderedFragment) JsfUtils.resolveExpression("#{pageFlowScope.rendered}");
        if (this.renderedFragment == null) {
            this.renderedFragment = new RenderedFragment();
        }
        try{
            this.initializeVariables();
            this.initializeServices();
        }catch(Exception e){
            final ProcessError pro= new ProcessError();
            pro.setMethodCode(ProcessError.MethodIdentifier.M01.getID());
            pro.process(e, this);
        }
    }
    public BaseBackingBean getBackingBean() {
        return (BaseBackingBean)JsfUtils.resolveExp("#{backingBeanScope.backingBean}");
    }
    public abstract void initializeVariables();
    public abstract void initializeServices();
}
