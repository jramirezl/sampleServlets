
import edu.udem.java2.ejemplo1.sampleservlets.util.JDBCPool;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Web application lifecycle listener.
 *
 * @author jpramirez
 */
public class DBInitiatorServletListener implements ServletContextListener {
    JDBCPool bCPool = null;
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        bCPool = new JDBCPool();
        bCPool.init();
       sce.getServletContext().setAttribute("pool", bCPool);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        bCPool.destroy();
    }
}
