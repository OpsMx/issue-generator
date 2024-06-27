package hello;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class IssueMessageUtils {

	private IssueMessageUtils() {
		throw new IllegalStateException("Utility class");
	}

	private static List<String> infoMessages;

	private static List<String> debugMessages;

	private static List<String> dbErrors;

	private static List<String> dbWarns;
	
	private static List<String> commonWords;
		
	public static final String CRITICAL = "CRITICAL";
	public static final String ERROR = "ERROR";
	public static final String DEBUG = "DEBUG";
	public static final String WARN = "WARN";
	
	static {
		commonWords = new ArrayList<>();
		commonWords.add("Internal Server Error occured");
		commonWords.add("while");
		commonWords.add("trying to");
		commonWords.add("load");
		commonWords.add("app config  from path");
		commonWords.add("initialized");
		commonWords.add("application");
		commonWords.add("creation of");
		commonWords.add("securerandom instance");
		commonWords.add("session id");
		commonWords.add("generation");
		commonWords.add("schema validating");
		commonWords.add("authorization");
		commonWords.add("APPConfig");
		commonWords.add("context");
		commonWords.add("project");
		
	}

	public static String getInfoMsg() {

		if (infoMessages == null) {
			infoMessages = new ArrayList<>();
			infoMessages.add("issuegen.sso.agent.SSOAgentFilter - project name is =/My_Dashboard");
			infoMessages.add("issuegen.dsg.managed.beans.MPayBusiness - TOP UP PAY CARD payable=20");
			infoMessages.add("issuegen.bus.managed.beans.MPayBusiness - Post Paid Services payable=486.42");
			infoMessages.add("issuegen.bus.managed.beans.MPayBusiness - Recharge payable=100-1-999");
			infoMessages.add("issuegen.bus.managed.beans.MPayBusiness - TOP UP PAY CARD payable=20-1-999");
			infoMessages.add("issuegen.bus.managed.beans.MPayBusiness - TOP UP PAY CARD payable=50-1-999");
			infoMessages.add("issuegen.bus.ApplicationContextEventListener - context intializing");
			infoMessages.add("issuegen.application.config.AppConfig - APPConfig is trying to load app config from path: xxxxxxxxxx");
			infoMessages.add("issuegen.application.config.AppConfig - APPConfig initialized successfully");
			infoMessages.add("issuegen.agent.util.SSOAgentConfigs - SSOConfig is trying to load app config from path: xxxxxxxxxx");
			infoMessages.add("issuegen.agent.util.SSOAgentConfigs - SSOConfig initialized successfully");
			infoMessages.add("issuegen.SSOAgentHttpSessionListener - session created");
			infoMessages.add("issuegen.sso.agent.SSOAgentFilter - project name is =/BillPay");
			infoMessages.add("issuegen.agent.saml.SAML2SSOManager - <?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			infoMessages.add("issuegen.myid.servlet.ForwardingServlet - user info successfully loaded");
			infoMessages.add("issuegen.sso.agent.SSOAgentFilter - project name is =/logAudit");
			infoMessages.add("issuegen.m.beans.CarRenewalManagedBean - ***loading Audit page**");
			infoMessages.add("issuegen.util.SessionIdGeneratorBase - Creation of SecureRandom instance for session ID generation took [350,333] milliseconds.");
			infoMessages.add("issuegen.managed.beans.JourneyPlannerMB - json : {\"listIcon\":\"\",\"showDirectionPanel\":false,\"showMyPlacesTab\":false,\"showNolTab\":false,\"applicationId\":1,\"mapSize\":0,\"locations\":[]}");
			infoMessages.add("issuegen.service.MicroAppResponse - pagerServices size: 28");
			infoMessages.add("issuegen.service.MicroAppResponse - categoryServices size: 26");
			infoMessages.add("issuegen.service.MicroAppResponse - categoryOneServices size: 1250");
			infoMessages.add("issuegen.AuthenticationInterceptor - authorizationValid: start");
		}

		return getRandomMsg(infoMessages);

	}

	public static String getDebugMsg() {

		if (debugMessages == null) {
			debugMessages = new ArrayList<>();
			debugMessages.add("issuegen.opensaml.xml.XMLConfigurator - Loading configuration from XML Document");
			debugMessages.add("issuegen.opensaml.xml.XMLConfigurator - Schema validating configuration Document");
			debugMessages.add("issuegen.opensaml.xml.XMLConfigurator - Configuration document validated");
			debugMessages.add("issuegen.opensaml.xml.XMLConfigurator - Preparing to load ObjectProviders");
			debugMessages.add("issuegen.opensaml.xml.XMLConfigurator - Initializing object provider");

		}

		return getRandomMsg(debugMessages);

	}
	

	public static String getDbError() {

		if (dbErrors == null) {
			dbErrors = new ArrayList<>();
			dbErrors.add("issuegen.dsg.managed.beans.DbConfig - PostgreSQL: 	02000	no_data");
			dbErrors.add("issuegen.dsg.managed.beans.DbConfig - PostgreSQL: 	08000	connection_exception");
			dbErrors.add("issuegen.dsg.managed.beans.DbConfig - PostgreSQL: 	08006	connection_failure");
			dbErrors.add("issuegen.dsg.managed.beans.DbConfig - PostgreSQL: 	08001	sqlclient_unable_to_establish_sqlconnection");
		}

		return getRandomMsg(dbErrors);
	}

	public static String getDbWarning() {

		if (dbWarns == null) {
			dbWarns = new ArrayList<>();
			dbWarns.add("issuegen.dsg.managed.beans.DbConfig - PostgreSQL: 	01000	warning");
			dbWarns.add("issuegen.dsg.managed.beans.DbConfig - PostgreSQL: 	0100C	dynamic_result_sets_returned");
			dbWarns.add("issuegen.dsg.managed.beans.DbConfig - PostgreSQL: 	01008	implicit_zero_bit_padding");
			dbWarns.add("issuegen.dsg.managed.beans.DbConfig - PostgreSQL: 	01007	privilege_not_granted");
		}

		return getRandomMsg(dbWarns);
	}

	private static String getRandomMsg(List<String> list) { 
		return list.get(new Random().nextInt(list.size())); 
	}
	
	public static String getErrorMsg() {
		
	     return getSuffle("IOExeception");
	}
	
	private static String getSuffle(String value) {
		
		commonWords.add(value);
		Collections.shuffle(commonWords);
		
		
		StringBuilder sb = new StringBuilder(commonWords.size());
		for (String s : commonWords) {
			sb.append(s);
			sb.append(" ");
		}
		
		commonWords.remove(value);
		
		  return sb.toString();
	}
}
