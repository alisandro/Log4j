package log;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;

import uk.org.simonsite.log4j.appender.TimeAndSizeRollingAppender;

public class LogPPA {

	public LogPPA() {
		super();
		// TODO Auto-generated constructor stub
	}

	String path;
	String nombre;
	String nivel;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
//	public void setLogPPA(){
//		String maxFileSize; 
//	}
//	
//	public void operacion1(String prop1, String prop2) {
//	    propiedad1 = prop1;
//	    propiedad2 = prop2;
//	    operacion1(propiedad1, propiedad2, propiedad3);
//	  }
	
	public void setLogPPA(String path, String nombre, NivelesPPA nivel) {

		Level level = null;
		System.out.println(level);
		switch (nivel) {

		case DEBUG:

			level = level.DEBUG;
			break;

		case INFO:
			level = level.INFO;
			break;

		case WARN:
			level = level.WARN;
			break;

		case ERROR:
			level = level.ERROR;
			break;

		default:
			return;

		}

		

		PatternLayout layout = new PatternLayout();
		String conversionPattern = "|%-p|%d|%m%n";
		layout.setConversionPattern(conversionPattern);

		// creates daily rolling file appender
		//DailyRollingFileAppender rollingAppender = new DailyRollingFileAppender();
		
		//RollingFileAppender rollingAppender2 = new RollingFileAppender();
		TimeAndSizeRollingAppender rollingAppender3 = new TimeAndSizeRollingAppender();
		
		
		
		rollingAppender3.setFile(path + nombre );
		//rollingAppender3.setName(path +nombre+"ppa.log");
		rollingAppender3.setMaxFileSize("100MB");
		rollingAppender3.setDatePattern("'.'yyyy-MM-dd");
		//rollingAppender3.setDatePatternLocale("");
		rollingAppender3.setLayout(layout);
		rollingAppender3.activateOptions();
		//'.'yyyy-MM-dd-HH-mm miuntos
		//'.'yyyy-MM-dd-HH horas
		//'.'yyyy-MM-dd-a medianoche
		//'.'yyyy-MM-dd dia
		//'.'yyyy-ww semana
		//'.'yyyy-MM 	mes
		
		
		
//		rollingAppender.setFile(path + nombre);
//		//rollingAppender.setBufferSize(100);
//rollingAppender.setDatePattern("'.'yyy-MM");
//		rollingAppender.setLayout(layout);
//		rollingAppender.activateOptions();
		
		// log4j.appender.file.Maxsize=100mb
		// configures the root logger

		Logger rootLogger = Logger.getRootLogger();
		rootLogger.setLevel(level);
		rootLogger.addAppender(rollingAppender3);

	}

	public LogPPA(String path, String nombre, NivelesPPA nivel) {
		setLogPPA(path, nombre, nivel);
	}

	private Logger log = Logger.getLogger(LogPPA.class);

//indicador,usuario,ip,idsesion,tokesesion,evento
	public void informacion(String indicador, String usuario, String ip, String idsesion, String tokensesion,
			String evento) {
		log.info(indicador + "|" + usuario + "|" + ip + "|" + idsesion + "|" + tokensesion + "|" + evento + "|");
	}

	public void Warning(String indicador, String usuario, String ip, String idsesion, String tokensesion,
			String evento) {
		log.warn(indicador + "|" + usuario + "|" + ip + "|" + idsesion + "|" + tokensesion + "|" + evento + "|");

	}

	public void Error(String indicador, String usuario, String ip, String idsesion, String tokensesion, String evento) {
		log.error(indicador + "|" + usuario + "|" + ip + "|" + idsesion + "|" + tokensesion + "|" + evento + "|");

	}

	public void Debugeo(String indicador, String usuario, String ip, String idsesion, String tokensesion,
			String evento) {

		log.debug(indicador + "|" + usuario + "|" + ip + "|" + idsesion + "|" + tokensesion + "|" + evento + "|");
	}

}
