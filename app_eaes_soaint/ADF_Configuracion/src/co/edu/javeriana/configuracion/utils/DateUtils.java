package co.edu.javeriana.configuracion.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import oracle.adf.share.logging.ADFLogger;

public class DateUtils{
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(DateUtils.class);
    public static final String FORMATO_FECHA = "dd-MM-yyyy";
    public static final String FORMATO_FECHA_HORA = "dd-MM-yyyy HH:mm:ss";
    public static final String FORMATO_FECHA_SOA ="yyyy-MM-dd"; // formato que se planea usar: "yyyy-MM-dd";

    public static final String FORMATO_TIMESTAMP_SOA = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String FORMATO_TIMESTAMP_TIMEZONE_SOA ="yyyy-MM-ddHH:mm:ss-SS:SS";
    public static final String FORMATO_ANIO_MES_DIA_HORA_MIN_SEG_XMLGREGORIANCALENDAR = "yyyy-MM-dd'T'HH:mm:ss'Z'";
    public static final String FORMATO_HORA_MINUTO = "HH:mm";
    
    public static final int MILLSECS_PER_DAY = (1000*60*60*24);
    public static final int MILLSECS_PER_HOUR = (1000*60*60);
    
    public DateUtils() {
        super();
    }

    public static Boolean validarFormatoFecha(final String fecha) {
        try {
            final DateFormat format = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            format.parse(fecha);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static Boolean isFechaMayor(final String fecha1,
                                       final String fecha2) {
        try{
            final DateFormat format = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            if (!fecha1.equals(fecha2)) {
                final Date fechaF1 = format.parse(fecha1);
                final Date fechaF2 = format.parse(fecha2);
                return fechaF2.before(fechaF1);
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Boolean isFechaMayorIgualAldia(final Date fecha1) { 
        final Date hoy = new Date();
        if(hoy.equals(fecha1)){
            return Boolean.TRUE;
        }
        return hoy.before(fecha1);
    }
    public static Boolean isFechaIgualHoy(final String fecha1){
        try{
            final DateFormat format = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            final Date fechaF1 = format.parse(fecha1);
            return DateUtils.isFechaIgualHoy(fechaF1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Boolean isFechaIgualHoy(final Date fecha1){
        if (fecha1.equals(DateUtils.hoy())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
    public static Boolean isFechaMayorAldia(final Date fecha1) {
        if (!fecha1.equals(DateUtils.hoy())) {
            final Date hoy = new Date();
            return hoy.before(fecha1);
        }
        return false;
    }
    public static Boolean isFechaMayorAOtra(final Date fecha1,final Date fechaOtra) {
        if (!fecha1.equals(fechaOtra)) {
            return fechaOtra.before(fecha1);
        }
        return false;
    }
    public static Boolean isFechaMayorAldia(final String fecha1){
        try{
            final DateFormat format = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            final Date fechaF1 = format.parse(fecha1);
            return DateUtils.isFechaMayorAldia(fechaF1);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String hoyFechaToSOA() {
        final DateFormat soaFormat = new SimpleDateFormat(DateUtils.FORMATO_FECHA_SOA);
        return soaFormat.format(new Date());
    }
    public static String converFormatDateToSOA(final Date fecha){
        try{
            final DateFormat soaFormat = new SimpleDateFormat(DateUtils.FORMATO_FECHA_SOA);
            return soaFormat.format(fecha);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String converFormaToSOA(final String fecha){
        if (fecha == null)
            return "";
        try{
            final DateFormat format = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            final Date fechaF = format.parse(fecha);
    
    
            final DateFormat soaFormat =
                new SimpleDateFormat(DateUtils.FORMATO_FECHA_SOA);
            return soaFormat.format(fechaF);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String converFormatSOAToNormal(final String fecha){
        if (fecha == null)
            return "";
        try{
            final DateFormat format = new SimpleDateFormat(DateUtils.FORMATO_FECHA_SOA);
            final Date fechaF = format.parse(fecha);
            final DateFormat soaFormat = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            return soaFormat.format(fechaF);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String converDateToString(final Date fecha){
        try{
            final DateFormat soaFormat = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            return soaFormat.format(fecha);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static String hoyFechaToString() {
        final DateFormat soaFormat = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
        return soaFormat.format(new Date());
    }
    
    public static String hoyFechaHoraToString() {
        final DateFormat soaFormat = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
        return soaFormat.format(new Date());
    }
    
    public static Date hoy(){
        Date res=null;
        try {
            final Calendar now = Calendar.getInstance();
            final Date date = now.getTime();
            final DateFormat formatter = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            final String currentDate = formatter.format(date);
            res=formatter.parse(currentDate);
        } catch (Exception e) {
               return null;
        }
        return res;
    }
    
    public static Date hoy(String format){
        Date res=null;
        try {
            final Calendar now = Calendar.getInstance();
            final Date date = now.getTime();
            final DateFormat formatter = new SimpleDateFormat(format);
            final String currentDate = formatter.format(date);
            res=formatter.parse(currentDate);
        } catch (Exception e) {
               return null;
        }
        return res;
    }
    
    public static Date stringToDate(final String fecha){
        Date res=null;
        try{
            final SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.FORMATO_FECHA); 
            res = sdf.parse(fecha);
        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

    public static GregorianCalendar stringToGregorianCalendar(final String dateString) throws ParseException {
        try{
            final SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            final Date date = sdf.parse(dateString);
            final GregorianCalendar calender = new GregorianCalendar();
            calender.setTime(date);
            return calender;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static String converTimeStampToSOA(final Date fecha) throws ParseException {
        final DateFormat soaFormat =
            new SimpleDateFormat(DateUtils.FORMATO_TIMESTAMP_SOA);
        return soaFormat.format(fecha);
    }

    public static XMLGregorianCalendar stringToXMLGregorianCalendar(final String valor){
        try{
            final SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.FORMATO_FECHA);
            final Date date = sdf.parse(valor);
            final GregorianCalendar c = new GregorianCalendar();
            c.setTime(date);
            final XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            calendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
            return calendar;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static Date xmlGregorianCalendarToDate(final XMLGregorianCalendar fecha){
        Date res=null;
        if(BooleanUtils.existe(fecha)){
            res=fecha.toGregorianCalendar().getTime();
        }
        return res;
    }
    public static String convertXMLGregorianCalendarToString(final XMLGregorianCalendar fecha){
        final String res=DateUtils.converDateToString(fecha.toGregorianCalendar().getTime());
        return res;
    }
    public static XMLGregorianCalendar dateToXMLGregorianCalendar(final Date fecha){
        try{
            final GregorianCalendar c = new GregorianCalendar();
            c.setTime(fecha);
            final XMLGregorianCalendar calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            calendar.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
            return calendar;
        }catch(Exception e){
           e.printStackTrace(); 
        }
        return null;
    }
    
    public static XMLGregorianCalendar dateToXMLGregorianCalendar(final Date fecha, final String mascara){
        try{
            final DateFormat format = new SimpleDateFormat(mascara);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar(format.format(fecha));
        }catch(Exception e){
           e.printStackTrace(); 
        }
        
        return null;
    }
    
    public static Integer calcularEdad(final String fecha){
        Date fechaNac=null;
        try {
            fechaNac = new SimpleDateFormat(DateUtils.FORMATO_FECHA).parse(fecha);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        final Calendar fechaNacimiento = Calendar.getInstance();
        final Calendar fechaActual = Calendar.getInstance();
        fechaNacimiento.setTime(fechaNac);
        int anio = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        final int mes =fechaActual.get(Calendar.MONTH)- fechaNacimiento.get(Calendar.MONTH);
        final int dia = fechaActual.get(Calendar.DATE)- fechaNacimiento.get(Calendar.DATE);
        if(mes<0 || (mes==0 && dia<0)){
            anio--;
        }
        return anio;
    }
    public static Date converSqlToUtilDate(final java.sql.Date fecha){
        Date fechaRes=null;
        LOGGER.info("Fecha = "+fecha);
        if (fecha != null) {
            fechaRes = new Date(fecha.getTime());
            LOGGER.info("util sql "+fechaRes);
        }
        return fechaRes;
    }
    public static Date converJboToUtilDate(final oracle.jbo.domain.Date fecha){
        Date fechaRes=null;
        LOGGER.info("Fecha = "+fecha);
        if (fecha != null) {
            LOGGER.info("fecha diferente de null "+fecha);
            java.sql.Date sqldate = fecha.dateValue();
            LOGGER.info("fecha sql "+sqldate);
            fechaRes = new Date(sqldate.getTime());
            LOGGER.info("util sql "+fechaRes);
        }
        return fechaRes;
    }
    public static String getDateKey(){
        final GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        final String res =cal.get(GregorianCalendar.DAY_OF_MONTH)+""+cal.get(GregorianCalendar.MONTH)+""+cal.get(GregorianCalendar.YEAR)+""+cal.get(GregorianCalendar.HOUR)+cal.get(GregorianCalendar.MINUTE)+""+cal.get(GregorianCalendar.SECOND);
        return res;
    }
    public static String getFormatoFechaLargo(final Date fecha) {
        final GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);
        final String res =
            DateUtils.getDiaCalendar(cal.get(GregorianCalendar.DAY_OF_WEEK)) +
            " " + cal.get(GregorianCalendar.DAY_OF_MONTH) + " de " +
            DateUtils.getMesCalendar(cal.get(GregorianCalendar.MONTH)) +
            " del " + cal.get(GregorianCalendar.YEAR);
        return res;
    }
    public static Date sumarRestarDiaHoy(final Integer sumarDia,final Integer restarDia){
        final Calendar calendar =Calendar.getInstance();
        calendar.setTime(DateUtils.hoy());
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        if(sumarDia!=null){
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)+sumarDia);
        }
        if(restarDia!=null){
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-restarDia);
        }
        return calendar.getTime();
    }
    public static String getYear() {
        final GregorianCalendar cal = new GregorianCalendar();
        return cal.get(GregorianCalendar.YEAR) + "";
    }

    public static String getMonth() {
        final GregorianCalendar cal = new GregorianCalendar();
        final String mes = cal.get(GregorianCalendar.MONTH) + "";
        return mes.length() > 1 ? mes : "0" + mes;
    }

    public static String getFormatoHora(final Date fecha) {
        final GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(fecha);

        String min = cal.get(GregorianCalendar.MINUTE) + "";
        if (!(min.length() > 1)) {
            min = "0" + min;
        }
        String hour = cal.get(GregorianCalendar.HOUR) + "";
        if (!(hour.length() > 1)) {
            hour = "0" + hour;
        }
        final String am_pm =
            cal.get(GregorianCalendar.HOUR_OF_DAY) >= 12 ? "PM" : "AM";
        final String res = hour + ":" + min + " " + am_pm;
        return res;
    }

    public static String getMesCalendar(final int mes) {
        final Map<Integer, String> meses = new HashMap<Integer, String>();
        meses.put(GregorianCalendar.JANUARY, "Enero");
        meses.put(GregorianCalendar.FEBRUARY, "Febrero");
        meses.put(GregorianCalendar.MARCH, "Marzo");
        meses.put(GregorianCalendar.APRIL, "Abril");
        meses.put(GregorianCalendar.MAY, "Mayo");
        meses.put(GregorianCalendar.JUNE, "Junio");
        meses.put(GregorianCalendar.JULY, "Julio");
        meses.put(GregorianCalendar.AUGUST, "Agosto");
        meses.put(GregorianCalendar.SEPTEMBER, "Septiembre");
        meses.put(GregorianCalendar.OCTOBER, "Octubre");
        meses.put(GregorianCalendar.NOVEMBER, "Noviembre");
        meses.put(GregorianCalendar.DECEMBER, "Diciembre");
        return meses.get(mes);
    }

    public static String getDiaCalendar(final int dia) {
        final Map<Integer, String> dias = new HashMap<Integer, String>();
        dias.put(GregorianCalendar.MONDAY, "Lunes");
        dias.put(GregorianCalendar.TUESDAY, "Martes");
        dias.put(GregorianCalendar.WEDNESDAY, "Miercoles");
        dias.put(GregorianCalendar.THURSDAY, "Jueves");
        dias.put(GregorianCalendar.FRIDAY, "Viernes");
        dias.put(GregorianCalendar.SATURDAY, "Sabado");
        dias.put(GregorianCalendar.SUNDAY, "Domingo");
        return dias.get(dia);
    }
    public static oracle.jbo.domain.Date getDateJboToday(){
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        oracle.jbo.domain.Date fecha = new oracle.jbo.domain.Date(sqlDate);
        return fecha;
    }
    
    public static Date hoyConHora(){
        Date res=null;
        try {
            final Calendar now = Calendar.getInstance();
            final Date date = now.getTime();
            final DateFormat formatter = new SimpleDateFormat(DateUtils.FORMATO_FECHA_HORA);
            final String currentDate = formatter.format(date);
            res=formatter.parse(currentDate);
        } catch (Exception e) {
               return null;
        }
        return res;
    }
    
    
    public static void main(String[] args){  
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String stringFechaConHora = "19-09-2009";        
        String stringFechaFin= "19-09-2019";  
        Date fechaIni = null;
       
        Date fechaFin = null;
        try {
            fechaIni = sdf.parse(stringFechaConHora);
            fechaFin = sdf.parse(stringFechaFin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       
        StringTokenizer st = new StringTokenizer("07:01",":");
        fechaIni = new Date();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
        }
        

        //fechaIni =isFechaMayorIgualAldia(fecha1);
        System.out.println(">>>> Fecha = "+new Date().before(fechaIni));    
        
        /*Date fechaIni = hoyConHora();
        Date fechaFin = new Date ();*/
        
        
        System.out.println(obtenerHoraApartirDeDate(new Date()));
        
       /* System.out.println(">>>> Fecha = "+fechaIni);
        System.out.println(">>>> Fecha Fin = "+fechaFin);
        System.out.println("Diferencia  "+isFechaMayorIgualAldia(fechaIni));*/
    }
    
    /**
     * Metodo que calcula la diferencia de las horas que han pasado entre dos fechas
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    public static long diferenciaHorasDias(Date fechaInicio, Date fechaFin) {
        Calendar calendarInicio = Calendar.getInstance();
        Calendar calendarFin    = Calendar.getInstance();

        calendarInicio.setTimeInMillis(fechaInicio.getTime());
        calendarFin.setTimeInMillis(fechaFin.getTime());  
        //Milisegundos al día
        long diferenciaHoras = 0;
        //Restamos a la fecha final la fecha inicial y lo dividimos entre el numero de milisegundos al dia
        diferenciaHoras = (calendarFin.getTimeInMillis() - calendarInicio.getTimeInMillis()) / MILLSECS_PER_HOUR;
        
        return diferenciaHoras;
    }
    
    /**
     *<p>Permite determinar el número de días habiles que existen entre una fecha de inicio y una fecha fin;
     * esto omitiendo los días festivos</p>
     *
     * @param fechaInicio Fecha de arranque
     * @param fechaFin Fecha final
     * @return Entero que determina el número de días habiles sin tener en cuenta los días festivos
     */
    public static int numeroDiasHabiles(Date fechaInicio, Date fechaFin) {
        int numeroDiasHabiles   = 0;
        Calendar calendarInicio = Calendar.getInstance();
        Calendar calendarFin    = Calendar.getInstance();

        calendarInicio.setTimeInMillis(fechaInicio.getTime());
        calendarFin.setTimeInMillis(fechaFin.getTime());
        
        //numeroDiasHabiles = (int) (((calendarFin.getTimeInMillis() - calendarInicio.getTimeInMillis()) / MILLSECS_PER_DAY) % 7);
        numeroDiasHabiles = Integer.valueOf("" + (calendarFin.getTimeInMillis() - calendarInicio.getTimeInMillis()) / MILLSECS_PER_DAY);
        
        if (numeroDiasHabiles > 0) {
            //Mientras la fecha inicial sea menor o igual que la fecha final se cuentan los dias
            while (calendarInicio.before(calendarFin) || calendarInicio.equals(calendarFin)) {
                //Si el dia de la semana de la fecha minima es diferente de sabado o domingo
                if (calendarInicio.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                    calendarInicio.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                    //Se restan los días festivos
                    numeroDiasHabiles--;
                }//End if
                
                //Se suma 1 dia para hacer la validacion del siguiente dia.
                calendarInicio.add(Calendar.DATE, 1);
            }//End while
        } else {
            numeroDiasHabiles = 0;
        }//End if else
        
        return numeroDiasHabiles;
    }
    
    /**
     * Método encargado de sumarle dias a una fecha
     * @param fecha
     * @param sumDias
     * @return
     */
    public static Date aumentarDiasFecha (Date fecha, int sumDias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, sumDias);  // numero de días a añadir,
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }
    
    /**
     * Método encargado de aumentar horas, minutos y segundos a una fecha
     * @param fecha
     * @param horas
     * @param munutos
     * @param segundos
     * @return
     */
    public static Date agregarHoraFecha (Date fecha, int horas, int munutos,int segundos) {
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTimeInMillis(fecha.getTime());
        calendarInicio.add(Calendar.HOUR, horas);
        calendarInicio.add(Calendar.MINUTE, munutos);
        calendarInicio.add(Calendar.SECOND, segundos);                
        return calendarInicio.getTime();
    }
    
    /**
     * M�todo encargado de asignar la hora que requiero a una fecha
     * @param fecha
     * @param horas
     * @param munutos
     * @param segundos
     * @return
     */
    public static Date asignarHoraAlaFecha (Date fecha, int horas, int munutos,int segundos) {
        Calendar calendarInicio = Calendar.getInstance();
        calendarInicio.setTimeInMillis(fecha.getTime());
        calendarInicio.set(Calendar.HOUR, horas);
        calendarInicio.set(Calendar.MINUTE, munutos);
        calendarInicio.set(Calendar.SECOND, segundos);                
        return calendarInicio.getTime();
    }
    
    /**
     * M�todo encargado de obtener la hora en String
     * @param fecha
     * @return
     */
    public static String obtenerHoraApartirDeDate(Date fecha){
        return (new SimpleDateFormat(FORMATO_HORA_MINUTO)).format(fecha);
    }
}
