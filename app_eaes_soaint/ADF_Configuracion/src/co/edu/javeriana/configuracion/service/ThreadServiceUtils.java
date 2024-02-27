package co.edu.javeriana.configuracion.service;

import co.edu.javeriana.configuracion.utils.JsfUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import java.util.concurrent.TimeUnit;

import java.util.logging.Level;

import oracle.adf.share.logging.ADFLogger;

public class ThreadServiceUtils {
    public static final ADFLogger LOGGER =ADFLogger.createADFLogger(ThreadServiceUtils.class);
    public static final Integer TIEMPO_ESPERA=100;
    public static final Integer TIEMPO_ESPERA_CERRAR_TAREAS=800;
    private List<Future> listaServicios;
    private List<Callable<ResponseService>> listaTareas;
    private ExecutorService executorService;
    
    public ThreadServiceUtils() {
        super();
        this.initialize();
    }
    
    public void registerTask(final Callable<ResponseService> task){
        LOGGER.begin(Level.FINEST,"ThreadServiceUtils.registerTask");
        if(!this.listaTareas.contains(task)){
            this.listaTareas.add(task);
        }
        LOGGER.end(Level.FINEST,"ThreadServiceUtils.registerTask");
    }
    
    public List<ResponseService> executeAndWaitToComplete(){
        LOGGER.begin(Level.FINEST,"ThreadServiceUtils.executeAndWaitToComplete");
        this.submitTask();
        Boolean complete=null;
        do{
            final Iterator<Future> it=this.listaServicios.iterator();
            complete=Boolean.TRUE;
            while(it.hasNext()){
                final Future item=it.next();
                if(!item.isDone()){
                    complete=Boolean.FALSE;
                    break;
                }
            }
            if(!complete){
                LOGGER.info("Dormir esperar completados");
                try {
                    Thread.sleep(ThreadServiceUtils.TIEMPO_ESPERA);
                } catch (InterruptedException e) {
                    LOGGER.severe(e);
                }
            }
        }while(!complete);
        this.closeTasks();
        LOGGER.end(Level.FINEST,"ThreadServiceUtils.executeAndWaitToComplete");
        return this.getErrorResponse();
    }
    private void closeTasks(){
        LOGGER.begin(Level.FINEST,"ThreadServiceUtils.closeTasks");
        if(!this.executorService.isShutdown()){
            this.executorService.shutdown();
            try {
                if (!executorService.awaitTermination(ThreadServiceUtils.TIEMPO_ESPERA_CERRAR_TAREAS, TimeUnit.MILLISECONDS)) {
                    executorService.shutdownNow();
                } 
            } catch (InterruptedException e) {
                LOGGER.severe(e);
                executorService.shutdownNow();
            }
        }
        LOGGER.end(Level.FINEST,"ThreadServiceUtils.closeTasks");
    }
    public void showMessage(){
        LOGGER.begin(Level.FINEST,"ThreadServiceUtils.showMessage");
        final List<ResponseService> list=this.getErrorResponse(); 
        final Iterator<ResponseService> it=list.iterator();
        while(it.hasNext()){
            final ResponseService item=it.next();
            JsfUtils.addFacesErrorMessage(item.getError().getDescripcion());
        }
        LOGGER.end(Level.FINEST,"ThreadServiceUtils.showMessage");
    }
    public ResponseService getResponseEspecifico(final Integer indexTarea){
        final Future item=this.listaServicios.get(indexTarea);
        try {
            return ((ResponseService)item.get());
        } catch (InterruptedException e) {
            LOGGER.severe(e);
        } catch (ExecutionException e) {
            LOGGER.severe(e);
        }
        return null;
    }
    private void initialize(){
        this.listaServicios= new ArrayList<Future>();
        this.listaTareas= new ArrayList<Callable<ResponseService>>();
    }
    private void submitTask(){
        LOGGER.begin(Level.FINEST,"ThreadServiceUtils.submitTask");
        if(!this.listaTareas.isEmpty()){
            this.executorService=Executors.newFixedThreadPool(this.listaTareas.size());
            final Iterator<Callable<ResponseService>> it=this.listaTareas.iterator();
            while(it.hasNext()){
                final Callable<ResponseService> item=it.next();
                this.listaServicios.add(this.executorService.submit(item));
            }
            this.listaTareas.clear();
        }
        LOGGER.end(Level.FINEST,"ThreadServiceUtils.submitTask");
    }
    private List<ResponseService> getErrorResponse(){
        LOGGER.begin(Level.FINEST,"ThreadServiceUtils.getErrorResponse");
        final List<ResponseService> res= new ArrayList<ResponseService>();
        final Iterator<Future> it=this.listaServicios.iterator();
        while(it.hasNext()){
            final Future item=it.next();
            try {
                final ResponseService temp = ((ResponseService)item.get());
                if(!temp.getExitoso()){
                    res.add(temp);
                }
            } catch (InterruptedException e) {
                LOGGER.severe(e);
            } catch (ExecutionException e) {
                LOGGER.severe(e);
            } 
        }
        LOGGER.end(Level.FINEST,"ThreadServiceUtils.getErrorResponse");
        return res;
    }
}
