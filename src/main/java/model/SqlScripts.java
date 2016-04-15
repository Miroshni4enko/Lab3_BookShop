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
    public static final String SELECT_BOOK_BY_RUBRIC="SELECT i.ID_ITEM,i.NAME,rub.ID_ITEM AS \"RUBRIC\",a.ID_AUTHOR AS\"AUTHOR\",\n" +
            "p.PAGES,p.PRICE,p.AMOUNT,i.DESCRIPTION FROM ITEM i,PROPERTIES p,AUTHOR a,"+
            "ITEM rub WHERE i.TYPE =0 AND i.ID_PROPERTIES=p.ID_BOOK" +
            " AND p.ID_AUTHOR=a.ID_AUTHOR AND i.PARENT_ID=rub.ID_ITEM AND rub.TYPE=1 AND rub.ID_ITEM=?";
    public static final String SELECT_PROPERTIES_BY_ID="SELECT ID_PROPERTIES FROM ITEM WHERE ID_ITEM=? AND TYPE=0";
    public static final String SELECT_RUBRIC_BY_SECTION="SELECT * FROM ITEM WHERE TYPE =1 AND ITEM.PARENT_ID=?";

    public static final String CREATE_CUSTOMER="INSERT INTO CUSTOMER(LOGIN,PASSWORD,E_MAIL,PHOME_NUBMER, ROLE) values(?,?,?,?,?)";
    public static final String CREATE_AUTHOR="INSERT INTO AUTHOR(SURNAME,NAME) values(?,?)";
    public static final String CREATE_BOOK="{call ADDBOOK(?,?,?,?,?,?,?)}";
    public static final String CREATE_RUBRIC="INSERT INTO ITEM(NAME,PARENT_ID,DESCRIPTION,TYPE) values(?,?,?,1);";
    public static final String CREATE_SECTION="INSERT INTO ITEM(NAME,PARENT_ID,DESCRIPTION,TYPE) values(?,?,?,2);";
    public static final String CREATE_ORDER="{call  ADDORDER(?,?,?,?)}";

    public static final String DELETE_AUTHOR="DELETE FROM AUTHOR WHERE ID_AUTHOR = ?";
    public static final String DELETE_CUSTOMER="DELETE FROM CUSTOMER WHERE ID_CUSTOMER = ?";
    public static final String DELETE_RUBRIC="DELETE FROM ITEM WHERE ID_ITEM = ? AND TYPE=1";
    public static final String DELETE_SECTION="DELETE FROM ITEM WHERE ID_ITEM = ? AND TYPE=2";
    public static final String DELETE_BOOK="DELETE ITEM WHERE ID_ITEM = ? AND TYPE =0";

    public static final String UPDATE_ITEM="UPDATE ITEM SET PARENT_ID=?,NAME=?,DESCRIPTION=? WHERE ID_ITEM = ?";
    public static final String UPDATE_BOOK_PROPERTIES="UPDATE PROPERTIES SET ID_AUTHOR=?,PAGES=?,PRICE=?,AMOUNT=? WHERE ID_BOOK=?";
    public static final String UPDATE_AUTHOR="UPDATE AUTHOR SET SURNAME=?,NAME=? WHERE ID_AUTHOR = ?";
    public static final String UPDATE_CUSTOMER="UPDATE CUSTOMER SET LOGIN=?,PASSWORD=?,E_MAIL=?,PHOME_NUBMER=?,ROLE=? WHERE ID_CUSTOMER = ?";




}
