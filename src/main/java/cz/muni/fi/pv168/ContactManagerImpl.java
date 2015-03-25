package cz.muni.fi.pv168;


import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;


/**
 * ${CLASS}
 * Created by michalsimik on 10.03.15.
 */
public class ContactManagerImpl implements ContactManager{

    final static Logger log = Logger.getLogger(ContactManagerImpl.class.getName());

    private final DataSource dataSource;

    public ContactManagerImpl(DataSource dataSource) {

        this.dataSource = dataSource;
    }


    @Override
    public List<Contact> getAllContacts() throws ContactException {
        log.debug("getAllContacts()");
        try (Connection con = dataSource.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("SELECT * FROM contacts")) {
                try (ResultSet rs = st.executeQuery()) {
                    List<Contact> contacts = new ArrayList<>();
                    while (rs.next()) {
                        Date date = rs.getDate("born");
                        LocalDate releaseDate = date==null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        contacts.add(new Contact(rs.getLong("id"), rs.getString("firstName"), rs.getString("surName"),rs.getString("address"),rs.getString("phoneNumber"), rs.getString("mail"), releaseDate));
                    }
                    return contacts;
                }
            }
        } catch (SQLException e) {
            log.error("cannot select contacts", e);
            throw new ContactException("database select failed", e);
        }
    }

    @Override
    public void addContact(Contact contact) throws ContactException{

       // log.debug("createContact({})", contact);
        try (Connection con = dataSource.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("insert into contacts (firstName, surName, address, phoneNumber, mail, born) values (?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS)) {
                st.setString(1, contact.getFirstName());
                st.setString(2, contact.getSurName());
                st.setString(3, contact.getAddress());
                st.setString(4, contact.getPhoneNumber());
                st.setString(5, contact.getMail());
                LocalDate date = contact.getBorn();
                st.setObject(6, date == null ? null : date.toString(), Types.DATE);
                st.executeUpdate();
                try (ResultSet keys = st.getGeneratedKeys()) {
                    if (keys.next()) {
                        Long id = keys.getLong(1);
                        contact.setId(id);
                    }
                }
            }
        } catch (SQLException e) {
            log.error("cannot insert contact", e);
            throw new ContactException("database insert failed", e);
        }
    }

    @Override
    public Contact getContactById(Long id) throws ContactException{
        //log.debug("getContactById({})", id);
        try (Connection con = dataSource.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("select * from CONTACTS where id = ?")) {
                st.setLong(1, id);
                try (ResultSet rs = st.executeQuery()) {
                    if (rs.next()) {
                        Date date = rs.getDate("born");
                        LocalDate releaseDate = date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                        return new Contact(rs.getLong("id"), rs.getString("firstName"), rs.getString("surName"),rs.getString("address"),rs.getString("phoneNumber"), rs.getString("mail"), releaseDate);
                    } else {
                        return null;
                    }
                }
            }
        } catch (SQLException e) {
            log.error("cannot select contacts", e);
            throw new ContactException("database select failed", e);
        }
    }

    @Override
    public void updateContact(Contact contact) throws ContactException{
       // log.debug("updateContact({})", contact);
        try (Connection con = dataSource.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("update contacts set FIRSTNAME=?, SURNAME=?, ADDRESS=?, PHONENUMBER=?, MAIL=?, BORN=? where id=?")) {
                st.setString(1, contact.getFirstName());
                st.setString(2, contact.getSurName());
                st.setString(3, contact.getAddress());
                st.setString(4, contact.getPhoneNumber());
                st.setString(5, contact.getMail());
                LocalDate date = contact.getBorn();
                st.setObject(6, date == null ? null : date.toString(), Types.DATE);
                st.setLong(7, contact.getId());
                int n = st.executeUpdate();
                if (n != 1) {
                    throw new ContactException("not updated contact with id " + contact.getId(), null);
                }
            }
        } catch (SQLException e) {
           // log.error("cannot update contacts", e);
            throw new ContactException("database update failed", e);
        }
    }
    @Override
    public void removeContact(Contact contact) throws ContactException{
        // log.debug("updateContact({})", contact);
        try (Connection con = dataSource.getConnection()) {
            try (PreparedStatement st = con.prepareStatement("DELETE FROM CONTACTS where id=?")) {
                st.setLong(1, contact.getId());
                int n = st.executeUpdate();
                if (n != 1) {
                    throw new ContactException("not deleted contact with id " + contact.getId(), null);
                }
            }
        } catch (SQLException e) {
             log.error("cannot update contacts", e);
            throw new ContactException("database remove failed", e);
        }
    }
}




