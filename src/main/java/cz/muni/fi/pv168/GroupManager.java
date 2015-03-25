package cz.muni.fi.pv168;

import java.util.List;

/**
 * Created by michalsimik on 10.03.15.
 */
public interface GroupManager {
    public Group createGroup(Group group);
    public Group getGroup(int idGroup);
    public void editGroup();
    public void removeGroup(Group group);
    public List<Group> getGroups();
}
