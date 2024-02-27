package co.edu.javeriana.configuracion.utils;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


/**
 * Patterns Utility class for public use.
 */
public class PopupUtils {
    /**
     * Shows the specified popup component and its contents
     * @param popupId is the clientId of the popup to be shown
     * clientId is derived from backing bean for the af:popup using getClientId method
     */
    public static void invokePopup(final String popupId) {
        invokePopup(popupId, null, null);
    }

    /**
     * Shows the specified popup and uses the specified hints to align the popup.
     * @param id is the clientId of the popup to be shown - clientId is derived from backing bean for the af:popup using getClientId method
     */
    public static void ocultarPopUpComponet(final String id) {
        final UIComponent pop = JsfUtils.findComponentInRoot(id);
        PopupUtils.hidePopup(pop.getClientId(JsfUtils.getFacesContext()));
    }

    public static void mostrarPopUpComponet(final String id) {
        final UIComponent pop = JsfUtils.findComponentInRoot(id);
        PopupUtils.invokePopup(pop.getClientId(JsfUtils.getFacesContext()));
    }
    public static void mostrarPopUpComponet(final String id,final UIComponent comp) {
        final UIComponent pop = JsfUtils.findComponent(comp,id);
        
        final RichPopup.PopupHints hints = new RichPopup.PopupHints();
        hints.add(RichPopup.PopupHints.HintTypes.HINT_ALIGN_ID,comp)
                       .add(RichPopup.PopupHints.HintTypes.HINT_LAUNCH_ID,comp)
                       .add(RichPopup.PopupHints.HintTypes.HINT_ALIGN,
        RichPopup.PopupHints.AlignTypes.ALIGN_OVERLAP);
        
        ((RichPopup)pop).show(hints);
    }

    public static void invokePopup(final String popupId, final String align,
                                   final String alignId) {
        if (popupId != null) {
            final ExtendedRenderKitService service =
                Service.getRenderKitService(FacesContext.getCurrentInstance(),
                                            ExtendedRenderKitService.class);

            final StringBuffer showPopup = new StringBuffer();
            showPopup.append("var hints = new Object();");
            //Add hints only if specified - see javadoc for AdfRichPopup js for details on valid values and behavior
            if (align != null && alignId != null) {
                showPopup.append("hints[AdfRichPopup.HINT_ALIGN] = " + align +
                                 ";");
                showPopup.append("hints[AdfRichPopup.HINT_ALIGN_ID] ='" +
                                 alignId + "';");
            }
            showPopup.append("var popupObj=AdfPage.PAGE.findComponent('" +
                             popupId + "'); popupObj.show(hints);");
            service.addScript(FacesContext.getCurrentInstance(),
                              showPopup.toString());
        }
    }

    /**
     * Hides the specified popup.
     * @param popupId is the clientId of the popup to be hidden
     * clientId is derived from backing bean for the af:popup using getClientId method
     */
    public static void hidePopup(final String popupId) {
        if (popupId != null) {
            final ExtendedRenderKitService service = Service.getRenderKitService(FacesContext.getCurrentInstance(), ExtendedRenderKitService.class);
            final String hidePopup = "var popupObj=AdfPage.PAGE.findComponent('" + popupId +  "'); popupObj.hide();";
            service.addScript(FacesContext.getCurrentInstance(), hidePopup);
        }
    }
    
    public static Boolean hideParentPopUp(final UIComponent comp){
        final RichPopup parent = PopupUtils.retriveParentPopUp(comp);
        if(parent==null){
            return false;
        }
        parent.hide();
        return true;
    }
    public static RichPopup retriveParentPopUp(final UIComponent comp){
        if(comp==null){
            return null;
        }
        if(comp instanceof RichPopup){
            return (RichPopup)comp;
        }
        return PopupUtils.retriveParentPopUp(comp.getParent());
    }
}

