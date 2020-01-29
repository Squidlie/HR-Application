package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.repositories.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ContactRepositoryTest {
    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testSaveContact(){
        Contact contact = new Contact();
        contact.setEmailAddress("email@address.com");

        assertNull(contact.getId());
        contactRepository.save(contact);
        assertNotNull(contact.getId());

        Contact fetchedContact = contactRepository.findOne(contact.getId());
        assertNotNull(fetchedContact);
        assertEquals(contact.getId(), fetchedContact.getId());

        fetchedContact.setEmailAddress("Email");
        contactRepository.save(fetchedContact);

        Contact updatedContact = contactRepository.findOne(fetchedContact.getId());
        assertEquals(updatedContact.getEmailAddress(), "Email");
        contactRepository.deleteAll();

    }

    @Test
    public void testSaveElementList(){

        List<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Email One", "1111111111"));
        contactList.add(new Contact("Email Two", "1222222222"));
        contactList.add(new Contact("Email Three", "1333333333"));
        contactList.add(new Contact("Email Four", "1444444444"));


        contactRepository.save(contactList);

        Iterable<Contact> fetchedContactList = contactRepository.findAll();
        int count = 0;
        for(Contact contact : fetchedContactList){
            count++;
        }

        assertEquals(4, count);

        contactRepository.deleteAll();
    }
}
