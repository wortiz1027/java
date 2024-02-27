package co.edu.javeriana.configuracion.extend;

import co.edu.javeriana.configuracion.utils.ReflectionUtil;

import co.edu.javeriana.configuracion.utils.error.ProcessError;

import java.lang.reflect.Field;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import java.util.logging.Level;

import javax.el.ELContext;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.share.logging.ADFLogger;

import oracle.bpel.services.workflow.StaleObjectException;
import oracle.bpel.services.workflow.task.model.Task;
import oracle.bpel.services.workflow.WorkflowException;
import oracle.bpel.services.workflow.client.IWorkflowServiceClient;
import oracle.bpel.services.workflow.client.WorkflowServiceClientFactory;
import oracle.bpel.services.workflow.query.ITaskQueryService;
import oracle.bpel.services.workflow.task.ITaskService;
import oracle.bpel.services.workflow.verification.IWorkflowContext;

import oracle.bpel.services.workflow.worklist.adf.InvokeActionBean;
import oracle.bpel.worklistapp.util.WorklistUtil;

import org.w3c.dom.Element;

/**
* Clase para ser heredada por los Manage Bean que manejen los outcome de proceso
* Creada el 01-02-2014
* @author John D. Silva T.
* @version 1.0
* 
*/

public abstract class AbstractBPMManageBeanBase{
    public static final String TIPO_ACCION_RECHAZO="RECHAZO";
    public static final String TIPO_ACCION_ACEPTAR="ACEPTAR";
    public static final String TIPO_ACCION_APROBAR="APROBAR";
    public static final String TIPO_ACCION_CANCELAR="CANCELAR";
    public static final String TIPO_ACCION_ACTUALIZAR="UPDATE";
    
    public static final String ADF_ACCION_CLOSE="CLOSE";
    public static final String ADF_ACCION_NEW="NEW";
    public static final String ADF_ACCION_NEXT="NEXT";
    public static final String ADF_ACCION_BEFORE="BEFORE";
    public static final String ADF_ACCION_REFRESH="REFRESH";
    public static final String ADF_ACCION_CLOSETF="closeTaskFlow";
    
    public static final String NAVEGACION_FINALIZAR="finalizar";
    public static final String NAVEGACION_ERROR="error";
    public static final String NAVEGACION_CONTINUAR="continuar";
    
    protected Object operationBinding=null;
    protected String accionActivida=null;
    protected String accionCerrar=null;
    
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(AbstractBPMManageBeanBase.class);
    
    public AbstractBPMManageBeanBase(){
        super();
    }
    
