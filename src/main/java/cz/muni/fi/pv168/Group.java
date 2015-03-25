package cz.muni.fi.pv168;

/**
 * Created by michalsimik on 10.03.15.
 */
public class Group {
    int id;
    String name;


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Group(String name) {
        //this.idGroup = idGroup;
        this.name = name;
    }

    public void syncContacts(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id!= group.id) return false;
        if (!name.equals(group.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + name.hashCode();
        return result;
    }


}
