package launcher;

/** Main entry
 */
public class TralalaLauncher {
	public static void main(String[] argv){
		// Datos para hacer rebind en facades
		String namePayFac= "//" + argv[0] + ":" + argv[1] + "/" + argv[2];
		String nameSongFac = "//" + argv[3] + ":" + argv[4] + "/" + argv[5];
		String nameManageFac = "//" + argv[6] + ":" + argv[7] + "/" + argv[8];
		
		// Datos para hacer lookup en gateways
		String auth=  "//" + argv[9] + ":" + argv[10] + "/" + argv[11];
		String paypal=  "//" + argv[12] + ":" + argv[13] + "/" + argv[14];
		String banking=  "//" + argv[15] + ":" + argv[16] + "/" + argv[17];
		
		
	}
}
