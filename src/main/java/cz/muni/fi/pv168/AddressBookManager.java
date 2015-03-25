package cz.muni.fi.pv168;

import java.util.List;

/**
 * Created by michalsimik on 10.03.15.
 */
public interface AddressBookManager {

    public void putContactToGroup(Contact contact, Group group );
    public Group getGroupsWithContact(Contact contact);
    public List<Contact> getContactsOfGroup(Group group);
    public void removeContactFromGroup(Contact contact, Group group);
    public void removeAllContactsFromGroup(Group person);
}
