package repositories;

import com.astontech.hr.configuration.RepositoryConfiguration;
import com.astontech.hr.domain.Element;
import com.astontech.hr.repositories.ElementRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class ElementRepositoryTest {
    @Autowired
    private ElementRepository elementRepository;

    @Test
    public void testSaveElement(){
        Element element = new Element();
        element.setElementName("Phone");

        assertNull(element.getId());
        elementRepository.save(element);
        assertNotNull(element.getId());

        Element fetchedElement = elementRepository.findOne(element.getId());
        assertNotNull(fetchedElement);
        assertEquals(element.getId(), fetchedElement.getId());

        fetchedElement.setElementName("Email");
        elementRepository.save(fetchedElement);

        Element updatedElement = elementRepository.findOne(fetchedElement.getId());
        assertEquals(updatedElement.getElementName(), "Email");
        elementRepository.deleteAll();

    }

    @Test
    public void testSaveElementList(){

        List<Element> elementList = new ArrayList<>();
        elementList.add(new Element("Phone"));
        elementList.add(new Element("Email"));
        elementList.add(new Element("Laptop"));
        elementList.add(new Element("PayRate"));

        elementRepository.save(elementList);

        Iterable<Element> fetchedElementList = elementRepository.findAll();
        int count = 0;
        for(Element element : fetchedElementList){
            count++;
        }

        assertEquals(4, count);

        elementRepository.deleteAll();
    }

    @Test
    public void testFindByName(){
        Element element = new Element("FindTestSingle");
        elementRepository.save(element);

        Element foundByNameElement = elementRepository.findByElementName("FindTestSingle");

        assertEquals(element.getId(), foundByNameElement.getId());

        elementRepository.deleteAll();
    }

    @Test
    public void testFindAllByElementName(){
        Element element1 = new Element("FindTest");
        elementRepository.save(element1);
        Element element2 = new Element("FindTest");
        elementRepository.save(element2);
        Element element3 = new Element("FindTest");
        elementRepository.save(element3);

        List<Element> foundAllByNameElement = elementRepository.findAllByElementName("FindTest");

        assertEquals(3, foundAllByNameElement.size());

        elementRepository.deleteAll();
    }

    @Test
    public void testFiveMethodsLab(){
        // Test of First Method: DistinctFirstByElementName
        List<Element> elements = new ArrayList<>();
        elements.add(new Element("Phone"));
        elements.add(new Element("Phone"));
        elements.add(new Element("Phone"));
        elements.add(new Element("Wallet"));
        elements.add(new Element("Keys"));
        elements.add(new Element("Keys"));
        elements.add(new Element("Laptop"));
        elements.add(new Element("Desktop"));
        elements.add(new Element("Phone Charger"));
        elements.add(new Element("Phone Charger"));
        elements.add(new Element("Playstation 4"));
        elements.add(new Element("Bluetooth Headset"));
        elements.add(new Element("Nintendo Switch"));
        elements.add(new Element("Nintendo Switch"));
        elements.add(new Element("Mechanical Keyboard"));
        elements.add(new Element("Wireless Mouse"));
        elements.add(new Element("Laptop Case"));
        elementRepository.save(elements);
        Element foundElement = elementRepository.findDistinctFirstByElementName("Phone Charger");
        assertEquals(9, (int)foundElement.getId());
        System.out.println("============= FIRST METHOD ==============");
        System.out.println("== Find Distinct First By Element Name ==");
        System.out.println("=========================================");
        System.out.println(foundElement.getElementName() + " " + foundElement.getId());
        System.out.println(" ");

        //Test of Second Method: findAllByElementNameIsNot
        List<Element> listOfNotPhones = elementRepository.findAllByElementNameIsNot("Phone");
        System.out.println("============= SECOND METHOD =============");
        System.out.println("==== Find All By Element Name Is Not ====");
        System.out.println("=========================================");
        for(Element element : listOfNotPhones){
            assert(element.getId() > 3);
            System.out.println(element.getElementName() + " " + element.getId());
        }
        System.out.println(" ");
        //Test of Third Method: findAllByElementNameStartsWith
        List<Element> elementStartsWithList = elementRepository.findAllByElementNameStartsWith("M");
        System.out.println("================ THIRD METHOD ================");
        System.out.println("==== Find All By Element Name Starts With ====");
        System.out.println("==============================================");
        for(Element element : elementStartsWithList){
            assertEquals(15, (int)element.getId());
            System.out.println(element.getElementName() + " " + element.getId());
        }
        System.out.println(" ");
        //Test of Fourth Method: findTop3ByElementNameStartsWithOrderByElementNameDesc
        List<Element> elementBottom3List = elementRepository.findTop3ByElementNameStartsWithOrderByIdDesc("P");
        System.out.println("================ FOURTH METHOD =================");
        System.out.println("==== Find Top 3 By Element Name Starts With ====");
        System.out.println("=========== Order By Element Id Desc ===========");
        System.out.println("================================================");
        for(Element element : elementBottom3List){
            assert(element.getId() < 12);
            assert(element.getId() > 8);
            System.out.println(element.getElementName() + " " + element.getId());
        }
        System.out.println(" ");
        //Test of Fifth Method: countElementsByElementNameContains
        Integer elementCountContainsE = elementRepository.countElementsByElementNameContains("e");
        System.out.println("================ FIFTH METHOD =================");
        System.out.println("======== Find Count By Name Contains E ========");
        System.out.println("===============================================");
        assertEquals(15, (int)elementCountContainsE);
        System.out.println(elementCountContainsE);
        System.out.println(" ");
    }
}
