package launcher;

import java.rmi.Naming;

import data.dao.DBItemDAO;
import remote.IManagementSessionFacade;
import remote.ISongSessionFacade;
import remote.ManagementSessionFacade;
import remote.SongProvider;
import remote.SongSessionFacade;
import remote.payment.IPaymentSessionFacade;
import remote.payment.PaymentSessionFacade;
import server.FavourablePay;
import server.Pay;
import management.MemberManagement;
import gateways.authorization.AuthorizationGateway;
import gateways.payment.BankingGW;
import gateways.payment.PayPalGW;
import gateways.payment.PaymentGWFactory;

/** Main entry
 */
public class TralalaLauncher {
	
	public static void main(String[] argv) throws Exception{
		// Datos para hacer rebind en facades
		String namePayFac= "//" + argv[0] + ":" + argv[1] + "/" + argv[2];
		String nameSongFac = "//" + argv[3] + ":" + argv[4] + "/" + argv[5];
		String nameManageFac = "//" + argv[6] + ":" + argv[7] + "/" + argv[8];
		
		// Datos para hacer lookup en gateways
		// Auth -> para el memberManagement 
		String auth=  "//" + argv[9] + ":" + argv[10] + "/" + argv[11];
		AuthorizationGateway authga= new AuthorizationGateway(auth);
		MemberManagement memMan= new MemberManagement(authga);

		// Paypal y Banking se meten en la factory para que tenga una instancia de cada ya creada
		String paypal=  "//" + argv[12] + ":" + argv[13] + "/" + argv[14];
		PayPalGW gatewayPaypal= new PayPalGW(paypal);
		
		String banking=  "//" + argv[15] + ":" + argv[16] + "/" + argv[17];
		BankingGW gatewayBanking= new BankingGW(banking);
		
		PaymentGWFactory factory= PaymentGWFactory.getInstance(gatewayPaypal, gatewayBanking);
		// Los payment method necesitan una factoria para crear gateways, le metemos esta a los dos
		FavourablePay favourablePay= new FavourablePay(factory);
		Pay pay= new Pay(factory);
		
		//DAO setup
		DBItemDAO dbDAO = new DBItemDAO();
		
		//SongProvider setup
		SongProvider songP = new SongProvider(dbDAO);
		
		//Facades setup
		IManagementSessionFacade manSF = new ManagementSessionFacade(memMan);
		ISongSessionFacade songSF = new SongSessionFacade(songP);
		IPaymentSessionFacade paySF = new PaymentSessionFacade(dbDAO);
		
		//Rebinds
		Naming.rebind(nameManageFac, manSF);
		Naming.rebind(nameSongFac, songSF);
		Naming.rebind(namePayFac, paySF);
		
		System.out.println("Server active and waiting...");
		
	}
}
