package model;

/**
 * Class that describes the scripts to database.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */
public class SqlScripts {
    public static final String selectAllBook= "SELECT i.ID_ITEM,i.NAME,rub.NAME AS \"RUBRIC\",a.SURNAME||' '||a.NAME AS\"AUTHOR\", " +
            "p.PAGES,p.PRICE,p.AMOUNT,i.DESCRIPTION FROM ITEM i,PROPERTIES p,AUTHOR a, ITEM rub WHERE i.TYPE =0 AND i.ID_PROPERTIES=p.ID_BOOK " +
            "AND p.ID_AUTHOR=a.ID_AUTHOR AND i.PARENT_ID=rub.ID_ITEM AND rub.TYPE=1";
    public static final String selectAllAuthor= "SELECT * FROM AUTHOR";
    public static final String selectAllRubric= "SELECT * FROM ITEM WHERE TYPE =1";
    public static final String selectAllSection= "SELECT * FROM ITEM WHERE TYPE =2";
    public static final String selectAllCustomer= "SELECT * FROM CUSTOMER";
    public static final String selectAllOrder = "SELECT * FROM ORDERS o";

    public static final String selectConOfOrder = "SELECT * FROM CONTENR_ORDER WHERE ID_CONTENT=?";

    public static final String selectAuthorById = "SELECT * FROM AUTHOR WHERE ID_AUTHOR =?";
    public static final String selectOderById = "SELECT * FROM ORDERS WHERE ID_ORDER =?";
    public static final String selectCustomerById= "SELECT * FROM CUSTOMER WHERE ID_CUSTOMER=?";

    public static final String selectRubricById = "SELECT * FROM ITEM WHERE TYPE=1 AND ID_ITEM=?";
    public static final String selectSectionById = "SELECT * FROM ITEM WHERE TYPE=2 AND ID_ITEM=?";
}
