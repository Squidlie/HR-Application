package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Address;
import com.astontech.hr.repositories.AddressRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class AddressRepositoryTest {

    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testSaveAddress(){
        Address address = new Address();
        address.setAddressNumber(1234);

        assertNull(address.getId());
        addressRepository.save(address);
        assertNotNull(address.getId());

        Address fetchedAddress = addressRepository.findOne(address.getId());
        assertNotNull(fetchedAddress);
        assertEquals(address.getId(), fetchedAddress.getId());

        fetchedAddress.setAddressNumber(4321);
        addressRepository.save(fetchedAddress);

        Address updatedAddress = addressRepository.findOne(fetchedAddress.getId());
        assertEquals(updatedAddress.getAddressNumber(), 4321);
        addressRepository.deleteAll();
    }

    @Test
    public void testSaveElementList(){

        List<Address> addressList = new ArrayList<>();
        addressList.add(new Address(1111));
        addressList.add(new Address(2222));
        addressList.add(new Address(3333));
        addressList.add(new Address(4444));

        addressRepository.save(addressList);

        Iterable<Address> fetchedElementList = addressRepository.findAll();
        int count = 0;
        for(Address address : fetchedElementList){
            count++;
        }

        assertEquals(4, count);

        addressRepository.deleteAll();
    }
}
