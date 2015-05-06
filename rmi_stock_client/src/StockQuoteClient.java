import java.rmi.*;
import java.rmi.server.*;

import stockcommon.StockQuote;
import stockcommon.StockQuoteServer;

public class StockQuoteClient extends UnicastRemoteObject implements StockQuote 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private java.applet.Applet _applet = null;
	
	public StockQuoteClient() throws RemoteException
	{
	}
	
	public StockQuoteClient(java.applet.Applet a) throws RemoteException
	{
		_applet = a;
	}
	
	public void quote(String symbol, double value) throws RemoteException
	{
		System.out.println("STOCK SYMBOL="+symbol + "\t VALUE="+value);
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args)
	{
		try{
			
//			if(System.getSecurityManager() == null)
//			{
//				System.setSecurityManager(new RMISecurityManager());
//			}
			StockQuote quote = new StockQuoteClient();
			
			StockQuoteServer server = (StockQuoteServer) Naming.lookup("rmi://localhost:8881/StockQuotes");
			System.out.println("Stock prices from RMI server:");
			server.registerClient(quote);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}