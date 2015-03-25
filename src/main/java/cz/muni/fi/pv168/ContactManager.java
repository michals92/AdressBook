package cz.muni.fi.pv168;

import java.util.List;

/**
 * Created by michalsimik on 10.03.15.
 */
public interface ContactManager {

    public void addContact(Contact contact) throws ContactException;
    public void updateContact(Contact contact) throws ContactException;
    public List<Contact> getAllContacts() throws ContactException;
    public Contact getContactById(Long id) throws ContactException;
    public void removeContact(Contact contact) throws ContactException;

}
