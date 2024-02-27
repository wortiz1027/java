package co.edu.javeriana.configuracion.utils;

import co.edu.javeriana.configuracion.annotations.list.NoPersistAttribute;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.adf.share.logging.ADFLogger;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierBinding;

import oracle.binding.BindingContainer;
import oracle.binding.ControlBinding;

import oracle.jbo.NavigatableRowIterator;

import oracle.jbo.Row;

import oracle.jbo.RowSetIterator;

import org.apache.myfaces.trinidad.model.CollectionModel;

public class ListUtils {
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(ListUtils.class);
    public ListUtils() {
        super();
    }
    public static Map<?,?> listToMap(final List<?> lista,final String key){
        final Map<String,Object> res=new HashMap<String,Object>();
        if(lista.size()>0){
            final Iterator it=lista.iterator();
            while(it.hasNext()){
                final Object obj=it.next();
                try { 
                    final Field temp=ListUtils.getField(obj.getClass(), key);
                    temp.setAccessible(true);
                    res.put(temp.get(obj).toString(), obj);
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el metodo getListObjectValue 1\" " +key + "\", originado por :  " +e.getMessage());
                }
            }
        }
        return res;
    }
    public static Boolean valueInList(final List<?> lista,final String key,final Object valor){
        final Object temp=ListUtils.findListItem(lista, key, valor,false);
        return temp==null?false:true;
    }
    public static Object findListItem(final List<?> lista,final String key,final Object valor){
        return ListUtils.findListItem(lista, key, valor,false);
    }
    public static Object findListItem(final List<?> lista,final Map<?,?> listaParametros){
        return ListUtils.findListItem(lista,listaParametros,false);
    }
    @SuppressWarnings("unchecked")
    public static Object findListItem(final List<?> lista,final String key,final Object valor, final Boolean remove){
        final Map params=new HashMap<String,Object>();
        params.put(key, valor);
        return ListUtils.findListItem(lista, params, remove);
    }
    @SuppressWarnings("unchecked")
    public static List findList(final List<?> lista,final String key,final Object valor){
        final Map params=new HashMap<String,Object>();
        params.put(key, valor);
        return ListUtils.findList(lista, params);
    }
    public static List<?> complexToSimpleList(final List<?> lista,final String attrName){
        final List<Object> res=new ArrayList<Object>();
        final Iterator it=lista.iterator();
        while(it.hasNext()){
            final Object temp=it.next();
            final Object val=ListUtils.getSimpleObjectValue(temp, attrName);
            res.add(val);
        }
        return res;
    }
    
    public static Object findListItem(final List<?> lista,final Map<?,?> params, final Boolean remove){
        if(lista.size()>0){
            final Iterator<?> it=lista.iterator();
            while(it.hasNext()){
                final Object item=it.next();
                final Set<String> set=(Set<String>)params.keySet();
                final List<String> keys=new ArrayList<String>(set);
                final Map<String,Object> temp=(Map<String,Object>)ListUtils.getListObjectValue(item,keys);
                final Iterator<String> itt=keys.iterator();
                Boolean encontrado=true;
                while(itt.hasNext()){
                    final String key=itt.next();
                    if(!params.get(key).equals(temp.get(key))){
                        encontrado=false;
                        break;
                    }
                }
                if(encontrado){
                    if(remove)
                        it.remove();
                    return item; 
                }
            }
        }
        return null;
    }
    public static final List findList(final List<?> lista,final Map<?,?> params){
        List res= new ArrayList();
        if(lista.size()>0){
            final Iterator<?> it=lista.iterator();
            while(it.hasNext()){
                final Object item=it.next();
                final Set<String> set=(Set<String>)params.keySet();
                final List<String> keys=new ArrayList<String>(set);
                final Map<String,Object> temp=(Map<String,Object>)ListUtils.getListObjectValue(item,keys);
                final Iterator<String> itt=keys.iterator();
                Boolean encontrado=true;
                while(itt.hasNext()){
                    final String key=itt.next();
                    if(!params.get(key).equals(temp.get(key))){
                        encontrado=false;
                        break;
                    }
                }
                if(encontrado){
                    res.add(item); 
                }
            }
        }
        return res;
    }
    public static void setObjectValue(final Object obj,final Object value,final String name){
        try { 
            final Field temp=obj.getClass().getDeclaredField(name);
            temp.setAccessible(true);
            temp.set(obj, value);
        } catch (IllegalAccessException e) {
            LOGGER.warning("Error en el metodo setObjectValue 1\" " +name + "\", originado por :  " +e.getMessage());
        } catch (NoSuchFieldException e) {
            LOGGER.warning("Error en el metodo setObjectValue 2\" " +name + "\", originado por :  " +e.getMessage());
        }
    }
    public static Object getSimpleObjectValue(final Object obj,final String name){
        try {
            final Field temp=ListUtils.getField(obj.getClass(), name);
            return temp.get(obj);
        } catch (IllegalAccessException e) {
            LOGGER.warning("Error en el metodo getListObjectValue 1\" " +name + "\", originado por :  " +e.getMessage());
        }
        return null;
    }
    public static Object getObjectValue(final Object obj,final String name){
        final List<String> names=new ArrayList<String>();
        names.add(name);
        return ListUtils.getListObjectValue(obj, names);
    }
    public static Map<?,?> getListObjectValue(final Object obj,final List<String> nombres){
        Map res=null;
            res= new HashMap<String,Object>();
            final Iterator<String> it= nombres.iterator();
            while(it.hasNext()){
                final String name=it.next();
                try { 
                    final Field temp=ListUtils.getField(obj.getClass(), name);
                    temp.setAccessible(true);
                    res.put(name, temp.get(obj));
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el metodo getListObjectValue 1\" " +name + "\", originado por :  " +e.getMessage());
                } 
            }
            return res;
    }
    
    public static Field getField(final Class<?> clase,final String name){
        Class<?> current=clase;
        do{
            try{
                return current.getDeclaredField(name);
            }catch(Exception e){
                LOGGER.info("Error en el metodo getField \" " +name + "\", originado por :  " +e.getMessage());
            }
            current = current.getSuperclass();
        }while(current!=null);
        return null;
    }
    public static void addItemToList(final Object obj,final String binding){
            final BindingContainer bindingContainer2 = (BindingContainer)JsfUtils.resolveExpression("#{bindings}");
                    
            //  Para obtener el objeto de la tabla (nombre de atributo tipo arreglo)
            final ControlBinding ctrlBinding2 = bindingContainer2.getControlBinding(binding);
            final FacesCtrlHierBinding fchb = (FacesCtrlHierBinding)ctrlBinding2;
            
            // Para agregar una fila al arreglo
            final CollectionModel model = fchb.getCollectionModel();
            final FacesCtrlHierBinding _biding = (FacesCtrlHierBinding)model.getWrappedData();
            final DCIteratorBinding dcIteratorBinding = _biding.getDCIteratorBinding();
            
            final NavigatableRowIterator nav =dcIteratorBinding.getNavigatableRowIterator();
            
            final Row rw = nav.createRow();
            rw.setNewRowState(Row.STATUS_INITIALIZED);
            final Row lastRow = nav.last();
            final int lastRowIndex = nav.getRangeIndexOf(lastRow);
            nav.insertRowAtRangeIndex(lastRowIndex+1, rw);
            dcIteratorBinding.setCurrentRowWithKey(rw.getKey().toStringFormat(true));
            
            final Field[] attr=obj.getClass().getDeclaredFields();
            for(int i=0;i<attr.length;i++){
                final Field temp=attr[i];
                temp.setAccessible(true);
                Boolean save=Boolean.TRUE;
                if(temp.isAnnotationPresent(NoPersistAttribute.class)){
                    save=Boolean.FALSE;
                }
                if(save){
                    String name=temp.getName();
                    if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                        try{
                            fchb.setAttribute(name, temp.get(obj)); 
                        } catch (IllegalAccessException e) {
                            LOGGER.warning("Error en el metodo addItemToList \" " +name + "\", originado por :  " +e.getMessage());
                        }catch (Exception e) {
                            LOGGER.warning("Error en el metodo addItemToList \" " +name + "\", originado por :  " +e.getMessage());
                        }catch(NoClassDefFoundError e){
                            LOGGER.warning("Clase no encontrada - "+e.getMessage());
                        }
                    }
                }
            }
        }
        
        public static void salvarLista(final List<?> lista,final String binding){
            final BindingContainer bindingContainer2 = (BindingContainer)JsfUtils.resolveExpression("#{bindings}");
                    
            //  Para obtener el objeto de la tabla (nombre de atributo tipo arreglo)
            final ControlBinding ctrlBinding2 = bindingContainer2.getControlBinding(binding);
            final FacesCtrlHierBinding fchb = (FacesCtrlHierBinding)ctrlBinding2;
            
            // Para agregar una fila al arreglo
            final CollectionModel model = fchb.getCollectionModel();
            final FacesCtrlHierBinding _biding = (FacesCtrlHierBinding)model.getWrappedData();
            final DCIteratorBinding dcIteratorBinding = _biding.getDCIteratorBinding();
            
            final Iterator it=lista.iterator();
            while(it.hasNext()){
                final Object obj=it.next();
                final NavigatableRowIterator nav =dcIteratorBinding.getNavigatableRowIterator();
                
                final Row rw = nav.createRow();
                rw.setNewRowState(Row.STATUS_INITIALIZED);
                final Row lastRow = nav.last();
                final int lastRowIndex = nav.getRangeIndexOf(lastRow);
                nav.insertRowAtRangeIndex(lastRowIndex+1, rw);
                dcIteratorBinding.setCurrentRowWithKey(rw.getKey().toStringFormat(true));
                
                final Field[] attr=obj.getClass().getDeclaredFields();
                for(int i=0;i<attr.length;i++){
                    final Field temp=attr[i];
                    temp.setAccessible(true);
                    Boolean save=Boolean.TRUE;
                    if(temp.isAnnotationPresent(NoPersistAttribute.class)){
                        save=Boolean.FALSE;
                    }
                    if(save){
                        final String name=temp.getName();
                        if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                            try{
                                fchb.setAttribute(name, temp.get(obj)); 
                            } catch (IllegalAccessException e) {
                                 LOGGER.warning("Error en el metodo salvarLista \" " +name + "\", originado por :  " +e.getMessage());
                            }catch (Exception e) {
                                 LOGGER.warning("Error en el metodo salvarLista \" " +name + "\", originado por :  " +e.getMessage());
                            }catch(NoClassDefFoundError e){
                                LOGGER.warning("Clase no encontrada - "+e.getMessage());
                            }
                        }
                    }
                }
                
            }
        }
        private static Map<String,Object> crearHashMap(final List<?> lista,final String key){
            final Map<String,Object> hash= new HashMap<String,Object>();
            final Iterator it=lista.iterator();
            while(it.hasNext()){
                try {
                    final Object obj=it.next();
                    Field temp = obj.getClass().getDeclaredField(key);
                    temp.setAccessible(true);
                    final Object val=temp.get(obj);
                    hash.put(val.toString(), obj);
                } catch (NoSuchFieldException e) {
                     e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }catch(NoClassDefFoundError e){
                    LOGGER.warning("Clase no encontrada - "+e.getMessage());
                }
            }
            return hash;
        }
        public static void cleanLista(final String binding){
            // Para tomar el contenedor donde estan los Data Object
            final BindingContainer bindingContainer2 = (BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            
            //  Para obtener el objeto de la tabla (nombre de atributo tipo arreglo)
            final ControlBinding ctrlBinding2 = bindingContainer2.getControlBinding(binding);
            final FacesCtrlHierBinding fchb = (FacesCtrlHierBinding)ctrlBinding2;
            
            // Para agregar una fila al arreglo
            final CollectionModel model = fchb.getCollectionModel();
            final FacesCtrlHierBinding _biding = (FacesCtrlHierBinding)model.getWrappedData();
            final DCIteratorBinding dcIteratorBinding = _biding.getDCIteratorBinding();
            
            final RowSetIterator rsi = dcIteratorBinding.getViewObject().createRowSetIterator(null);
            while(rsi.hasNext()){
                final Row row=rsi.next();
                row.remove();
            }
        }
        public static void actualizarLista(final List lista,final String key,final String binding){
            LOGGER.info("Metodo actualizarLista binding : "+binding);
            final BindingContainer bindingContainer2 = (BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            final ControlBinding ctrlBinding2 = bindingContainer2.getControlBinding(binding);
            final FacesCtrlHierBinding fchb = (FacesCtrlHierBinding)ctrlBinding2;
            
            final CollectionModel model = fchb.getCollectionModel();
            final FacesCtrlHierBinding _biding = (FacesCtrlHierBinding)model.getWrappedData();
            final DCIteratorBinding dcIteratorBinding = _biding.getDCIteratorBinding();
            
            final RowSetIterator rsi = dcIteratorBinding.getViewObject().createRowSetIterator(null);
            final Map hash=ListUtils.crearHashMap(lista, key);
            while(rsi.hasNext()){
                try {
                    final Row row=rsi.next();
               
                    final Object obj = hash.get(row.getAttribute(key).toString());
                    final Field[] attr=obj.getClass().getDeclaredFields(); 
                    for(int i=0;i<attr.length;i++){
                        Field temp=attr[i];
                        temp.setAccessible(true);
                        Boolean save=Boolean.TRUE;
                        if(temp.isAnnotationPresent(NoPersistAttribute.class)){
                            LOGGER.info("Anotacion encontrada SaveAttribute : "+temp.getName());
                            save=Boolean.FALSE;
                        }
                        if(save){
                            LOGGER.info("Salvar atributo : "+temp.getName());
                            String name=temp.getName();
                            if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                                try{
                                    LOGGER.info("Atributo : "+temp.getName()+" - valor: "+temp.get(obj));
                                    row.setAttribute(name, temp.get(obj));
                                } catch (IllegalAccessException e) {
                                    LOGGER.warning("Error en el metodo actualizarLista 1 \" " +name + "\", originado por :  " +e.getMessage());
                                }catch (Exception e) {
                                    LOGGER.warning("Error en el metodo actualizarLista 2 \" " +name + "\", originado por :  " +e.getMessage());
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    LOGGER.warning("Error en el metodo actualizarLista  originado por :  " +e.getMessage());
                }catch(NoClassDefFoundError e){
                    LOGGER.warning("Clase no encontrada - "+e.getMessage());
                }
            }
        }
        public static Row findRowBinding(final String binding,final String key,final Object valor, final Boolean remove){
            final Map params=new HashMap<String,Object>();
            params.put(key, valor);
            return ListUtils.findRowBinding(binding, params, remove);
        }
        public static Row findRowBinding(final String binding,final Map<?,?> params, final Boolean remove){
            final BindingContainer bindingContainer2 = (BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            final ControlBinding ctrlBinding2 = bindingContainer2.getControlBinding(binding);
            final FacesCtrlHierBinding fchb = (FacesCtrlHierBinding)ctrlBinding2;
            
            final CollectionModel model = fchb.getCollectionModel();
            final FacesCtrlHierBinding _biding = (FacesCtrlHierBinding)model.getWrappedData();
            final DCIteratorBinding dcIteratorBinding = _biding.getDCIteratorBinding();
            
            final RowSetIterator rsi = dcIteratorBinding.getViewObject().createRowSetIterator(null);
            
            while(rsi.hasNext()){
                try {
                    final Row row=rsi.next();
                    final Set<String> set=(Set<String>)params.keySet();
                    final List<String> keys=new ArrayList<String>(set);
                    final Iterator<String> itt=keys.iterator();
                    Boolean encontrado=true;
                    while(itt.hasNext()){
                        final String key=itt.next();
                        if(!params.get(key).equals(row.getAttribute(key))){
                            encontrado=false;
                            break;
                        }
                        if(encontrado){
                            if(remove)
                                row.remove();
                            return row; 
                        }
                    }
                    
                }catch (Exception e) {
                    LOGGER.warning("Error en el metodo findRowBinding  originado por :  " +e.getMessage());
                }catch(NoClassDefFoundError e){
                    LOGGER.warning("Clase no encontrada - "+e.getMessage());
                }
            }
            return null;
        }
        public static NavigatableRowIterator getRowIteratorBinding(String binding){
            final BindingContainer bindingContainer2 = (BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            
            //  Para obtener el objeto de la tabla (nombre de atributo tipo arreglo)
            final ControlBinding ctrlBinding2 = bindingContainer2.getControlBinding(binding);
            final FacesCtrlHierBinding fchb = (FacesCtrlHierBinding)ctrlBinding2;
            
            // Para agregar una fila al arreglo
            final CollectionModel model = fchb.getCollectionModel();
            final FacesCtrlHierBinding _biding = (FacesCtrlHierBinding)model.getWrappedData();
            final DCIteratorBinding dcIteratorBinding = _biding.getDCIteratorBinding();
            final NavigatableRowIterator nav =dcIteratorBinding.getNavigatableRowIterator();
            return nav;
        }
        public static void cargarLista(final List lista,final Class clase,final String binding){
            // Para tomar el contenedor donde estan los Data Object
            final BindingContainer bindingContainer2 = (BindingContainer)JsfUtils.resolveExpression("#{bindings}");
            
            //  Para obtener el objeto de la tabla (nombre de atributo tipo arreglo)
            final ControlBinding ctrlBinding2 = bindingContainer2.getControlBinding(binding);
            final FacesCtrlHierBinding fchb = (FacesCtrlHierBinding)ctrlBinding2;
            
            // Para agregar una fila al arreglo
            final CollectionModel model = fchb.getCollectionModel();
            final FacesCtrlHierBinding _biding = (FacesCtrlHierBinding)model.getWrappedData();
            final DCIteratorBinding dcIteratorBinding = _biding.getDCIteratorBinding();
            
            final RowSetIterator rsi = dcIteratorBinding.getViewObject().createRowSetIterator(null);
            while(rsi.hasNext()){
                try {
                    final Row row=rsi.next();
                    final Object obj = clase.newInstance();
                    final Field[] attr=obj.getClass().getDeclaredFields();
                    for(int i=0;i<attr.length;i++){
                        final Field temp=attr[i];
                        temp.setAccessible(true);
                        final String name=temp.getName();
                        if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                            try{
                                temp.set(obj,row.getAttribute(name));
                            } catch (IllegalAccessException e) {
                                LOGGER.warning("Error en el metodo cargarLista \" " +name + "\", originado por :  " +e.getMessage());
                            }catch (Exception e) {
                                LOGGER.warning("Error en el metodo cargarLista \" " +name + "\", originado por :  " +e.getMessage());
                            }
                        }
                    }
                    lista.add(obj);
                } catch (InstantiationException e) {
                    LOGGER.warning("Error en el metodo cargarLista  originado por :  " +e.getMessage());
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el metodo cargarLista  originado por :  " +e.getMessage());
                }catch(NoClassDefFoundError e){
                    LOGGER.warning("Clase no encontrada - "+e.getMessage());
                }
            }
        }
}
