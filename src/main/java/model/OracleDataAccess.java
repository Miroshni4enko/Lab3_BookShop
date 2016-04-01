package model;

import org.apache.log4j.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;

/**
 * Class for connected to Data Base.
 *
 * @author Sasha Kostyan
 * @version %I%, %G%
 */

public class OracleDataAccess {
    private static final Logger LOG        = Logger.getLogger(OracleDataAccess.class);

    protected static class Singleton {
        public static final OracleDataAccess _INSTANCE = new OracleDataAccess();
    }

    public static OracleDataAccess getInstance() {
        return Singleton._INSTANCE;
    }

    private DataSource ds;
    private Context ctx;
    private Hashtable ht = new Hashtable();

    private OracleDataAccess(){
        ht.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        ht.put(Context.PROVIDER_URL, "t3://localhost:7001");
        try {
            ctx = new InitialContext(ht);
            ds = (javax.sql.DataSource) ctx.lookup("myJNDIDBName"); // change your JNDI_name
        } catch (NamingException e) {
            LOG.error("InitialContext or DataSource error", e);
        }finally {
            try {
                if (ctx != null) {ctx.close();}
            } catch (NamingException e) {
                LOG.error("error of close connection", e);
            }
        }
    }

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            LOG.error(e);
        }
        return connection;
    }
}