    /**
     * Metodo para ser invocado en la clase hija en el cual recorre todos los atributos definidos
     * en la clase hija y de ser clases hijas de BPMBeanBase enlasara los atributos de estas 
     * con los atributos definidos en el Page Definition asociado al Manage Bean.
     * @return Nada.
     */
    
    
    protected void bindPrivatesObjects() {
        LOGGER.begin(Level.FINEST,"AbstractBPMManageBeanBase.bindPrivatesObjects");
        final Field[] attr=this.getClass().getDeclaredFields();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                try{
                    final Object obj= ReflectionUtil.newInstance(temp.getType());
                    if(obj instanceof  BPMBeanBase){
                        final Method method=obj.getClass().getMethod("bindValue");
                        method.setAccessible(true);
                        Object param=null;
                        method.invoke(obj,param);
                        temp.set(this, obj);
                    }
                }catch(ClassNotFoundException e){
                    LOGGER.warning("Error con el campo ClassNotFoundException "+temp.getName()+" - "+e.getMessage());
                }catch(InstantiationException e){
                    LOGGER.warning("Error con el campo InstantiationException "+temp.getName()+" - "+e.getMessage());
                }catch(IllegalAccessException e){
                    LOGGER.warning("Error con el campo IllegalAccessException "+temp.getName()+" - "+e.getMessage());
                }catch(NoSuchMethodException e){
                    LOGGER.warning("Error con el campo NoSuchMethodException "+temp.getName()+" - "+e.getMessage());
                }catch(InvocationTargetException e){
                    LOGGER.warning("Error con el campo InvocationTargetException "+temp.getName()+" - "+e.getMessage());
                }
            }
        }
        LOGGER.end(Level.FINEST,"AbstractBPMManageBeanBase.bindPrivatesObjects");
    }
    
    protected Boolean existe(final Object value){
        final String val=value.toString();
        if(val!=null && !val.equals("") && !val.equals("false")){
            return true;
        }
        return false;
    }

    protected void savePrivatesObjects() {
        LOGGER.begin(Level.FINEST,"AbstractBPMManageBeanBase.savePrivatesObjects");
        final Field[] attr=this.getClass().getDeclaredFields();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                try{
                    final Object obj= ReflectionUtil.newInstance(temp.getType());
                    if(obj instanceof  BPMBeanBase){
                        final Method method=obj.getClass().getMethod("saveBindingValues");
                        method.setAccessible(true);
                        Object param=null;
                        method.invoke(obj,param);
                        temp.set(this, obj);
                    }
                }catch(ClassNotFoundException e){
                    LOGGER.warning("Error con el campo ClassNotFoundException "+temp.getName()+" - "+e.getMessage());
                }catch(InstantiationException e){
                    LOGGER.warning("Error con el campo InstantiationException "+temp.getName()+" - "+e.getMessage());
                }catch(IllegalAccessException e){
                    LOGGER.warning("Error con el campo IllegalAccessException "+temp.getName()+" - "+e.getMessage());
                }catch(NoSuchMethodException e){
                    LOGGER.warning("Error con el campo NoSuchMethodException "+temp.getName()+" - "+e.getMessage());
                }catch(InvocationTargetException e){
                    LOGGER.warning("Error con el campo InvocationTargetException "+temp.getName()+" - "+e.getMessage());
                }
            }
        }
        LOGGER.end(Level.FINEST,"AbstractBPMManageBeanBase.savePrivatesObjects");
    }
    public void modifyBPMPayloadData() throws StaleObjectException,WorkflowException{
        LOGGER.begin(Level.FINEST,"AbstractBPMManageBeanBase.modifyBPMPayloadData");
        final FacesContext context = FacesContext.getCurrentInstance();
        final String tskId = context.getApplication().evaluateExpressionGet(context, "#{pageFlowScope.bpmWorklistTaskId}",  String.class);
        final IWorkflowServiceClient workflowSvcClient =  WorkflowServiceClientFactory.getWorkflowServiceClient(WorkflowServiceClientFactory.REMOTE_CLIENT);
    
        final ITaskService taskSvc = workflowSvcClient .getTaskService();
        final ITaskQueryService wfQueryService =  workflowSvcClient.getTaskQueryService();
        final IWorkflowContext wfContext =   WorklistUtil.getWorkflowContextForASelectedTask();
        final Task myTask= wfQueryService.getTaskDetailsById(wfContext, tskId);
        final Element payloadElem = myTask.getPayloadAsElement();
        myTask.setPayloadAsElement(payloadElem);
        taskSvc .updateTask(wfContext,myTask);
        LOGGER.end(Level.FINEST,"AbstractBPMManageBeanBase.modifyBPMPayloadData");
    }
    /**
     * Este m�todo debe ser implementado en la clase hija.
     * este m�todo se ejecutara justo antes de finalizar la actividad
     * en el no se puede parar la ejecuci�n de la actividad. 
     * @return Nada.
     */
    public abstract void finalizarActionListener(ActionEvent action);
    /**
     * Este m�todo debe ser implementado en la clase hija.
     * este m�todo se ejecutara finalizando la actividad justo despues de finalizarActionListener
     * Este metodo fue creado conla finalidad de validad si la actividad puede finalizar o no. 
     * @return Verdadero para finalizar la actividad o Falso para evitar que finalice la actividad.
     */
    public abstract Boolean finalizarActividad();
    
    public abstract String inicializarManageBean();
    public void saveManageBeanPayload(){};  
    
    private String returnAdfAction(){
        String accion=null;
        if(this.accionCerrar.equalsIgnoreCase(AbstractBPMManageBeanBase.ADF_ACCION_CLOSE)){
            accion="closeTaskFlow";
        }else if(this.accionCerrar.equalsIgnoreCase(AbstractBPMManageBeanBase.ADF_ACCION_NEXT)){
            accion="fetchNextTask";
        }else if(this.accionCerrar.equalsIgnoreCase(AbstractBPMManageBeanBase.ADF_ACCION_NEW)){
            accion="fetchNewTask";
        }else if(this.accionCerrar.equalsIgnoreCase(AbstractBPMManageBeanBase.ADF_ACCION_BEFORE)){
            accion="fetchPreviousTask";
        }else if(this.accionCerrar.equalsIgnoreCase(AbstractBPMManageBeanBase.ADF_ACCION_REFRESH)){
            accion="refreshTaskFlow";
        }
        return accion;
    }
    
    /**
     * Este metodo debe ser colocado en el action del componente ADF que ejecute la acci�n asociada al outcome
     * @return retorna el outcome de la actividad.
     */
    public String myInvokeOperation(){
        LOGGER.begin(Level.FINEST,"AbstractBPMManageBeanBase.myInvokeOperation");
        if(!this.finalizarActividad()){
            return null;
        }
    
        final FacesContext fctx = FacesContext.getCurrentInstance();
        final Application app = fctx.getApplication();
        final ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        final InvokeActionBean invokeActionBean =(InvokeActionBean)app.getELResolver().getValue(elContext,null,"invokeActionBean");
        String retorno=invokeActionBean.invokeOperation();
        LOGGER.info("Retorno de la original actividad ====================> "+retorno);
        
        if(this.accionCerrar!=null && !this.accionCerrar.equals("")){
            retorno=this.returnAdfAction();
        }else{
            retorno="closeTaskFlow";
        }
        LOGGER.info("Retorno de la actividad ====================> "+retorno);
        LOGGER.end(Level.FINEST,"AbstractBPMManageBeanBase.myInvokeOperation");
        return retorno;
    }
    /**
     * Este metodo debe ser colocado en el action del componente ADF que ejecute la acci�n asociada al outcome
     * @return retorna el outcome de la actividad.
     */
    public String myInvokeOperationTaskFLow(){
        String retorno=null;
        try{
            LOGGER.begin(Level.FINEST,"AbstractBPMManageBeanBase.myInvokeOperationTaskFLow");
            if(!this.finalizarActividad()){
                return AbstractBPMManageBeanBase.NAVEGACION_ERROR;
            }
            this.saveManageBeanPayload();
           /* Map<java.lang.String, java.lang.Object> map =FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
            oracle.bpel.services.workflow.worklist.adf.InvokeActionBean invokeActionBean =(oracle.bpel.services.workflow.worklist.adf.InvokeActionBean)map.get("invokeActionBean");
    
            String result = invokeActionBean.invokeOperation();*/
            final FacesContext fctx = FacesContext.getCurrentInstance();
            final Application app = fctx.getApplication();
            final ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            final InvokeActionBean invokeActionBean =(InvokeActionBean)app.getELResolver().getValue(elContext,null,"invokeActionBean");
            retorno=invokeActionBean.invokeOperation();
            LOGGER.info("Retorno de la original actividad ====================> "+retorno);
            
            if(this.accionCerrar!=null && !this.accionCerrar.equals("")){
                retorno=this.returnAdfAction();
            }else{
                retorno="closeTaskFlow";
            }
            
        }catch(NullPointerException e){
            ProcessError pro= new ProcessError();
            pro.setMethodCode(ProcessError.MethodIdentifier.M01.getID());
            pro.process(e,ProcessError.NULL_POINTER_MSJ, this);
            LOGGER.info("NullPointerException de la actividad ====================> error");
            return AbstractBPMManageBeanBase.NAVEGACION_ERROR;
        }catch(Exception e){
            ProcessError pro= new ProcessError();
            pro.setMethodCode(ProcessError.MethodIdentifier.M01.getID());
            pro.process(e, this);
            LOGGER.info("Exception de la actividad ====================> error");
            return AbstractBPMManageBeanBase.NAVEGACION_ERROR;
        }
        LOGGER.info("Retorno de la actividad ====================> "+retorno);
        LOGGER.end(Level.FINEST,"AbstractBPMManageBeanBase.myInvokeOperationTaskFLow");
        return retorno;
    }
    /**
     * Este metodo debe ser colocado en el actionlistener del componente ADF que ejecute la acci�n asociada al outcome
     * @return Nada.
     */
    public void mySetOperation(final ActionEvent action){
        LOGGER.begin(Level.FINEST,"AbstractBPMManageBeanBase.mySetOperation");
        try{
            this.accionActivida=(String)action.getComponent().getAttributes().get("TIPO_ACCION");
            this.operationBinding=action.getComponent().getAttributes().get("DC_OPERATION_BINDING");
            this.accionCerrar=(String)action.getComponent().getAttributes().get("ADF_ACCION");
            LOGGER.info("ACCIONES AL CERRAR "+operationBinding+" -- "+accionActivida+" - "+accionCerrar);
            this.finalizarActionListener(action);
            final FacesContext fctx = FacesContext.getCurrentInstance();
            final Application app = fctx.getApplication();
            final ELContext elContext = FacesContext.getCurrentInstance().getELContext();
            final InvokeActionBean invokeActionBean =(InvokeActionBean)app.getELResolver().getValue(elContext,null,"invokeActionBean");
            invokeActionBean.setOperation(action);
            
        }catch(Exception e){
           LOGGER.log(ADFLogger.ERROR, "ERROR: mySetOperation", e);
        }
        LOGGER.end(Level.FINEST,"AbstractBPMManageBeanBase.mySetOperation");    
    }

    public void setAccionActivida(final String accionActivida) {
        this.accionActivida = accionActivida;
    }

    public String getAccionActivida() {
        return accionActivida;
    }
}
