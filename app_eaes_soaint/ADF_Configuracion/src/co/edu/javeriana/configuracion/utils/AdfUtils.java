package co.edu.javeriana.configuracion.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import javax.faces.model.SelectItem;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.events.EventDispatcher;
import oracle.adf.share.logging.ADFLogger;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;

import oracle.jbo.uicli.binding.JUEventBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

public class AdfUtils {
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(AdfUtils.class);
    public static void showPopupMessage(String title, String messag, RichPopup popup, String image) {
        try {
            while (popup.getChildren().size() > 0) {
                popup.getChildren().remove(popup.getChildren().size() - 1);
            }

            RichDialog dialog = new RichDialog();
            RichOutputFormatted opText = new RichOutputFormatted();
            dialog.setTitleIconSource(image);
            dialog.setTitle(title);
            dialog.setId("dlgTitle");
            dialog.setType(RichDialog.TYPE_OK);

            String[] mensajeArr = messag.split("~");

            for (int i = 0; i < mensajeArr.length; i++) {
                opText = new RichOutputFormatted();
                opText.setId("otDlgMessage" + i);
                opText.setValue(mensajeArr[i] + "<br>");
                RichPanelGroupLayout bindingPanel = new RichPanelGroupLayout();
                bindingPanel.setId("pgMessage" + i);
                bindingPanel.setLayout("horizontal");
                bindingPanel.setHalign("left");

                if (mensajeArr.length > 1) {
                    RichImage imageBinding = new RichImage();
                    imageBinding.setSource(image);
                    imageBinding.setId("imb1Message" + 1);
                    bindingPanel.getChildren().add(imageBinding);
                }

                bindingPanel.getChildren().add(opText);
                dialog.getChildren().add(bindingPanel);
            }

            popup.getChildren().add(dialog);
            RichPopup.PopupHints ph = new RichPopup.PopupHints();
            popup.show(ph);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Object captureSimpleFragmentParameter(final String parameterName, final Class clase) {
        Object parameter = JsfUtils.resolveExpression("#{pageFlowScope." + parameterName + "}");
        LOGGER.info("Capturar #{pageFlowScope." + parameterName + "}");
        if (parameter == null) {
            LOGGER.info("Parametros nulo " + parameterName);
            try {
                parameter = ReflectionUtil.newInstance(clase);
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return parameter;
    }

    public static List captureListFragmentParameter(final String parameterName) {
        List parameter = (List) JsfUtils.resolveExpression("#{pageFlowScope." + parameterName + "}");
        if (parameter == null) {
            parameter = new ArrayList<>();
        }
        return parameter;
    }

    public static void addScript(final String script) {
        final FacesContext fc = FacesContext.getCurrentInstance();
        final ExtendedRenderKitService erks = Service.getRenderKitService(fc, ExtendedRenderKitService.class);
        erks.addScript(fc, script);
    }

    public static String getSelectItemDescription(final List<SelectItem> lista, final String cod) {
        if (lista.size() <= 0) {
            return "";
        }
        final Iterator<SelectItem> it = lista.iterator();
        while (it.hasNext()) {
            final SelectItem item = it.next();
            if (item.getValue().equals(cod)) {
                return item.getLabel();
            }
        }
        return "";
    }

    public static void dispararContextualEvent(final String nombre, final Object payload) {
        final JUEventBinding eventBinding = (JUEventBinding) BindingContext.getCurrent()
                                                                           .getCurrentBindingsEntry()
                                                                           .get(nombre);
        final EventDispatcher eventDispacher =
            ((DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry()).getEventDispatcher();
        eventDispacher.queueEvent(eventBinding, payload);
    }
}
