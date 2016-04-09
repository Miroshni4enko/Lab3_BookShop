package model;

/**
 * Class that describes the scripts to database.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class SqlScripts {
    public static final String SELECT_ALL_BOOK = "SELECT i.ID_ITEM,i.NAME,rub.ID_ITEM AS \"RUBRIC\",a.ID_AUTHOR AS\"AUTHOR\",\n" +
            "            p.PAGES,p.PRICE,p.AMOUNT,i.DESCRIPTION FROM ITEM i,PROPERTIES p,AUTHOR a, \n" +
            "            ITEM rub WHERE i.TYPE =0 AND i.ID_PROPERTIES=p.ID_BOOK\n" +
            "            AND p.ID_AUTHOR=a.ID_AUTHOR AND i.PARENT_ID=rub.ID_ITEM AND rub.TYPE=1";
    public static final String SELECT_ALL_AUTHOR = "SELECT * FROM AUTHOR";
    public static final String SELECT_ALL_RUBRIC = "SELECT * FROM ITEM WHERE TYPE =1";
    public static final String SELECT_ALL_SECTION = "SELECT * FROM ITEM WHERE TYPE =2";
    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM CUSTOMER";
    public static final String SELECT_ALL_ORDER = "SELECT * FROM ORDERS o";

    public static final String SELECT_CON_OF_ORDER = "SELECT * FROM CONTENR_ORDER WHERE ID_CONTENT=?";

    public static final String SELECT_AUTHOR_BY_ID = "SELECT * FROM AUTHOR WHERE ID_AUTHOR =?";
    public static final String SELECT_ODER_BY_ID = "SELECT * FROM ORDERS WHERE ID_ORDER =?";
    public static final String SELECT_CUSTOMER_BY_ID = "SELECT * FROM CUSTOMER WHERE ID_CUSTOMER=?";

    public static final String SELECT_RUBRIC_BY_ID = "SELECT * FROM ITEM WHERE TYPE=1 AND ID_ITEM=?";
    public static final String SELECT_SECTION_BY_ID = "SELECT * FROM ITEM WHERE TYPE=2 AND ID_ITEM=?";
    public static final String SELECT_ALL_BOOK_BY_ID ="SELECT i.ID_ITEM,i.NAME,rub.ID_ITEM AS \"RUBRIC\",a.ID_AUTHOR AS\"AUTHOR\",\n" +
            "p.PAGES,p.PRICE,p.AMOUNT,i.DESCRIPTION FROM ITEM i,PROPERTIES p,AUTHOR a," +
            "ITEM rub WHERE i.TYPE =0 AND i.ID_PROPERTIES=p.ID_BOOK " +
            "AND p.ID_AUTHOR=a.ID_AUTHOR AND i.PARENT_ID=rub.ID_ITEM AND rub.TYPE=1 AND i.ID_ITEM=?";

    public static final String CREATE_CUSTOMER="INSERT INTO CUSTOMER(LOGIN,PASSWORD,E_MAIL,PHOME_NUBMER, ROLE) values(?,?,?,?,?)";
    public static final String CREATE_AUTHOR="INSERT INTO AUTHOR(SURNAME,NAME) values(?,?)";

    public static final String DELETE_AUTHOR="DELETE FROM AUTHOR WHERE ID_AUTHOR = ?";
    public static final String DELETE_CUSTOMER="DELETE FROM CUSTOMER WHERE ID_CUSTOMER = ?";
    public static final String DELETE_RUBRIC="DELETE FROM ITEM WHERE ID_ITEM = ? AND TYPE=1";
    public static final String DELETE_SECTION="DELETE FROM ITEM WHERE ID_ITEM = ? AND TYPE=2";

}
