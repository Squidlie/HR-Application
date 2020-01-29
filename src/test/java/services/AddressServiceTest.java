package services;

import com.astontech.hr.Application;
import com.astontech.hr.domain.Address;
import com.astontech.hr.services.AddressService;
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
public class AddressServiceTest {
    @Autowired
    private AddressService addressService;

    @Test
    public void AddressServiceSaveTest(){
        Address address = new Address(1111);

        assertNull(address.getId());
        addressService.saveAddress(address);
        assertNotNull(address.getId());

        Address fetchedAddress = addressService.getAddressById(address.getId());
        assertNotNull(fetchedAddress);
        assertEquals(address.getId(), fetchedAddress.getId());

        fetchedAddress.setAddressNumber(2222);
        addressService.saveAddress(fetchedAddress);

        Address updatedAddress = addressService.getAddressById(fetchedAddress.getId());
        assertEquals(updatedAddress.getAddressNumber(), 2222);

    }
}
