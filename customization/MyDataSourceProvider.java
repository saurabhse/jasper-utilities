import java.io.File;
import java.io.FileInputStream;
import java.net.URLDecoder;
import java.sql.Connection;
import java.util.Properties;

import net.sf.jasperreports.engine.DefaultJasperReportsContext;
import net.sf.jasperreports.engine.JRDefaultScriptlet;
import net.sf.jasperreports.engine.JRPropertiesUtil;
import net.sf.jasperreports.engine.JRScriptletException;

public class MyDataSourceProvider extends JRDefaultScriptlet {
	private static String ENV_VAR =  "net.sf.jasperreports.env"; // this is set in JasperSoft IDE -> WIndow -> Preferences -> JAsperSoft Studio -> properties OR inside jar of jaspersoft on jasper server or jasperstarter
	private static String DOT =  ".";
	private static String DATASOURCE =  "\\datasource_";
	private static String PROP_EXTN =  ".properties";
	
	private static String HOSTNAME =  ".hostname";
	private static String UNAME =  ".username";
	private static String PWD =  ".pwd";
	
	
	
	public static Connection getDataSource(String database, String user) {
		String hostname = null;
		String uname = null;
		String pwd = null;
		try {
			Properties dbProperties = new Properties();
			String p = URLDecoder.decode(DataSourceProvider.class.getProtectionDomain().getCodeSource().getLocation().getPath(),"UTF-8");
			File jarPath = new File(p);
					//MyDataSourceProvider.class.getProtectionDomain().getCodeSource().getLocation().getPath());
			String env = JRPropertiesUtil.getInstance(DefaultJasperReportsContext.getInstance())
					.getProperty(ENV_VAR);

			String path = "";
			FileInputStream file;
			if (jarPath.getParentFile() != null) {
				String propertiesPath = jarPath.getParentFile().getAbsolutePath();

				path = propertiesPath.trim() + DATASOURCE + env + PROP_EXTN;
			} else {// we can change below for env property and path
				path = "ds_stage.properties";
			}
			path = path.replace("\\","/");
			file = new FileInputStream(path);

			dbProperties.load(file);

			file.close();

			hostname = dbProperties.getProperty(database + DOT + user + HOSTNAME);
			uname = dbProperties.getProperty(database + DOT + user + UNAME);
			pwd = dbProperties.getProperty(database + DOT + user + PWD);

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}

		Connection c = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = java.sql.DriverManager.getConnection(hostname, uname, pwd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
	
	@Override
	public void afterColumnInit() throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterDetailEval() throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterGroupInit(String arg0) throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterPageInit() throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterReportInit() throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeColumnInit() throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeDetailEval() throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeGroupInit(String arg0) throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforePageInit() throws JRScriptletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void beforeReportInit() throws JRScriptletException {
		// TODO Auto-generated method stub

	}
}
