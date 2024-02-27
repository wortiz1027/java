package co.edu.javeriana.configuracion.utils;

import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.MethodExpression;
import javax.el.ValueExpression;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;
import javax.faces.event.MethodExpressionActionListener;
import javax.faces.event.MethodExpressionValueChangeListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.faces.model.SelectItem;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

/*
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;*/
/*
import javax.faces.webapp.UIComponentTag;*/


/*
import weblogic.servlet.internal.WebAppServletContext;

*/
//C:\oracle\Middleware11gR2\oracle_common\modules\oracle.adf.view_11.1.1
//import oracle.adf.view.rich.context.AdfFacesContext;


//TODO: Revisar los faltantes por documentar en los TODO javadoc
/**
 * Clase de Utileria para el manejo de componentes java basicos de JSF (Java Server Faces)
 * y algunos de ADF Context (al final de la clase) ...
 * Para metodos adicionales de ADF para componentes tipo caja negra
 * ver clase  @see AdfBcUtil
 * @version 2.0
 */
public class JsfUtils implements Serializable {
    @SuppressWarnings("compatibility:3487574112317830373")
    private static final long serialVersionUID = 1L;

    /** Prevent object construction.  */
    private JsfUtils() {
        throw new AssertionError();
    }

    private static final String NO_RESOURCE_FOUND = "Missing resource: ";

    /** URL mapping para peticiones faces del Faces Servlet. */
    static String FACES_MAPPING = "faces";


    public static String getJavascriptInvokeButton(String idComponent) {

        StringBuilder script = new StringBuilder();
        script.append("try{");
        script.append("var button = AdfPage.PAGE.findComponentByAbsoluteId('" + idComponent + "');");
        script.append("AdfActionEvent.queue(button, button.getPartialSubmit());");
        script.append("} catch(err){alert('Error: '+err);}");

        return script.toString();

    }


    /**
     * Retorna el current Context
     *
     * Calls to FacesContext.getCurrentInstance() return a thread local data structure. Request and unscoped managed beans are of course safe as well.
     *
     * @return faces context
     */
    public static FacesContext getFacesContext() {

        return FacesContext.getCurrentInstance();
    }

    /**
     * Retorna el EL (Expression Language) Context.
     *
     * @return eL context
     */
    public static ELContext getELContext() {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ELContext elContext = facesContext.getELContext();
        return elContext;
    }

    /**
     * Retorna el External Context de la aplicacion Faces.
     *
     * @return external context
     */
    public static ExternalContext getExternalContext() {
        return getExternalContext(getFacesContext());
    }

    /**
     * Indica si el facesContext es  null por defecto con la instancia singleton
     * FacesContext.getCurrentInstance()
     *
     * @return boolean
     */
    public Boolean isFacesContextNull() {
        return (getFacesContext() == null);
    }

    /**
     * Indica si el externalContext  es  null por defecto con la instancia singleton
     * FacesContext.getCurrentInstance().getExternalContext()
     *
     * @return boolean
     */
    public Boolean isExternalContextNull() {
        if (isFacesContextNull())
            return null;
        return (getExternalContext() == null);
    }

    /**
     * Retorna el External Context de la aplicacion dado el FacesContext.
     * Sino lo logra retorna null
     *
     * @param fc => fc
     * @return external context
     */
    public static ExternalContext getExternalContext(FacesContext fc) {
        if (fc == null) {
            System.err.println("FacesContexto se obtuvo nulo!! Enlace::getExternalContext");
            return null;
        }
        ExternalContext context = fc.getExternalContext();
        if (context == null) {
            System.err.println("Contexto se obtuvo nulo!! Enlace::getExternalContext");
            return null;
        }
        return context;
    }

    /**
     * Crea un faces context a mano para que intente cargar las propiedades a la que tendrian acceso
     * por defecto elementos JSF con solo hacer FacesContext.getInstance.
     *
     * Este metodo por tanto es usado es por ejemplo por filtros y servlets que desean accedes al contexto
     * de Faces pero por no ser JSF no tienen acceso por el mecanismo clasico de getInstance del FacesContext
     *
     * NOTA. Internamente crea un DEFAULT_LIFECYCLE (debe revisarse si esto es deseado o si desean traerse
     * uno personalizado).
     * PARA EL CASO DE ADF Genera un error al momento de intentar cargar las paginas
     * jspx <BEA-101020> <[ServletContext@9529119[app:procjee module:XXXX path:/XXXX spec-version:2.5 version:V2.0]] Servlet failed with Exception
     * java.lang.NullPointerException
     *
     * @param sctx ServletContext
     * @param req HttpServletRequest
     * @param resp HttpServletResponse
     * @return faces context
     */
    public static FacesContext createFacesContextFromServletCtx(ServletContext sctx, HttpServletRequest req,
                                                                HttpServletResponse resp) {
        FacesContext ret = null;
        System.out.println("FacesCtx es null ... creando a mano"); //TODO quitar esto
        FacesContextFactory facesContextFactory;
        Lifecycle lifecycle;

        LifecycleFactory lifecycleFactory =
            (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
        facesContextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
        lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

        ret = facesContextFactory.getFacesContext(sctx, req, resp, lifecycle);

        System.out.println("Se creo a mano el FACESCONTEXT!!!!"); //TODO quitar esto
        return ret;
    }

    /**
     * Devuelve un objeto del mapa tipo Request
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key llave del mapa
     * @return req map val
     */
    public static Object getReqMapVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getRequestMap();
        return map.get(key);
    }

    /**
     * Devuelve un objeto del mapa tipo Request
     * mediante el HttpServletRequest request.
     * Cuando no se tenga acceso al contexto de Faces, probablemente
     * desde una invocacion JSP o Servlet
     *
     * @param request => request
     * @param key llave del mapa
     * @return req map val
     */
    public static Object getReqMapVal(HttpServletRequest request, String key) {
        return request.getAttribute(key);
    }

