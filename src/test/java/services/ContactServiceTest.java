package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Contact;
import com.astontech.hr.services.ContactService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class ContactServiceTest {

    @Autowired
    private ContactService contactService;

    @Test
    public void elementServiceSaveTest(){
        Contact contact = new Contact("Email Test", "1212121212");

        assertNull(contact.getId());
        contactService.saveContact(contact);
        assertNotNull(contact.getId());

        Contact fetchedContact = contactService.getContactById(contact.getId());
        assertNotNull(fetchedContact);
        assertEquals(contact.getId(), fetchedContact.getId());

        fetchedContact.setEmailAddress("Email Update");
        contactService.saveContact(fetchedContact);

        Contact updatedContact = contactService.getContactById(fetchedContact.getId());
        assertEquals(updatedContact.getEmailAddress(), "Email Update");

    }
}
