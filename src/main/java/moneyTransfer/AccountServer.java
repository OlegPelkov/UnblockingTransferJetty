package moneyTransfer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by Oleg on 10/25/2018.
 */
public class AccountServer {

    private static AccountServer instance = new AccountServer();

    public static AccountServer getInstance() {
        return instance;
    }

    private AccountServer() {
    }

    private Server server;
    private boolean cas = false;

    public void setCas(boolean cas) {
        this.cas = cas;
    }

    public void start() throws Exception {
        server = new Server(8081);
        ServletContextHandler servletContextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(servletContextHandler);
        AccountServlet myServlet = new AccountServlet(cas);
        ServletHolder servletHolder = new ServletHolder(myServlet);
        servletContextHandler.addServlet(servletHolder, "/moneyTransfer");
        server.start();
    }

    public void stop() throws Exception {
      if(server!=null){
          server.stop();
      }
    }

    public Server getServer(){
        return server;
    }
}
