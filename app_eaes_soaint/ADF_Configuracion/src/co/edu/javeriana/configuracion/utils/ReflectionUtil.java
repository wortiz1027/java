package co.edu.javeriana.configuracion.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import java.util.Map;

import oracle.adf.share.logging.ADFLogger;

/**
 * <p>Utility class that uses {@code java.lang.reflect} standard library.
 * It provides easy access to the standard reflect methods that are
 * needed usually when dealing with generic object types.</p>
 *
 * @author Qussay Najjar
 * @version 1.0
 * @link http://qussay.com/2013/09/28/handling-java-generic-types-with-reflection
 */
public class ReflectionUtil {
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(ReflectionUtil.class);
    private static final List<Class> tipos= new ArrayList<Class>();
    static{
        tipos.add(String.class);
        tipos.add(Double.class);
        tipos.add(Integer.class);
        tipos.add(Boolean.class);
        tipos.add(Float.class);
        tipos.add(Byte.class);
        tipos.add(Character.class);
        tipos.add(Long.class);
        tipos.add(Short.class);  
    }
	/**
	 * When {@code Type} initialized with a value of an object, its fully qualified class name 
	 * will be prefixed with this.
	 * 
	 * @see {@link ReflectionUtil#getClassName(Type)}
	 */
	private static final String TYPE_NAME_PREFIX = "class ";
	
	/*
	 *  Utility class with static access methods, no need for constructor.
	 */
	private ReflectionUtil() {}
	
	/**
	 * {@link Type#toString()} value is the fully qualified class name prefixed
	 * with {@link ReflectionUtil#TYPE_NAME_PREFIX}. This method will substring it, for it to be eligible
	 * for {@link Class#forName(String)}.
	 * 
	 * @param type the {@code Type} value whose class name is needed.  
	 * @return {@code String} class name of the invoked {@code type}.
	 * 
	 * @see {@link ReflectionUtil#getClass()}
	 */
	public static String getClassName(final Type type) {
		if (type==null) {
			return "";
		}
		String className = type.toString();
		if (className.startsWith(TYPE_NAME_PREFIX)) {
	    	className = className.substring(TYPE_NAME_PREFIX.length());
	    }
	    return className;
	}
	
	/**
	 * Returns the {@code Class} object associated with the given {@link Type}
	 * depending on its fully qualified name. 
	 * 
	 * @param type the {@code Type} whose {@code Class} is needed.
	 * @return the {@code Class} object for the class with the specified name.
	 * 
	 * @throws ClassNotFoundException if the class cannot be located.
	 * 
	 * @see {@link ReflectionUtil#getClassName(Type)}
	 */
	public static Class<?> getClass(final Type type) 
			throws ClassNotFoundException {
		final String className = getClassName(type);
		if (className==null || className.isEmpty()) {
			return null;
		}
		return Class.forName(className);
	}
	
