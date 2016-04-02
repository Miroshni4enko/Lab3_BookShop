package model;

/**
 * Class that describes the author's.
 *
 * @author Veleri Rechembei
 * @version %I%, %G%
 */

public class Author {
    private final int id;
    private String surname;
    private String name;

    public Author(int id){
        this.id=id;
    }
    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