    /**
     * Devuelve un objeto del mapa tipo RequestParameter
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key llave del mapa
     * @return param val
     */
    public static Object getParamVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getRequestParameterMap();
        return map.get(key);
    }

    /**
     * Devuelve un objeto del mapa tipo RequestParameter
     * mediante el HttpServletRequest request.
     * Cuando no se tenga acceso al contexto de Faces, probablemente
     * desde una invocacion JSP o Servlet
     *
     * @param request => request
     * @param key llave del mapa
     * @return param val
     */
    public static Object getParamVal(HttpServletRequest request, String key) {
        return request.getParameter(key);
    }

    /**
     * Devuelve un objeto del mapa tipo RequestHeader
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key => key
     * @return head map val
     */
    public static String getHeadMapVal(String key) {
        ExternalContext ectx = getExternalContext();
        return ectx.getRequestHeaderMap().get(key);
    }

    /**
     * Devuelve un objeto del mapa tipo RequestHeader
     * mediante el HttpServletRequest request.
     * Cuando no se tenga acceso al contexto de Faces, probablemente
     * desde una invocacion JSP o Servlet
     *
     * @param request => request
     * @param key => key
     * @return head map val
     */
    public static String getHeadMapVal(HttpServletRequest request, String key) {
        return request.getHeader(key);
    }

    /**
     * Devuelve un objeto del mapa tipo Session
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key llave del mapa
     * @return ses map val
     */
    public static Object getSesMapVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getSessionMap();
        return map.get(key);
    }

    /**
     * Devuelve un objeto del mapa tipo Session
     * mediante el HttpSession session.
     * Cuando no se tenga acceso al contexto de Faces, probablemente
     * desde una invocacion JSP o Servlet
     *
     * @param session => session
     * @param key llave del mapa
     * @return ses map val
     */
    public static Object getSesMapVal(HttpSession session, String key) {
        return session.getAttribute(key);
    }


    /**
     * Devuelve un objeto del mapa tipo Application
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key llave del mapa
     * @return app map val
     */
    public static Object getAppMapVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getApplicationMap();
        return map.get(key);
    }

    /**
     * Devuelve un objeto del mapa initParam que tiene las variables colocadas
     * dentro del Web.xml como initParams dado un valor de key.
     *
     * @param key llave del mapa
     * @return app map val
     */
    public static String getInitParam(String key) {
        ExternalContext context = getExternalContext();
        return context.getInitParameter(key);
    }

    /**
     * Devuelve un objeto del mapa tipo Application
     * mediante el ServletContext servletCtx.
     * Cuando no se tenga acceso al contexto de Faces, probablemente
     * desde una invocacion JSP o Servlet
     *
     * @param servletCtx => servlet ctx
     * @param key llave del mapa
     * @return app map val
     */
    public static Object getAppMapVal(ServletContext servletCtx, String key) {
        return servletCtx.getAttribute(key);
    }

    /**
     * Devuelve un objeto del mapa tipo Request
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key => key
     * @param value => value
     */
    public static void putReqMapVal(String key, Object value) {
        ExternalContext context = getExternalContext();
        Map map = context.getRequestMap();
        map.put(key, value);
    }

    /**
     * Coloca un objeto del mapa tipo RequestParameter
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key => key
     * @param value => value
     */
    public static void putParamVal(String key, Object value) {
        ExternalContext context = getExternalContext();
        Map map = context.getRequestParameterMap();
        map.put(key, value);
    }

    /**
     * Devuelve un objeto del mapa tipo Header
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key => key
     * @param value => value
     */
    public static void putHeadMapVal(String key, Object value) {
        ExternalContext context = getExternalContext();
        Map map = context.getRequestHeaderMap();
        map.put(key, value);
    }

    /**
     * Devuelve un objeto del mapa tipo Session
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key => key
     * @param value => value
     */
    public static void putSesMapVal(String key, Object value) {
        ExternalContext context = getExternalContext();
        Map map = context.getSessionMap();
        map.put(key, value);
    }

    /**
     * Coloca un objeto del mapa tipo Session
     * mediante el HttpSession session.
     * Cuando no se tenga acceso al contexto de Faces, probablemente
     * desde una invocacion JSP o Servlet
     *
     * @param session => session
     * @param key => key
     * @param value => value
     */
    public static void putSesMapVal(HttpSession session, String key, Object value) {
        session.setAttribute(key, value);
    }

    /**
     * Coloca un objeto del mapa tipo Application
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key => key
     * @param value => value
     */
    public static void putAppMapVal(String key, Object value) {
        ExternalContext context = getExternalContext();
        Map map = context.getApplicationMap();
        map.put(key, value);
    }

    /**
     * Devuelve un objeto del mapa tipo Application
     * mediante el ServletContext servletCtx.
     * Cuando no se tenga acceso al contexto de Faces, probablemente
     * desde una invocacion JSP o Servlet
     *
     * @param servletCtx => servlet ctx
     * @param key => key
     * @param value => value
     */
    public static void putAppMapVal(ServletContext servletCtx, String key, Object value) {
        servletCtx.setAttribute(key, value);
    }


    /**
     * Obtiene un bean manejado del map de tipo Request
     * Si el Bean Manejado existe entonces retorna el valor que hay en el map
     * si NO existe entonces retorna el mismo objeto ingresado como 'newBean' y
     * lo reemplaza en el map
     *
     * ( De manera general este bean NO es reemplazado luego por el faces ).
     *
     * @param nameBean => name bean
     * @param newBean => new bean
     * @return bean req
     * @throws Exception => exception
     */
    public synchronized static Object getBeanReq(String nameBean, Object newBean) throws Exception {
        Object ret = getReqMapVal(nameBean);
        if (ret == null) {
            System.out.println("{reemplazando class ..." + newBean.getClass());
            putReqMapVal(nameBean, newBean);
            System.out.println("newReq:" + "KEY:" + nameBean + "}");
        } else
            return ret;
        return newBean;
    }

    /**
     * Obtiene un bean manejado del map de tipo Session
     * Si el Bean Manejado existe entonces retorna el valor que hay en el map
     * sino existe entonces retorna el mismo objeto ingresado como 'newBean' y
     * lo coloca de paso en el map
     *
     * * ( De manera general este bean NO es reemplazado luego por el faces ).
     *
     * @param nameBean => name bean
     * @param newBean => new bean
     * @return bean ses
     * @throws Exception => exception
     */
    public synchronized static Object getBeanSes(String nameBean, Object newBean) throws Exception {
        Object ret = getSesMapVal(nameBean);
        if (ret == null) {
            System.out.println("{reemplazando class ..." + newBean.getClass());
            putSesMapVal(nameBean, newBean);
            System.out.println("newReq:" + "KEY:" + nameBean + "}");
        } else
            return ret;
        return newBean;
    }

    /**
     * Obtiene un bean manejado del map de tipo Application
     * Si el Bean Manejado existe entonces retorna el valor que hay en el map
     * sino existe entonces retorna el mismo objeto ingresado como 'newBean' y
     * lo coloca de paso en el map
     * * ( De manera general este bean NO es reemplazado luego por el faces ).
     *
     * @param nameBean => name bean
     * @param newBean => new bean
     * @return bean app
     * @throws Exception => exception
     */
    public synchronized static Object getBeanApp(String nameBean, Object newBean) throws Exception {
        Object ret = getAppMapVal(nameBean);
        if (ret == null) {
            System.out.println("{reemplazando class ..." + newBean.getClass());
            putAppMapVal(nameBean, newBean);
            System.out.println("newReq:" + "KEY:" + nameBean + "}");
        } else
            return ret;
        return newBean;
    }

    /**
     * Elimina un objeto del mapa tipo Request.
     *
     * @param key => key
     */
    public static void delReqMapVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getRequestMap();
        map.remove(key);
    }

    /**
     * Elimina un objeto del mapa tipo RequestParameter.
     *
     * @param key => key
     */
    public static void delParamVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getRequestMap();
        map.remove(key);
    }

    /**
     * Elimina un objeto del mapa tipo RequestHeader.
     *
     * @param key => key
     */
    public static void delHeadMapVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getRequestHeaderMap();
        map.remove(key);
    }

    /**
     * Elimina un objeto del mapa tipo Session.
     *
     * @param key => key
     */
    public static void delSesMapVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getSessionMap();
        map.remove(key);
    }

    /**
     * Elimina un objeto del mapa tipo Application.
     *
     * @param key => key
     */
    public static void delAppMapVal(String key) {
        // se saca del contexto el map que contiene parametros
        ExternalContext context = getExternalContext();
        Map map = context.getApplicationMap();
        map.remove(key);
    }

    /*Para navegar entre JSF programaticamente
     * FacesContext context = getFacesContext();
    context.getApplication().getViewHandler().createView(context,
    "/pagina.jsp");*/

    //    /**
    //     * Ejecuta un metodo de un bean de sesion que recibe void (y no deberia retornar nada)
    //     * si el bean no existe lo monta en sesion creandolo mediante un Reflection a partir
    //     * del classBean
    //     *
    //     * Es usado para invocar una funcionalidad en un bean de la siguiente JSF para que al cargarse la vista
    //     * por ejemplo el bean ya se encuentre lleno de valores
    //     *
    //     * NOTA: Recordar que la invocacion por introspeccion AFECTA el performance.
    //     *
    //     * @param classBean Clase que se instanciara en caso de no estar en session
    //     * @param nameBean Nombre del managed-bean dentro de la session (faces-config)
    //     * @param metod Nombre del metodo a ejecutar
    //     * @throws Exception => Exception exception
    //     */
    //    public static void execSesBeanMethod(Class classBean, String nameBean,
    //                                         String metod) throws Exception {
    //        try {
    //            Object newBean = classBean.newInstance();
    //            Object bean = getBeanSes(nameBean, newBean);
    //            UtilReflect.executeVoidMethod(bean, metod);
    //        } catch (Exception ex) {
    //            throw new Exception(ex);
    //        }
    //    }


    /**
     * Resuelve el EL-JSF (Expression Language de JSF) y trae la referenca o binding expression del objeto que hace match con el
     * Si no ha sido creado entonces lo crea.
     * @param expresion EL expression
     * @return Managed object
     */
    public static Object resolveExp(String expresion) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expresion, Object.class);
        return valueExp.getValue(elContext);
    }

    /**
     * resolveExpression cast a Boolean.
     *
     * @param expression EL expression
     * @return Managed object
     */
    public static Boolean resolveExpBoolean(String expression) {
        return (Boolean) resolveExp(expression);
    }

    /**
     * resolveExpression cast a String.
     *
     * @param expression EL expression
     * @return Managed object
     */
    public static String resolveExpString(String expression) {
        return (String) resolveExp(expression);
    }

    /**
     * Obtiene el RemoteUser del External Context.
     *
     * @return remote user
     */
    public static String getRemoteUser() {
        FacesContext facesContext = getFacesContext();
        ExternalContext ectx = facesContext.getExternalContext();
        return ectx.getRemoteUser();
    }

    /**
     * Obtiene el UserPrincipal del HttpRequest.
     *
     * @return user principal
     */
    public static String getUserPrincipal() {
        HttpServletRequest request = (HttpServletRequest) getExternalContext().getRequest();
        return request.getUserPrincipal().getName();
    }


    /**
     * Permite invocar un metodo de EL JSF tipo #{mibean.miactionmetodo}
     * como introspeccion pero resolviendo primero la expresion EL
     *
     * @param expEL expresion EL que apunta al metodo que se desea invocar
     * @param returnType    Class del retorno de dicho metodo
     * @param argTypes      Arreglo de class de los tipos de datos que recibe el metodo por argumento
     * @param argValues     Valores de los argumentos sencuenciales dentro de un Object[]
     * @return object
     * @throws Exception => exception
     */
    public static Object resolveMethodExpression(String expEL, Class returnType, Class[] argTypes,
                                                 Object[] argValues) throws Exception {

        FacesContext facesContext = getFacesContext();
        ELContext elContext = facesContext.getELContext();
        MethodExpression me = createMethodExpression(expEL, returnType, argTypes);
        Object obj = me.invoke(elContext, argValues);

        return obj;
    }

    /**
     * Crea el objeto MethodExpression de EL para un metodo que sea apuntado por una expresion EL.
     *
     * @param expEL expresion EL que apunta al metodo que se desea invocar
     * @param returnType    Class del retorno de dicho metodo
     * @param argTypes      Arreglo de class de los tipos de datos que recibe el metodo por argument
     * @return method expression
     */
    public static MethodExpression createMethodExpression(String expEL, Class returnType, Class[] argTypes) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        MethodExpression methodExpression = elFactory.createMethodExpression(elContext, expEL, returnType, argTypes);
        return methodExpression;
    }


    /**
     * Invoca un metodo de tipo ActionMethod (el que usan los button para navegar a otras paginas)
     * Dichos metodos tienen la signatura String METODO();
     * por lo que unico que se requiere es el expresion EL que apunta al metodo que se desea invocar.
     *
     * @param expEL expresion EL que apunta al metodo que se desea invocar
     * @return string
     * @throws Exception => exception
     */
    public static String invokeActionMethod(String expEL) throws Exception {
        return (String) resolveMethodExpression(expEL, String.class, new Class[0], new Object[0]);
    }

    /**
     * Invoca un metodo de tipo ActionListener (el que usan los button para navegar para invocar una funcionalidad, antes del action)
     * Dichos metodos tienen la signatura void METODO(ActionEvent evt);
     * por lo que unico que se requiere es el expresion EL que apunta al metodo que se desea invocar y el
     * UIComponent con el que se armara el ActionEvent.
     *
     * @param expEL expresion EL que apunta al metodo que se desea invocar
     * @param component UIComponent donde se origina el evento para el ACtionListener
     * @throws Exception => exception
     */
    public static void invokeActionListenerMethod(String expEL, UIComponent component) throws Exception {
        ActionEvent ae = new ActionEvent(component);
        JsfUtils.resolveMethodExpression(expEL, null, new Class[] { ActionEvent.class }, new Object[] { ae });
    }

    /**
     * Invoca un metodo de tipo ActionListener (el que usan los button para navegar para invocar una funcionalidad, antes del action)
     * Dichos metodos tienen la signatura void METODO(ActionEvent evt);
     * por lo que unico que se requiere es el expresion EL que apunta al metodo que se desea invocar y el
     * y el ActionEvent.
     *
     * @param expEL expresion EL que apunta al metodo que se desea invocar
     * @param evt Evento del ActionListener
     * @throws Exception => exception
     */
    public static void invokeActionListenerMethod(String expEL, ActionEvent evt) throws Exception {


        JsfUtils.resolveMethodExpression(expEL, null, new Class[] { ActionEvent.class }, new Object[] { evt });
    }

    /**
     * Invoca un metodo de tipo ValueChangeListener (el que usan los componentes de select para indicar
     * que se realizo un cambio antes/despues e invocar una accion)
     * Dichos metodos tienen la signatura void METODO(ValueChangeEvent evt);
     * por lo que unico que se requiere es el expresion EL que apunta al metodo que se desea invocar
     * y el ValueChangeEvent.
     *
     * @param expEL expresion EL que apunta al metodo que se desea invocar
     * @param evt Evento del ActionListener
     * @throws Exception => exception
     */
    public static void invokeValueChangeListenerMethod(String expEL, ValueChangeEvent evt) throws Exception {
        JsfUtils.resolveMethodExpression(expEL, null, new Class[] { ValueChangeEvent.class }, new Object[] { evt });
    }


    /**
     * Crea el objeto MethodExpressionActionListener a partir del nombre del metodo ACtionListener
     * como expresion EL.
     *
     * @param expEL expresion EL que apunta al metodo que se desea invocar
     * @return method expression action listener
     */
    public static MethodExpressionActionListener createMethodExpActionListener(String expEL) {
        MethodExpression me = createMethodExpression(expEL, null, new Class[] { ActionEvent.class });
        MethodExpressionActionListener ret = new MethodExpressionActionListener(me);
        return ret;
    }

    /**
     * Crea el objeto MethodExpressionValueChangeListener a partir del nombre del metodo ValueChange
     * como expresion EL.
     *
     * @param expEL expresion EL que apunta al metodo que se desea invocar
     * @return method expression value change listener
     */
    public static MethodExpressionValueChangeListener createMethodExpValueChangeListener(String expEL) {
        MethodExpression me = createMethodExpression(expEL, null, new Class[] { ValueChangeEvent.class });
        MethodExpressionValueChangeListener ret = new MethodExpressionValueChangeListener(me);
        return ret;
    }


    /**
     * Metodo para retornar la referencia de un Managed Bean by name
     * en lugar de como Expresion. Es mas lento por la introspeccion y manejo de EL
     * supongo pero NO tiene uno que saber en que alcance o cuando fue creado dicho bean.
     * Como llama a resolveExp crea el bean si no esta creado
     *
     * @param beanName name of managed bean
     * @return Managed object
     * @see #resolveExp
     */
    public static Object getManagedBeanAsELexp(String beanName) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        return resolveExp(buff.toString());
    }

    /**
     * Reemplazar por getManagedBeanAsELexp.
     *
     * @param beanName => bean name
     * @return managed bean
     * @see #getManagedBeanAsELexp
     * @deprecated
     */
    public static Object getManagedBean(String beanName) {
        return getManagedBeanAsELexp(beanName);
    }

    /**
     * Reemplaza el objeto (valor) de una Expresion EL JSF (por ejemplo un
     * manage bean "#{mibean}" por el valor indicado en newValue.
     *
     * @param expression EL expression
     * @param newValue new value to set
     * @return el ValueExpression por si se desea trabajar con el ademas de guardar en el ELContext dicho "binding"
     * @throws Exception => exception
     */
    public static ValueExpression setExpValue(String expression, Object newValue) throws Exception {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expression, Object.class);

        //Check that the input newValue can be cast to the property type
        //expected by the managed bean.
        //If the managed Bean expects a primitive we rely on Auto-Unboxing
        Class bindClass = valueExp.getType(elContext);
        if (bindClass.isPrimitive() || bindClass.isInstance(newValue)) {
            valueExp.setValue(elContext, newValue);
        } else {
            System.err.println("No se pudo realizar el SET del valor de expresion EL porque los tipos de datos no coincidian bindClass=" +
                               bindClass.getCanonicalName() + " newValueClass=" +
                               newValue.getClass().getCanonicalName());
        }
        return valueExp;
    }

    /**
     * Retorna el class o tipo de clase de un atributo que este apuntado bajo
     * la EL expression.
     *
     * @param exp EL expression del objeto que se apunta
     * @return type of value e lexp
     * @throws Exception => exception
     */
    public static Class getTypeOfValueELexp(String exp) throws Exception {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, exp, Object.class);

        Class bindClass = valueExp.getType(elContext);
        return bindClass;
    }

    /**
     * Reemplaza el valor de un ManageBean por nombre (buscado por
     * resolveExp) con eso no requiere saber el contexto donde reside para reemplazarlo.
     *
     * @param beanName name of managed bean
     * @param newValue new value to set
     * @throws Exception => exception
     * @see #resolveExp
     */
    public static void setManagedBeanAsELexp(String beanName, Object newValue) throws Exception {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        setExpValue(buff.toString(), newValue);
    }

    /**
     * Agrega un JSF error para un atributo especifico dentro del RootView.
     *
     * @param atributo id del atributo faces que genero el error
     * @param msg resumen del mensaje
     */
    public static void addFacesErrorMsgToAtrib(String atributo, String msg) {
        addFacesMsgToAtrib(FacesMessage.SEVERITY_ERROR, atributo, msg);
    }
    
    /**
     * Agrega un JSF error para un atributo especifico dentro del RootView.
     *
     * @param atributo id del atributo faces que genero el error
     * @param msg resumen del mensaje
     */
    public static void addFacesInfoMsgToAtrib(String atributo, String msg) {
        addFacesMsgToAtrib(FacesMessage.SEVERITY_INFO, atributo, msg);
    }
    
    /**
     * Agrega un JSF message para un atributo especifico dentro del RootView.
     *
     * @param atributo id del atributo faces que genero el error
     * @param msg resumen del mensaje
     */
    public static void addFacesMsgToAtrib(FacesMessage.Severity severity, String atributo, String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(severity, atributo, msg);
        String component = getRootViewComponentId();
        ctx.addMessage(component, fm);
    }

    /**
     * Agrega un JSF error para un atributo especifico dentro del RootView.
     *
     * @param atributo id del atributo faces que genero el error
     * @param msg resumen del mensaje
     * @param trace traza del error
     */
    public static void addFacesErrorFullMsgToAtrib(String atributo, String msg, String trace) {
        addFacesErrorMsgToAtrib(atributo, msg + " : " + trace);
    }

    /**
     * Agrega un JSF error para un atributo especifico dentro del RootView.
     *
     * @param atributo id del atributo faces que genero el error
     * @param msg resumen del mensaje
     * @param exc => exc
     */
    public static void addFacesErrorFullMsgToAtrib(String atributo, String msg, Exception exc) {
        addFacesErrorFullMsgToAtrib(atributo, msg, exc.getMessage());
        exc.printStackTrace(); //TODO quitar
    }

    /**
     * Envia un mensaje de error sobre la cola de mensajes de faces.
     *
     * @param msg => msg
     * @param trace => trace
     */
    public static void addFacesErrorMsg(String msg, String trace) {
        addFacesErrorFullMsgToAtrib(null, msg, trace);
    }

    /**
     * Envia un mensaje de error sobre la cola de mensajes de faces.
     *
     * @param msg => msg
     * @param error => error
     */
    public static void addFacesErrorMsg(String msg, Exception error) {
        addFacesErrorFullMsgToAtrib(null, msg, error.getMessage());
        error.printStackTrace(); //TODO quitar
    }

    //TODO Se puede asociar el error al RootView?? ctx.addMessage(getRootViewComponentId(), fm);


    /**
     * Obtiene el id del viewRoot actual.
     *
     * @return component id
     */
    public static String getRootViewComponentId() {
        if(getFacesContext()!=null && getFacesContext().getViewRoot()!=null){
            return getFacesContext().getViewRoot().getId();
        }
        return null;
    }

    /**
     * Retorna el ID de la vista de Faces que esta actualmente en la instancia de FacesContext,
     * esto para efectos practicos retorna el nombre del recurso JSF que esta en la vista, osea la pagina
     * de JSF que se esta trabajando en ese momento.
     *
     * @return view id
     */
    public String getViewId() {
        return getFacesContext().getViewRoot().getViewId();
    }

    /**
     * Localiza un UIComponent (por id) a partir de su componente padre directo (base)
     *
     * http://www.jroller.com/page/mert?entry=how_to_find_a_uicomponent
     *
     * @param base root Component (parent)
     * @param id UIComponent id
     * @return UIComponent object
     */
    public static UIComponent findComponent(UIComponent base, String id) {
        if (id.equals(base.getId()))
            return base;
        UIComponent children = null;
        UIComponent result = null;
        Iterator childrens = base.getFacetsAndChildren();
        while (childrens.hasNext() && (result == null)) {
            children = (UIComponent) childrens.next();
            if (id.equals(children.getId())) {
                result = children;
                break;
            }
            result = findComponent(children, id);
            if (result != null) {
                break;
            }
        }
        return result;
    }

    /**
     * Localiza un UIComponent del ViewRoot (JSF Actual) mediante su id.
     * (Es recursivo OJO! con performance y ciclos infinitos)
     * @param id UIComponent id
     * @return UIComponent object
     */
    public static UIComponent findComponentInRoot(String id) {
        UIComponent component = null;
        FacesContext facesContext = getFacesContext();
        if (facesContext != null) {
            UIComponent root = facesContext.getViewRoot();
            component = findComponent(root, id);
        }
        return component;
    }

    /**
     * Crea un redirect URL. Se asume que el servlet mapping esta configurado en FACES_MAPPING
     * que por defecto es "faces" el default
     *
     * @param view  JSP , JSPX page to redirect to
     * @return a URL to redirect to
     */
    public static String getPageURL(String view) {
        FacesContext facesContext = getFacesContext();
        ExternalContext externalContext = facesContext.getExternalContext();
        String url = ((HttpServletRequest) externalContext.getRequest()).getRequestURL().toString();
        StringBuffer newUrlBuffer = new StringBuffer();
        newUrlBuffer.append(url.substring(0, url.lastIndexOf(FACES_MAPPING + "/")));
        newUrlBuffer.append(FACES_MAPPING);
        String targetPageUrl = view.startsWith("/") ? view : "/" + view;
        newUrlBuffer.append(targetPageUrl);

        System.out.println("Se genero el URL = " + newUrlBuffer.toString()); //TODO quitar esto

        return newUrlBuffer.toString();
    }


    /**
     * Trae el resource bundle local a partir del ContextAplication.
     *
     * @return faces bundle
     */
    private static ResourceBundle getFacesBundle() {
        FacesContext ctx = getFacesContext();
        UIViewRoot uiRoot = ctx.getViewRoot();
        Locale locale = uiRoot.getLocale();
        ClassLoader ldr = Thread.currentThread().getContextClassLoader();
        return ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(), locale, ldr);
    }

    /**
     * Pulls a String resource from the property bundle that
     * is defined under the application &lt;message-bundle&gt; element in
     * the faces config. Respects Locale
     * @param key string message key
     * @return Resource value or placeholder error String
     */
    public static String getStringFromBundle(String key) {
        System.out.println("getStringFromBundle");
        ResourceBundle bundle = getBundle();
        return getStringSafely(bundle, key, null);
    }


    /**
     * Convenience method to construct a <code>FacesMesssage</code>
     * from a defined error key and severity
     * This assumes that the error keys follow the convention of
     * using <b>_detail</b> for the detailed part of the
     * message, otherwise the main message is returned for the
     * detail as well.
     * @param key for the error message in the resource bundle
     * @param severity severity of message
     * @return Faces Message object
     */
    public static FacesMessage getMessageFromBundle(String key, FacesMessage.Severity severity) {
        ResourceBundle bundle = getBundle();
        String summary = getStringSafely(bundle, key, null);
        String detail = getStringSafely(bundle, key + "_detail", summary);
        FacesMessage message = new FacesMessage(summary, detail);
        message.setSeverity(severity);
        return message;
    }

    /**
     * Genera una lista de Select items a partir de una lista de Labels, y coloca como
     * id los indices de dicha lista (del 0 en adelante) .. los IDs seran Integer
     *
     * @param labels => labels
     * @return list
     */
    public static List<SelectItem> generateSelectItems(List<String> labels) {
        List<SelectItem> ret = new ArrayList<SelectItem>(labels.size());
        Short index = 0;
        for (String s : labels) {
            ret.add(new SelectItem(index, s));
            index++;
        }
        return ret;
    }


    /**
     * Metodo Static que sirve para generar una lista
     * de SelectItems numerica de un intervalo dado.
     *
     * @param min lo incluye
     * @param max lo incluye
     * @return list
     */
    public static List<SelectItem> generateSelectsNumberList(int min, int max) {
        List<SelectItem> ret = new ArrayList<SelectItem>();
        for (int i = min; i <= max; i++) {
            Integer value = new Integer(i);
            String label = Integer.toString(i);
            SelectItem itemAux = new SelectItem(value, label);
            ret.add(itemAux);
        }
        return ret;
    }

    /**
     * Set de fACE s_ mapping.
     *
     * @param FACES_MAPPING setea a  fACE s_ mapping
     */
    public static void setFACES_MAPPING(String FACES_MAPPING) {
        JsfUtils.FACES_MAPPING = FACES_MAPPING;
    }

    /**
     * Get de fACE s_ mapping.
     *
     * @return fACE s_ mapping
     */
    public static String getFACES_MAPPING() {
        return FACES_MAPPING;
    }

    /**
     * TODO Documentar.
     *
     * @param context => context
     * @param component => component
     * @param name => name
     * @return integer value binding
     */
    public static Integer getIntegerValueBinding(FacesContext context, UIComponent component, String name) {
        //        ValueBinding vb = component.getValueBinding(name);
        //
        //        if (vb == null) {
        //            return -1;
        //        } else {
        //            return (Integer)vb.getValue(context);
        //        }
        ELContext elContext = context.getELContext();
        ValueExpression ve = component.getValueExpression(name);
        if (ve != null) {
            return -1;
        } else {
            return (Integer) ve.getValue(elContext);
        }
    }

    /**
     * TODO Documentar.
     *
     * @param context => context
     * @param component => component
     * @param name => name
     * @return boolean value binding
     */
    public static Boolean getBooleanValueBinding(FacesContext context, UIComponent component, String name) {
        //        ValueBinding vb = component.getValueBinding(name);
        //
        //        if (vb == null) {
        //            return false;
        //        } else {
        //            return (Boolean)vb.getValue(context);
        //        }
        ELContext elContext = context.getELContext();
        ValueExpression ve = component.getValueExpression(name);
        if (ve != null) {
            return false;
        } else {
            return (Boolean) ve.getValue(elContext);
        }
    }

    /**
     * TODO Documentar.
     *
     * @param context => context
     * @param component => component
     * @param name => name
     * @return string value binding
     */
    public static String getStringValueBinding(FacesContext context, UIComponent component, String name) {
        //        ValueBinding vb = component.getValueBinding(name);
        //
        //        if (vb == null) {
        //            return null;
        //        } else {
        //            return (String)vb.getValue(context);
        //        }
        ELContext elContext = context.getELContext();
        ValueExpression ve = component.getValueExpression(name);
        if (ve != null) {
            return null;
        } else {
            return (String) ve.getValue(elContext);
        }
    }

    /**
     * TODO Documentar.
     *
     * @param componentTag => component tag
     * @param component => component
     * @param attributeName => attribute name
     * @param attributeValue => attribute value
     */

    /*
    public static void setBoolean(UIComponentTag componentTag,
                                  UIComponent component, String attributeName,
                                  String attributeValue) {
        if (attributeValue == null) {
            return;
        }

        if (componentTag.isValueReference(attributeValue)) {
            setValueBinding(componentTag, component, attributeName,
                            attributeValue);
        } else {
            component.getAttributes().put(attributeName,
                                          new Boolean(attributeValue));
        }
    }*/

    /**
     * TODO Documentar.
     *
     * @param componentTag => component tag
     * @param component => component
     * @param attributeName => attribute name
     * @param attributeValue => attribute value
     */

    /*
    public static void setInteger(UIComponentTag componentTag,
                                  UIComponent component, String attributeName,
                                  String attributeValue) {
        if (attributeValue == null) {
            return;
        }

        if (componentTag.isValueReference(attributeValue)) {
            setValueBinding(componentTag, component, attributeName,
                            attributeValue);
        } else {
            component.getAttributes().put(attributeName,
                                          new Integer(attributeValue));
        }
    }*/

    /**
     * TODO Documentar.
     *
     * @param componentTag => component tag
     * @param component => component
     * @param attributeName => attribute name
     * @param attributeValue => attribute value
     */
    /*
    public static void setString(UIComponentTag componentTag,
                                 UIComponent component, String attributeName,
                                 String attributeValue) {
        if (attributeValue == null) {
            return;
        }

        if (componentTag.isValueReference(attributeValue)) {
            setValueBinding(componentTag, component, attributeName,
                            attributeValue);
        } else {
            component.getAttributes().put(attributeName, attributeValue);
        }
    }*/

    /**
     * TODO Documentar.
     *
     * @param componentTag => component tag
     * @param component => component
     * @param attributeName => attribute name
     * @param attributeValue => attribute value
     */
    /*xt.getApplication();
        ValueBinding vb = app.createValueBinding(attributeValue);
        component.setValueBinding(attributeName, vb);
    }*/

    /**
     * TODO Documentar.
     *
     * @param componentTag => component tag
     * @param component => component
     * @param attributeName => attribute name
     * @param attributeValue => attribute value
     */
    /*
    public static void setMethodBinding(UIComponentTag componentTag,
                                        UIComponent component,
                                        String attributeName,
                                        String attributeValue) {
        FacesContext context = FacesContext.getCurrentInstance();
        Application app = context.getApplication();
        Class[] paramTypes = new Class[] { ActionEvent.class };
        MethodBinding mb = app.createMethodBinding(attributeValue, paramTypes);
        component.getAttributes().put(attributeName, mb);
    }*/

    /**
     * * TODO Documentar.
     *
     * @param context => context
     * @param component => component
     * @return id form
     */
    public static String getIdForm(FacesContext context, UIComponent component) {
        UIComponent parent = component.getParent();

        while (!(parent instanceof UIForm)) {
            parent = parent.getParent();
        }

        return parent.getClientId(context);
    }

    /**
     * TODO Documentar.
     *
     * @param facesContext => faces context
     * @param component => component
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void renderChildren(FacesContext facesContext, UIComponent component) throws IOException {
        if (component.getChildCount() > 0) {
            for (Object child : component.getChildren()) {
                renderChild(facesContext, (UIComponent) child);
            }
        }
    }

    /**
     * TODO Documentar.
     *
     * @param facesContext => faces context
     * @param child => child
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void renderChild(FacesContext facesContext, UIComponent child) throws IOException {
        if (!child.isRendered()) {
            return;
        }

        child.encodeBegin(facesContext);

        if (child.getRendersChildren()) {
            child.encodeChildren(facesContext);
        } else {
            renderChildren(facesContext, child);
        }

        child.encodeEnd(facesContext);
    }

    //------------------------ Inicio :: ADF Especifico ------------------------ //


    /**
     * Retorna los roles de ADF security Context.
     *
     * @return aD froles
     */
    /*
    public static String[] getADFroles() {
        String[] roles =
            ADFContext.getCurrent().getSecurityContext().getUserRoles();
        return roles;
    }*/


    //USAR los metodos de BC4jUtil

    //------------------------ Fin :: ADF Especifico ------------------------ //

    /**
     * Retorna el tipo de autenticacion usado si existe, sino null
     * El tipo es el mismo que tiene HttpServletRequest.getAuthType
     * pero accedido desde el FacesContext
     * BASIC_AUTH, CLIENT_CERT_AUTH,
     * DIGEST_AUTH, or FORM_AUTH.
     *
     * @return auth type
     */
    public static String getAuthType() {
        return getExternalContext().getAuthType();
    }

    /**
     * Retorna si el usuario auntenticado esta incluido en el rol a nivel JAAS sino retorna false.
     *
     * Servlet: This must be the value returned by the javax.servlet.http.HttpServletRequest method isUserInRole(role).
     *
     * @param rol => rol
     * @return true, si .. user in role
     */
    public static boolean isUserInRole(String rol) {
        return getExternalContext().isUserInRole(rol);
    }

    /**
     * Invoca un metodo Javascript que se asume debe estar en la pagina JSPX del bean que la esta
     * invocando. Tambien permite registrar todo un cuerpo anonimo de Javascript que es ejecutado en
     * el momento de la adicion a la pagina
     *
     * @param javaScript => java script
     * @throws Exception => exception
     */
    /*
    public static void invokeJavascript(String javaScript) throws Exception {
        ExtendedRenderKitService extRenderKitSrvc =
            Service.getRenderKitService(getFacesContext(),
                                        ExtendedRenderKitService.class);
        extRenderKitSrvc.addScript(FacesContext.getCurrentInstance(),
                                   javaScript);
    }*/

    /**
     * Sin importar si lo invoca o no correctamente o inclusive sino encuentra los contextos
     * no dispara una excepcion sino simplemente la imprime como SysErr.
     *
     * @param javaScript => java script
     */ /*
    public static void invokeJavascriptNoException(String javaScript) {
        try {
            invokeJavascript(javaScript);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Si el servidor de despliege es Weblogic 10.3 o similar retorna el contexto
     * en la clase WebAppServletContext. (debe incluirse el JAR weblogic
     *
     * @return wL context
     */ /*
    public WebAppServletContext getWLContext() {
        WebAppServletContext weblogicSrvContext = null;
        Object serverContext = getExternalContext().getContext();
        if (serverContext != null &&
            serverContext instanceof WebAppServletContext) {
            weblogicSrvContext = (WebAppServletContext)serverContext;
        } else {
            System.err.println("El contexto es nulo o no se esta desplegando en un contexto de servidor Oracle Weblogic Valido!!!");
            weblogicSrvContext = (WebAppServletContext)serverContext;
        }
        return weblogicSrvContext;
    }
/
    /************************************************************************************/

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching object (or creating it).
     * @param expression EL expression
     * @return Managed object
     */

    public static Object resolveExpression(String expression) {
        FacesContext ctx = getFacesContext();
        Application app = ctx.getApplication();
        ValueBinding bind = app.createValueBinding(expression);
        return bind.getValue(ctx);
    }

    public static String resolveRemoteUser() {
        FacesContext facesContext = getFacesContext();
        ExternalContext ectx = facesContext.getExternalContext();
        return ectx.getRemoteUser();
    }

    public static String resolveUserPrincipal() {
        FacesContext facesContext = getFacesContext();
        ExternalContext ectx = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
        return request.getUserPrincipal().getName();
    }

    public static Object resloveMethodExpression(String expression, Class returnType, Class[] argTypes,
                                                 Object[] argValues) {
        FacesContext facesContext = getFacesContext();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        MethodExpression methodExpression =
            elFactory.createMethodExpression(elContext, expression, returnType, argTypes);
        return methodExpression.invoke(elContext, argValues);
    }


    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching Boolean.
     * @param expression EL expression
     * @return Managed object
     */ /*
    public static Boolean resolveExpressionAsBoolean(String expression) {
        return (Boolean)resolveExpression(expression);
    }*/

    /**
     * Method for taking a reference to a JSF binding expression and returning
     * the matching String (or creating it).
     * @param expression EL expression
     * @return Managed object
     */ /*
    public static String resolveExpressionAsString(String expression) {
        return (String)resolveExpression(expression);
    }
*/
    /**
     * Convenience method for resolving a reference to a managed bean by name
     * rather than by expression.
     * @param beanName name of managed bean
     * @return Managed object
     */ /*
    public static Object getManagedBeanValue(String beanName) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        return resolveExpression(buff.toString());
    }*/

    /**
     * Method for setting a new object into a JSF managed bean
     * Note: will fail silently if the supplied object does
     * not match the type of the managed bean.
     * @param expression EL expression
     * @param newValue new value to set
     */
    public static void setExpressionValue(String expression, Object newValue) {
        FacesContext ctx = getFacesContext();
        Application app = ctx.getApplication();
        @SuppressWarnings("deprecation")
        ValueBinding bind = app.createValueBinding(expression);

        //Check that the input newValue can be cast to the property type
        //expected by the managed bean.
        //If the managed Bean expects a primitive we rely on Auto-Unboxing
        //I could do a more comprehensive check and conversion from the object
        //to the equivilent primitive but life is too short
        Class bindClass = bind.getType(ctx);
        if (bindClass.isPrimitive() || bindClass.isInstance(newValue)) {
            bind.setValue(ctx, newValue);
        }
    }

    /**
     * Convenience method for setting the value of a managed bean by name
     * rather than by expression.
     * @param beanName name of managed bean
     * @param newValue new value to set
     */ /*
    public static void setManagedBeanValue(String beanName, Object newValue) {
        StringBuffer buff = new StringBuffer("#{");
        buff.append(beanName);
        buff.append("}");
        setExpressionValue(buff.toString(), newValue);
    }*/


    /**
     * Convenience method for setting Session variables.
     * @param key object key
     * @param object value to store
     */

    public static void storeOnSession(String key, Object object) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        sessionState.put(key, object);
    }

    /**
     * Convenience method for getting Session variables.
     * @param key object key
     * @return session object for key
     */
    public static Object getFromSession(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getSessionMap();
        return sessionState.get(key);
    }

    public static String getFromHeader(String key) {
        FacesContext ctx = getFacesContext();
        ExternalContext ectx = ctx.getExternalContext();
        return ectx.getRequestHeaderMap().get(key);
    }

    /**
     * Convenience method for getting Request variables.
     * @param key object key
     * @return session object for key
     */
    public static Object getFromRequest(String key) {
        FacesContext ctx = getFacesContext();
        Map sessionState = ctx.getExternalContext().getRequestMap();
        return sessionState.get(key);
    }

    /**
     * Add JSF error message.
     * @param msg error message string
     */
    public static void addFacesErrorMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, null, msg);
        ctx.addMessage(null, fm);
    }

    public static void addFacesWarningMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_WARN, null, msg);
        ctx.addMessage(null, fm);
    }

    public static void addFacesInfoMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, null, msg);
        ctx.addMessage(null, fm);
    }

    /**
     * Add JSF error message for a specific attribute.
     * @param attrName name of attribute
     * @param msg error message string
     */
    public static void addFacesErrorMessage(String attrName, String msg) {
        // TODO: Need a way to associate attribute specific messages
        //       with the UIComponent's Id! For now, just using the view id.
        //TODO: make this use the internal getMessageFromBundle?
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, attrName, msg);
        ctx.addMessage(getRootViewComponentId(), fm);
    }

    // Informational getters

    /**
     * Get view id of the view root.
     * @return view id of the view root
     */
    public static String getRootViewId() {
        return getFacesContext().getViewRoot().getViewId();
    }

    /*
         * Internal method to pull out the correct local
         * message bundle
         */

    private static ResourceBundle getBundle() {
        FacesContext ctx = getFacesContext();
        UIViewRoot uiRoot = ctx.getViewRoot();
        Locale locale = uiRoot.getLocale();
        ClassLoader ldr = Thread.currentThread().getContextClassLoader();
        return ResourceBundle.getBundle(ctx.getApplication().getMessageBundle(), locale, ldr);
    }

    /**
     * Obtiene el bundle especificado
     * @param bundle paquete y nombre del bundle a obtener
     * @return ResourceBundle
     */
    public static ResourceBundle getBundle(String bundle) {
        return ResourceBundle.getBundle(bundle);
    }

    /**
     * Get an HTTP Request attribute.
     * @param name attribute name
     * @return attribute value
     */
    public static Object getRequestAttribute(String name) {
        return getFacesContext().getExternalContext()
                                .getRequestMap()
                                .get(name);
    }

    /**
     * Set an HTTP Request attribute.
     * @param name attribute name
     * @param value attribute value
     */
    public static void setRequestAttribute(String name, Object value) {
        getFacesContext().getExternalContext()
                         .getRequestMap()
                         .put(name, value);
    }

    /*
         * Internal method to proxy for resource keys that don't exist
         */

    private static String getStringSafely(ResourceBundle bundle, String key, String defaultValue) {
        System.out.println("bundle: " + bundle);
        String resource = null;
        try {
            resource = bundle.getString(key);
        } catch (MissingResourceException mrex) {
            if (defaultValue != null) {
                resource = defaultValue;
            } else {
                resource = NO_RESOURCE_FOUND + key;
            }
        }
        return resource;
    }
    /*
    public static String getStringFromBundle(String bundle, String key){
        PropertyResourceBundle resb = (PropertyResourceBundle)ResourceBundle.getBundle(bundle);
        if(resb!=null)
            return resb.getString(key);
        return "";
    }*/

    public static Object invokeMethodExpression(String expr, Class returnType, Class[] argTypes, Object[] args) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        MethodExpression methodExpr = elFactory.createMethodExpression(elctx, expr, returnType, argTypes);
        return methodExpr.invoke(elctx, args);
    }

    public static Object invokeMethodExpression(String expr, Class returnType, Class argType, Object argument) {
        return invokeMethodExpression(expr, returnType, new Class[] { argType }, new Object[] { argument });
    }


    /**
     * Create value binding for EL exression
     * @param expression
     * @return Object
     */
    public static Object getExpressionObjectReference(String expression) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elctx = fc.getELContext();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        return elFactory.createValueExpression(elctx, expression, Object.class).getValue(elctx);
    }

    public static MethodExpression getMethodExpression(String name) {
        String exp = "#{" + name + "}";
        Class[] argtypes = new Class[1];
        argtypes[0] = ActionEvent.class;
        FacesContext facesCtx = FacesContext.getCurrentInstance();
        Application app = facesCtx.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesCtx.getELContext();
        return elFactory.createMethodExpression(elContext, exp, null, argtypes);
    }

    public static ValueExpression getValueExpression(String name) {
        String exp = "#{" + name + "}";
        FacesContext facesCtx = FacesContext.getCurrentInstance();
        Application app = facesCtx.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesCtx.getELContext();
        return elFactory.createValueExpression(elContext, exp, Object.class);
    }

    public static Object getElObject(String expr) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExpressionFactory elFactory = fc.getApplication().getExpressionFactory();
        ELContext elContext = fc.getELContext();
        ValueExpression valueExp = elFactory.createValueExpression(elContext, expr, Object.class);
        return valueExp.getValue(elContext);
    }

    public static void printMessages() {
        FacesContext context = FacesContext.getCurrentInstance();
        Iterator iterator = context.getMessages();
        int count = 0;
        System.out.println("hasNext: " + iterator.hasNext());
        while (iterator.hasNext()) {
            FacesMessage fm = (FacesMessage) iterator.next();
            System.out.println("id: " + count + "  " + fm.getDetail() + " " + fm.getSummary());
        }
    }

    //    /**
    //     * Nombre registrado del bean de popup en el adfc-config.xml
    //     */
    //    public static final String POPUP_BEAN = "popup";
    //
    //    /**
    //     * Establece los valores del bean de Popup
    //     * que se encuentra en el scope : request
    //     * bajo el nombre dado por la variable POPUP_BEAN.
    //     *
    //     * @param title => title
    //     * @param imageUrl => image url
    //     * @param name => name
    //     * @param desc => desc
    //     */
    //    public static void setPopup(String title, String imageUrl, String name,
    //                                String desc) {
    //        PopupMgrBean popup;
    //        try {
    //            popup = (PopupMgrBean)getBeanReq(POPUP_BEAN, new PopupMgrBean());
    //            popup.setTitle(title);
    //            popup.setImageUrl(imageUrl);
    //            popup.setName(name);
    //            popup.setDesc(desc);
    //        } catch (Exception e) {
    //            e.printStackTrace();
    //        }
    //    }
    //


    /**
     * Usado para medir cuantos niveles se llaman en los metodos que sean recursivos
     * a la hora de hacer debug
     */
    private static int nivelesRecursividad = 0;

    /**
     * Para reiniciar los niveles de recursividad de prueba de esta clase
     */
    public static void restartNivelesRecursividad() {
        nivelesRecursividad = 0;
    }

    /**
     * retorna los niveles de recursividad para debug
     * @return
     */
    public static int getNivelesRecursividad() {
        return nivelesRecursividad;
    }

    //    /**
    //     * Busca recursivamente la primera aparicion en el arbol hacia arriba de un tipo
    //     * dado de UIComponent.
    //     *
    //     * Para modo debug llamar antes a restartNivelesRecursividad
    //     *
    //     * @param component componente hijo del arbol jsf
    //     * @param instanciaDe   tipo de class UIComponent que se quiere buscar
    //     * @return
    //     * @throws Exception
    //     */
    //    public static UIComponent findFirstParentInstanceOf(UIComponent component, Class instanciaDe) throws Exception{
    //        if(component == null || instanciaDe == null )
    //            throw new Exception("uiComponent nulo o instanciaDe nula!");
    //        if(UtilReflect.isCompatible(instanciaDe, component)){
    //            return component;
    //        }
    //        else{
    //            nivelesRecursividad++;
    //            return findFirstParentInstanceOf(component.getParent(),instanciaDe);//recursiva
    //        }
    //    }

    /**
     * No probado con formas y subformas pues pueden alterar el id (TODO revisar esto)
     * SI no lo encuentra retorna excepcion
     *
     *  * Para modo debug llamar antes a restartNivelesRecursividad
     *
     * @param id
     * @return
     */
    public static UIComponent findUiComponentById(UIComponent component, String id) throws Exception {
        if (component == null) {
            throw new Exception("No se encontro ID en ningun componente");
        }
        if (component.getId().equals(id))
            return component;
        else {
            nivelesRecursividad++;
            return findUiComponentById(component.getParent(), id); //recursiva
        }
    }

    //    /**
    //     * Trae el primer RichPopup del arbol JSF segun uicomponent
    //     * @param component
    //     * @return
    //     * @throws Exception
    //     */
    //    public static RichPopup findFirstParentPopup( UIComponent component) throws Exception {
    //        UIComponent find = findFirstParentInstanceOf(component, RichPopup.class);
    //        return (RichPopup)find;
    //    }


    /**
     * Trae la raiz del arbol de componentes
     * @param component
     * @return
     */
    public static UIComponent getRoot(UIComponent component) {
        if (component == null) {
            return null;
        } else {
            if (component.getParent() == null)
                return component;
            else {
                nivelesRecursividad++;
                return getRoot(component.getParent());
            }
        }
    }


    /**
     * No probado con formas y subformas pues pueden alterar el id (TODO revisar esto)
     * SI no lo encuentra retorna excepcion
     *
     * Busca en todos los hijos de un nodo raiz o en la raiz misma si el ID coincide con el tipo de dato esperado
     *
     *  * Para modo debug llamar antes a restartNivelesRecursividad
     *
     * @param id
     * @return
     */
    public static UIComponent findUiComponentDownById(UIComponent component, String id) throws Exception {
        if (component == null) {
            throw new Exception("No se encontro ID en ningun componente");
        }
        if (component.getId().equals(id))
            return component;
        else {
            nivelesRecursividad++;
            int kids = component.getChildCount();
            if (kids != 0) {
                for (UIComponent hijo : component.getChildren()) {
                    UIComponent subret = null;
                    try {
                        subret = findUiComponentDownById(hijo, id);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (subret != null)
                        return subret;
                }
            }
            return null; //recursiva
        }
    }

    /**
     * No probado con formas y subformas pues pueden alterar el id (TODO revisar esto)
     * SI no lo encuentra retorna excepcion
     *
     * Busca en todo el arbol, a partir de un hijo encuentra la raiz y luego comienza a buscar hacia abajo hasta que lo encuentra,
     * el algoritmo es bastante pesado y recursivo. Se recomienda en vez de usar esto, cablear el BackingBean con este
     * UIComponent desde el comienzo.
     *
     *
     *  * Para modo debug llamar antes a restartNivelesRecursividad
     *
     * @param id
     * @return
     */
    public static UIComponent findUiComponentInTreeById(UIComponent component, String id) throws Exception {
        UIComponent root = getRoot(component);
        return findUiComponentDownById(root, id);
    }

    /**
     * * Accion del af:setPropertyListener
     * Copia el valor de una expresion EL que representa el objeto from,
     * sobre la expresion EL que representa el objeto to.
     *
     * No controla ninguna excepcion asi como tampoco que las expresiones sean nulas
     *
     * @param fromEL
     * @param toEL
     * @throws Exception
     */
    public static void copyPropertyEL(String fromEL, String toEL) throws Exception {
        Object from = getElObject(fromEL);
        setExpressionValue(toEL, from);
    }

    /**
     * Accion del af:setPropertyListener
     *
     * Copia el valor de una expresion EL que representa el objeto from,
     * sobre la expresion EL que representa el objeto to.
     *
     * Controla que las expresiones NO sean nulas, asi como los objetos
     * que se traen bajo dichos EL, sin embargo el cast no es controlado por lo que puede arrojar una excepcion
     * en la asignacion.
     *
     * Retorna true si todo fue exitoso, sino retorna false pero no genera excepcion para valores nulos
     * solo un warning.
     *
     * @param fromEL
     * @param toEL
     * @return
     * @throws Exception
     */
    public static boolean copyPropertyELnotnull(String fromEL, String toEL) {
        if (fromEL == null || toEL == null) {
            return false;
        }
        Object from = getElObject(fromEL);

        if (from == null) {
            System.err.println("objeto de from es null");
            return false;
        }
        setExpressionValue(toEL, from);
        Object to = getElObject(toEL);
        if (to == null) {
            System.err.println("objeto de to es null");
            return false;
        }
        return true;
    }

    /**
     * Add JSF info message.
     * @param msg info message string
     */
    public static void addFacesInformationMessage(String msg) {
        FacesContext ctx = getFacesContext();
        FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, "");
        ctx.addMessage(getRootViewComponentId(), fm);
    }


    public static String getStringFromBundle(String bundle, String key) {
        PropertyResourceBundle resb = (PropertyResourceBundle) ResourceBundle.getBundle(bundle);
        if (resb != null)
            return resb.getString(key);
        return "";
    }

    public static String getClientIpAddress() {
        String clientIpAddress = "";
        try {
            FacesContext facesContext = getFacesContext();
            clientIpAddress = ((HttpServletRequest) facesContext.getExternalContext().getRequest()).getRemoteAddr();
        } catch (Exception e) {
            e.getMessage();
        }
        return clientIpAddress;
    }

    public static void refreshComponent(final UIComponent comp) {
        AdfFacesContext adfFacesContext;
        adfFacesContext = AdfFacesContext.getCurrentInstance();
        adfFacesContext.addPartialTarget(comp);
    }

    public static void refreshListComponents(final String[] lista) {
        if (lista != null && lista.length > 0) {
            for (int i = 0; i < lista.length; i++) {
                if (lista[i] != null && !"".equals(lista[i])) {
                    JsfUtils.refreshComponent(JsfUtils.findComponentInRoot(lista[i]));
                }
            }
        }
    }
    
    /**
     * Se encarga de ejecutar una operaciónn expuesta en la capa de los bindings
     * @param operationName Nombre de la operación a ejecutar
     * @return Valor de retorno de la operación expuesta en los bindings
     */
    public static Object executeOperation(String operationName) {
        try{
            return getOperationBinding(operationName).execute();
        }catch(Throwable i){            
            throw new RuntimeException(i);
        }
    }
    
    /**
     * Se encargará de obrtener la operación expuesta
     * @param operationName Nombre de la operación a consumir
     * @return Operador expuesto en los bindings
     */
    public static OperationBinding getOperationBinding(String operationName) {
        try{
            return getBindingContainer().getOperationBinding(operationName);
        }catch(Throwable i){            
            throw new RuntimeException(i);
        }
    }
    
    /**
     * Se encargá de extraer el contenedor de Bindings que se encuentre en el contexto manejado
     * @return Contenedor de Bindings
     */
    public static DCBindingContainer getBindingContainer() {
        return (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
    }
    
    
    /**
     * Elimina un objeto del mapa tipo Session.
     *
     * @param key => key
     */
    public static void deleteSessionMapValue(String key) {
        //Se saca del contexto el map que contiene parametros
        Map map = getExternalContext().getSessionMap();
        map.remove(key);
    }
    
    /**
     * Devuelve un objeto del mapa tipo Session
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key llave del mapa
     * @return ses map val
     */
    public static Object getSessionMapValue(String key) {
        // se saca del contexto el map que contiene parametros
        Map map = getExternalContext().getSessionMap();
        return map.get(key);
    }
    
    /**
     * Devuelve un objeto del mapa tipo Session
     * en el ExternalContext de Faces dado un valor.
     *
     * @param key => key
     * @param value => value
     */
    @SuppressWarnings("unchecked")
    public static void putSessionMapValue(String key, Object value) {
        Map map = getExternalContext().getSessionMap();
        map.put(key, value);
    }
}
