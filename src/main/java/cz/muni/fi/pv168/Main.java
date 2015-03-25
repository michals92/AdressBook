package cz.muni.fi.pv168;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Properties;

/**
 * Created by michalsimik on 25.03.15.
 */
public class Main {

    public static void main(String[] args) throws ContactException, IOException,SQLException {



        Properties myconf = new Properties();
        myconf.load(Main.class.getResourceAsStream("/myconf.properties"));

        BasicDataSource ds = new BasicDataSource();
        ds.setUrl(myconf.getProperty("jdbc.url"));
        ds.setUsername(myconf.getProperty("jdbc.user"));
        ds.setPassword(myconf.getProperty("jdbc.password"));

        ContactManager contactManager  = new ContactManagerImpl(ds);

        List<Contact> allContacts = contactManager.getAllContacts();
        allContacts.forEach(System.out::println);

         /* db connection */
        try(Connection con = ds.getConnection()) {
            for (String line : Files.readAllLines(Paths.get("src", "main", "resources", "data.sql"))) {
                if(line.trim().isEmpty()) continue;
                if(line.endsWith(";")) line=line.substring(0,line.length()-1);
            //    log.debug("executing \"{}\"",line);
                try (PreparedStatement st1 = con.prepareStatement(line)) {
                    st1.execute();
                }
            }
        }

        Contact contact = new Contact(0l,"Karel","Janda","Hrnčířská 610002 Brno","511145666","karel.janda@fi.muni.cz", LocalDate.of(1992, 5, 1));
        contactManager.addContact(contact);
        System.out.println("contact = "+contact);

        contact = contactManager.getContactById(2l);
        contact.setFirstName("Alois");
        contactManager.updateContact(contact);


    }
}