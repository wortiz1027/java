package co.edu.javeriana.configuracion.utils;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.ControlBinding;

import oracle.bpel.services.workflow.WorkflowException;
import oracle.bpel.services.workflow.client.IWorkflowServiceClient;
import oracle.bpel.services.workflow.query.ITaskQueryService;
import oracle.bpel.services.workflow.verification.IWorkflowContext;
import oracle.bpel.services.workflow.worklist.adf.ADFWorklistBeanUtil;


public class BpmUtils {
    public BpmUtils() {
        super();
    }
    public static String getUsuarioBPM() {
        try {
            String usuario = "";
            IWorkflowServiceClient wfSvcClient;
            ITaskQueryService queryService;
            IWorkflowContext wfContext;

            final String contextStr = ADFWorklistBeanUtil.getWorklistContextId();
            wfSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
            queryService = wfSvcClient.getTaskQueryService();
            wfContext = queryService.getWorkflowContext(contextStr);
            usuario = wfContext.getUser();
            return usuario;
        } catch (WorkflowException e) {
            e.printStackTrace();
            return null;
        } catch (NoClassDefFoundError e) {
            System.out.println("Clase no encontrada - " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static String getNombreUsuarioBPM() {
        try {
            String usuario = "";
            IWorkflowServiceClient wfSvcClient;
            ITaskQueryService queryService;
            IWorkflowContext wfContext;

            final String contextStr = ADFWorklistBeanUtil.getWorklistContextId();
            wfSvcClient = ADFWorklistBeanUtil.getWorkflowServiceClient();
            queryService = wfSvcClient.getTaskQueryService();
            wfContext = queryService.getWorkflowContext(contextStr);
            usuario = wfContext.getUserDisplayName();
            return usuario;
        } catch (WorkflowException e) {
            e.printStackTrace();
            return null;
        } catch (NoClassDefFoundError e) {
            System.out.println("Clase no encontrada - " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static Object getAtributeValue(final String name){
        Object valor=null;
        try {
            final BindingContainer bindingContainer =(BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            final ControlBinding ctrlBinding =bindingContainer.getControlBinding(name);
            final oracle.binding.AttributeBinding atributo =(oracle.binding.AttributeBinding)ctrlBinding;
            if (atributo.getInputValue() != null) {
                valor = atributo.getInputValue();
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo getAtributeValue \" " +name + "\", originado por :  " +e.getMessage());
        }catch(NoClassDefFoundError e){
            System.out.println("Clase no encontrada - "+e.getMessage());
        }
        return valor;
    }
    public static void setAtributeValue(final String name,final Object value){
        try {
            final BindingContainer bindingContainer =(BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            final ControlBinding ctrlBinding =bindingContainer.getControlBinding(name);
            final oracle.binding.AttributeBinding atributo =(oracle.binding.AttributeBinding)ctrlBinding;
            if (atributo != null) {
                atributo.setInputValue(value);
            }
        } catch (Exception e) {
            System.out.println("Error en el metodo setAtributeValue, originado por :  " +e.getMessage());
        }catch(NoClassDefFoundError e){
            System.out.println("Clase no encontrada - "+e.getMessage());
        }
    }
    public static void setValueBinding(final String binding, final Object value) {

        final BindingContainer bindingContainer = (BindingContainer) JsfUtils.resolveExpression("#{bindings}");
        final ControlBinding ctrlBinding = bindingContainer.getControlBinding(binding);
        final AttributeBinding ab = (AttributeBinding) ctrlBinding;

        if (ctrlBinding instanceof AttributeBinding) {
            ab.setInputValue(value);
        }
    }

    public static Object getValueBinding(String binding) {
        Object value = null;

        BindingContainer bindingContainer = (BindingContainer) JsfUtils.resolveExpression("#{bindings}");
        ControlBinding ctrlBinding = bindingContainer.getControlBinding(binding);
        AttributeBinding ab = (AttributeBinding) ctrlBinding;
        if (ab.getInputValue() != null) {
            value = ab.getInputValue();
        } else {
            value = "";
        }
        return value;
    }

}
