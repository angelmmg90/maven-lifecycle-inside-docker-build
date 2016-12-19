package com.prueba.proyecto;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.LoggerContext;


/**
 * Hello world!
 *
 */
public class App 
{
    public static final Logger logger = LogManager.getLogger(App.class);
    
    public static void main( String[] args )
    {
        setLogLevel(Level.TRACE);
        
        logger.fatal("FATAL -> Se utiliza para mensajes críticos del sistema, generalmente después de guardar el mensaje el programa abortará.");
        logger.error("ERROR -> Cuando ocurrió un error.");
        logger.warn("WARN -> Circunstancia de posible error.");
        logger.info("INFO -> Información de la ejecución.");
        logger.debug("DEBUG -> Información importante a la hora de hacer debug.");
        logger.trace("TRACE -> Información de traza sobre la ejecución.");
        logger.trace("Hello World! ");
        
        
        
    }
    
    /**
     * Credit: http://stackoverflow.com/a/18409096/1612432
     *
     * @param l El nivel del log
     */
    public static void setLogLevel(Level l) {
        logger.info("Setting log level to " + l.name());
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration conf = ctx.getConfiguration();
        conf.getLoggerConfig(LogManager.ROOT_LOGGER_NAME).setLevel(l);
        ctx.updateLoggers(conf);
    }
}