	/**
	 * Creates a new instance of the class represented by this {@code Type} object.
	 * 
	 * @param type the {@code Type} object whose its representing {@code Class} object 
	 * 		will be instantiated.  
	 * @return a newly allocated instance of the class represented by 
	 * 		the invoked {@code Type} object.
	 * 
	 * @throws ClassNotFoundException if the class represented by this {@code Type} object 
	 * 			cannot be located.
	 * @throws InstantiationException if this {@code Type} represents an abstract class,
     *             an interface, an array class, a primitive type, or void;
     *             or if the class has no nullary constructor;
     *             or if the instantiation fails for some other reason.
	 * @throws IllegalAccessException if the class or its nullary constructor is not accessible.
	 * 
	 * @see {@link Class#newInstance()}
	 */
	public static Object newInstance(Type type) 
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		final Class<?> clazz = getClass(type);
		if (clazz==null) {
			return null;
		}
		return clazz.newInstance();
	}
	
	/**
	 * Returns an array of {@code Type} objects representing the actual type
     * arguments to this object.
     * If the returned value is null, then this object represents a non-parameterized 
     * object.
	 * 
	 * @param object the {@code object} whose type arguments are needed. 
	 * @return an array of {@code Type} objects representing the actual type 
	 * 		arguments to this object.
	 * 
	 * @see {@link Class#getGenericSuperclass()}
	 * @see {@link ParameterizedType#getActualTypeArguments()}
	 */
	public static Type[] getParameterizedTypes(final Object object) {
		final Type superclassType = object.getClass().getGenericSuperclass();
		if (!ParameterizedType.class.isAssignableFrom(superclassType.getClass())) {
			return null;
		}
		
		return ((ParameterizedType)superclassType).getActualTypeArguments();
	}
	
	/**
	 * Checks whether a {@code Constructor} object with no parameter types is specified
     * by the invoked {@code Class} object or not.
	 * 
	 * @param clazz the {@code Class} object whose constructors are checked.
	 * @return {@code true} if a {@code Constructor} object with no parameter types is specified.
	 * @throws SecurityException If a security manager, <i>s</i> is present and any of the
     *         following conditions is met:
     *			<ul>
     *             <li> invocation of
     *             {@link SecurityManager#checkMemberAccess
     *             s.checkMemberAccess(this, Member.PUBLIC)} denies
     *             access to the constructor
     *
     *             <li> the caller's class loader is not the same as or an
     *             ancestor of the class loader for the current class and
     *             invocation of {@link SecurityManager#checkPackageAccess
     *             s.checkPackageAccess()} denies access to the package
     *             of this class
     *         </ul>
     *         
     * @see {@link Class#getConstructor(Class...)}
	 */
	public static boolean hasDefaultConstructor(final Class<?> clazz) throws SecurityException {
		final Class<?>[] empty = {};
		try {
			clazz.getConstructor(empty);
		} catch (NoSuchMethodException e) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns a {@code Class} object that identifies the
     * declared class for the field represented by the given {@code String name} parameter inside 
     * the invoked {@code Class<?> clazz} parameter.
	 * 
	 * @param clazz the {@code Class} object whose declared fields to be 
	 * 		checked for a certain field.
	 * @param name the field name as {@code String} to be 
	 * 		compared with {@link Field#getName()} 
	 * @return the {@code Class} object representing the type of given field name.
	 * 
	 * @see {@link Class#getDeclaredFields()}
	 * @see {@link Field#getType()}
	 */
	public static Class<?> getFieldClass(final Class<?> clazz, String name) {
		if (clazz==null || name==null || name.isEmpty()) {
			return null;
		}
		
		name = name.toLowerCase();
		Class<?> propertyClass = null;
		
		for (final Field field : clazz.getDeclaredFields()) {
		    field.setAccessible(true);
		    if (field.getName().equals(name)) {
		    	propertyClass = field.getType();
		    	break;
		    }
		}
		
		return propertyClass;
	}
	
	/**
	 * Extracts the enum constant of the specified enum class with the
     * specified name. The name must match exactly an identifier used
     * to declare an enum constant in the given class.
	 * 
	 * @param clazz the {@code Class} object of the enum type from which 
	 * 		to return a constant.
	 * @param name the name of the constant to return.
	 * @return the enum constant of the specified enum type with the
     *      specified name.
     *      
     * @throws IllegalArgumentException if the specified enum type has
     *         no constant with the specified name, or the specified
     *         class object does not represent an enum type.
     *         
     * @see {@link Enum#valueOf(Class, String)}
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object getEnumConstant(Class<?> clazz, final String name) {
		if (clazz==null || name==null || name.isEmpty()) {
			return null;
		}
		return Enum.valueOf((Class<Enum>)clazz, name);
	}
    public static void cloneObject(final Object fuente,final Object destino){
        if(fuente==null || destino== null || !fuente.getClass().equals(destino.getClass())){
            return;
        }
    
        final Field[] attr =fuente.getClass().getDeclaredFields();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            final String name=temp.getName();
            if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                try{
                    final Field tempDes=destino.getClass().getDeclaredField(name);
                    tempDes.setAccessible(true);
                    tempDes.set(destino, temp.get(fuente));
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }catch (Exception e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }
            }
        }
    }
    private static Boolean isBasicType(final Field  field){
        final Iterator<Class> it=tipos.iterator();
        while(it.hasNext()){
            if(field.getType().equals(it.next())){
                return true;
            }
        }
        return false;
    }
    public static void cleanObject(final Object o){
        final Field[] attr =o.getClass().getDeclaredFields();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            final String name=temp.getName();
            if(!ReflectionUtil.isBasicType(temp)){
                try{
                    final Field tempDes=o.getClass().getDeclaredField(name); 
                    tempDes.setAccessible(true);
                    final Object value=temp.get(o);
                    ReflectionUtil.cleanObject(value);
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }catch (Exception e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }
            }else if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                try{
                    Field tempDes=o.getClass().getDeclaredField(name); 
                    tempDes.setAccessible(true);
                    if(tempDes.getType().equals(String.class)){
                         tempDes.set(o, "");
                    }else if(tempDes.getType().equals(Integer.class) ){
                        tempDes.set(o,0);
                    }else if( tempDes.getType().equals(Long.class)){
                        tempDes.set(o,0L);
                    }else if(tempDes.getType().equals(Short.class)){
                        tempDes.set(o,new Short("0"));
                    }else if(tempDes.getType().equals(Double.class)){
                        tempDes.set(o,0.0D);
                    }else if(tempDes.getType().equals(Float.class)){
                        tempDes.set(o,0.0F);
                    }else if(tempDes.getType().equals(Boolean.class)){
                        tempDes.set(o,false);
                    }else{
                        tempDes.set(o,null);
                    } 
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }catch (Exception e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }
            }
        }
    }
    public static void printf(final Object o){
        final Field[] attr =o.getClass().getDeclaredFields();
        for(int i=0;i<attr.length;i++){
            final Field temp=attr[i];
            temp.setAccessible(true);
            final String name=temp.getName();
            if(!ReflectionUtil.isBasicType(temp)){
                try{
                    Field tempDes=o.getClass().getDeclaredField(name); 
                    tempDes.setAccessible(true);
                    Object value=temp.get(o);
                    ReflectionUtil.printf(value);
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }catch (Exception e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }
            }else if(!java.lang.reflect.Modifier.isStatic(temp.getModifiers())){
                try{
                    Field tempDes=o.getClass().getDeclaredField(name); 
                    tempDes.setAccessible(true);
                    Object value=temp.get(o);
                    LOGGER.info("------ "+name+" =====> "+value);
                } catch (IllegalAccessException e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }catch (Exception e) {
                    LOGGER.warning("Error en el cloneObject \" " +name + "\", originado por :  " +e.getMessage());
                }
            }
        }
    }
    public static Map<?,?> convertListToMap(final List<?> lista,final String key){
        final Map res= new HashMap<Object,Object>();
        if(lista.size()<=0)
            return res;
        try{
            final Iterator<?> it=lista.iterator();
            while(it.hasNext()){
                final Object temp=it.next();
                Field tempDes=temp.getClass().getDeclaredField(key); 
                tempDes.setAccessible(true);
                Object value=tempDes.get(temp);
                res.put(value, temp);
            }
        } catch (IllegalAccessException e) {
            LOGGER.warning("Error en el convertListToMap \" " +key + "\", originado por :  " +e.getMessage());
        }catch (Exception e) {
            LOGGER.warning("Error en el convertListToMap \" " +key + "\", originado por :  " +e.getMessage());
        }
        return res;
    }
}