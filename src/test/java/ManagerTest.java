import com.airportmanagement.Persistence.PersistenceAirplaneProxy;
import com.airportmanagement.Persistence.PersistenceAirportProxy;


import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({PersistenceAirplaneProxy.class, PersistenceAirportProxy.class})
public class ManagerTest {
/*

    private ManagerAirport manager;

    @MockStrict
    private PersistenceAirplaneProxy persistenceAirplaneProxyMock;

    @MockStrict
    private PersistenceAirportProxy persistenceAirportProxyMock;


    @Before
    public void setup() {
        manager = new ManagerAirport();

        PowerMock.resetAll();
        PowerMock.mockStaticStrict(PersistenceAirplaneProxy.class);
        PowerMock.mockStaticStrict(PersistenceAirportProxy.class);
    }

    */
/**
     * Test where we insert one airplane with id that is already persisted
     *//*

    @Test
    public void insertAirplane_TestKO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "id already exists");
        Airplane airplaneToInsert = new Airplane(123, "Embraer505", 1998, false);

        EasyMock.expect(PersistenceAirplaneProxy.getInstance()).andReturn(persistenceAirplaneProxyMock);
        EasyMock.expect(persistenceAirplaneProxyMock.insert(airplaneToInsert)).andReturn(response);

        Airplane airplaneToTest = new Airplane(123, "Embraer505", 1998, false);

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.insert(airplaneToTest);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(false, "id already exists"), actualResponse);
    }

    */
/**
     * Test where we insert one airplane with id that is accepted
     *//*

    @Test
    public void insertAirplane_TestOK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "id persisted");
        Airplane airplaneToInsert = new Airplane(123, "Embraer505", 1998, false);

        EasyMock.expect(PersistenceAirplaneProxy.getInstance()).andReturn(persistenceAirplaneProxyMock);
        EasyMock.expect(persistenceAirplaneProxyMock.insert(airplaneToInsert)).andReturn(response);

        Airplane airplaneToTest = new Airplane(123, "Embraer505", 1998, false);

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.insert(airplaneToTest);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(true, "id persisted"), actualResponse);
    }

    */
/**
     * Test where we insert one airport with id that is already persisted
     *//*

    @Test
    public void insertAirport_TestKO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "id already exists");
        Airport airportToInsert = new Airport(123, "InternationalAirport", "Panama City");

        EasyMock.expect(PersistenceAirportProxy.getInstance()).andReturn(persistenceAirportProxyMock);
        EasyMock.expect(persistenceAirportProxyMock.insert(airportToInsert)).andReturn(response);

        Airport aiportToTest = new Airport(123, "InternationalAirport", "Panama City");

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.insert(aiportToTest);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(false, "id already exists"), actualResponse);
    }

    */
/**
     * Test where we insert one airport with id that is accepted
     *//*

    @Test
    public void insertAirport_TestOK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "id persisted");
        Airport airportToInsert = new Airport(123, "InternationalAirport", "Panama City");

        EasyMock.expect(PersistenceAirportProxy.getInstance()).andReturn(persistenceAirportProxyMock);
        EasyMock.expect(persistenceAirportProxyMock.insert(airportToInsert)).andReturn(response);

        Airport aiportToTest = new Airport(123, "InternationalAirport", "Panama City");

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.insert(aiportToTest);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(true, "id persisted"), actualResponse);
    }

    */
/**
     * Test where we update one airport with id that is accepted
     *//*

    @Test
    public void updateAirport_TestOK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airport updated, operation successfully");
        Airport airportToInsert = new Airport(123, "InternationalAirport", "Panama City");

        EasyMock.expect(PersistenceAirportProxy.getInstance()).andReturn(persistenceAirportProxyMock);
        EasyMock.expect(persistenceAirportProxyMock.update(airportToInsert)).andReturn(response);

        Airport aiportToTest = new Airport(123, "InternationalAirport", "Panama City");

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.update(aiportToTest);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(true, "airport updated, operation successfully"), actualResponse);

    }

    */
/**
     * Test where we update one airport with id that is already persisted
     *//*

    @Test
    public void updateAirport_TestKO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "Update failed - id doesn't exist");
        Airport airportToInsert = new Airport(123, "InternationalAirport", "Panama City");

        EasyMock.expect(PersistenceAirportProxy.getInstance()).andReturn(persistenceAirportProxyMock);
        EasyMock.expect(persistenceAirportProxyMock.update(airportToInsert)).andReturn(response);

        Airport aiportToTest = new Airport(123, "InternationalAirport", "Panama City");

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.update(aiportToTest);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(false, "Update failed - id doesn't exist"), actualResponse);

    }

    */
/**
     * Test where we update one airplane with id that is already persisted
     *//*

    @Test
    public void updateAirplane_TestKO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "Update failed - id doesn't exist");
        Airplane airplaneToInsert = new Airplane(123, "Embraer505", 1998, false);

        EasyMock.expect(PersistenceAirplaneProxy.getInstance()).andReturn(persistenceAirplaneProxyMock);
        EasyMock.expect(persistenceAirplaneProxyMock.update(airplaneToInsert)).andReturn(response);

        Airplane airplaneToTest = new Airplane(123, "Embraer505", 1998, false);

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.update(airplaneToTest);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(false, "Update failed - id doesn't exist"), actualResponse);
    }

    */
/**
     * Test where we update one airplane with id that is accepted
     *//*

    @Test
    public void updateAirplane_TestOK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airplane updated, operation successfully");
        Airplane airplaneToInsert = new Airplane(123, "Embraer505", 1998, false);

        EasyMock.expect(PersistenceAirplaneProxy.getInstance()).andReturn(persistenceAirplaneProxyMock);
        EasyMock.expect(persistenceAirplaneProxyMock.update(airplaneToInsert)).andReturn(response);

        Airplane airplaneToTest = new Airplane(123, "Embraer505", 1998, false);

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.update(airplaneToTest);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(true, "airplane updated, operation successfully"), actualResponse);
    }

    */
/**
     * Test where we delete one airport with id that is accepted
     *//*

    @Test
    public void deleteAirport_TestOK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airport updated, operation successfully");

        EasyMock.expect(PersistenceAirportProxy.getInstance()).andReturn(persistenceAirportProxyMock);
        EasyMock.expect(persistenceAirportProxyMock.deleteById(33)).andReturn(response);

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.deleteById(ClassesToPersist.AIRPORT, 33);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(true, "airport updated, operation successfully"), actualResponse);

    }

    */
/**
     * Test where we delete one airport with id that is already persisted
     *//*

    @Test
    public void deleteAirport_TestKO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "Delete failed - ID doesn't exist");

        EasyMock.expect(PersistenceAirportProxy.getInstance()).andReturn(persistenceAirportProxyMock);
        EasyMock.expect(persistenceAirportProxyMock.deleteById(33)).andReturn(response);

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.deleteById(ClassesToPersist.AIRPORT, 33);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(false, "Delete failed - ID doesn't exist"), actualResponse);

    }

    */
/**
     * Test where we delete one airplane with id that is already persisted
     *//*

    @Test
    public void deleteAirplane_TestKO() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(false, "Delete failed - ID doesn't exist");

        EasyMock.expect(PersistenceAirplaneProxy.getInstance()).andReturn(persistenceAirplaneProxyMock);
        EasyMock.expect(persistenceAirplaneProxyMock.deleteById(22)).andReturn(response);

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.deleteById(ClassesToPersist.AIRPLANE, 22);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(false, "Delete failed - ID doesn't exist"), actualResponse);
    }

    */
/**
     * Test where we delete one airplane with id that is accepted
     *//*

    @Test
    public void deleteAirplane_TestOK() {

        ResponseConnector response = ResponseConnectorFactory.createResponseConnector(true, "airplane deleted, operation successfully");

        EasyMock.expect(PersistenceAirplaneProxy.getInstance()).andReturn(persistenceAirplaneProxyMock);
        EasyMock.expect(persistenceAirplaneProxyMock.deleteById(44)).andReturn(response);

        PowerMock.replayAll();
        ResponseConnector actualResponse = manager.deleteById(ClassesToPersist.AIRPLANE, 44);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(true, "airplane deleted, operation successfully"), actualResponse);
    }

    */
/**
     * Test where we find one airplane with id that is accepted
     *//*

    @Test
    public void findAirplaneById_TestOK() {
        Airplane airplane = new Airplane(22, "Embraer505", 1998, false);
        Pair<ResponseConnector, Airplane> response = new Pair<>(ResponseConnectorFactory.createResponseConnector(true, "find airplane, operation successfully"), airplane);

        EasyMock.expect(PersistenceAirplaneProxy.getInstance()).andReturn(persistenceAirplaneProxyMock);
        EasyMock.expect(persistenceAirplaneProxyMock.findById(22)).andReturn(response);

        PowerMock.replayAll();
        Pair<ResponseConnector, Airplane> actualResponse = manager.findById(ClassesToPersist.AIRPLANE, 22);
        PowerMock.verifyAll();

        Airplane expectedAirplane = new Airplane(22, "Embraer505", 1998, false);
        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(true, "find airplane, operation successfully"), actualResponse.getFirst());
        Assert.assertEquals(expectedAirplane, actualResponse.getSecond());
    }

    */
/**
     * Test where we find one airplane with id that doesn't exist
     *//*

    @Test
    public void findAirplaneById_TestKO() {

        Pair<ResponseConnector, Airplane> response = new Pair<>(ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist"), null);

        EasyMock.expect(PersistenceAirplaneProxy.getInstance()).andReturn(persistenceAirplaneProxyMock);
        EasyMock.expect(persistenceAirplaneProxyMock.findById(22)).andReturn(response);

        PowerMock.replayAll();
        Pair<ResponseConnector, Airplane> actualResponse = manager.findById(ClassesToPersist.AIRPLANE, 22);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist"), actualResponse.getFirst());
        Assert.assertNull(actualResponse.getSecond());
    }

    */
/**
     * Test where we find one airport with id that doesn't exist
     *//*

    @Test
    public void findAirportById_TestKO() {

        Pair<ResponseConnector, Airport> response = new Pair<>(ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist"), null);

        EasyMock.expect(PersistenceAirportProxy.getInstance()).andReturn(persistenceAirportProxyMock);
        EasyMock.expect(persistenceAirportProxyMock.findById(22)).andReturn(response);

        PowerMock.replayAll();
        Pair<ResponseConnector, Airport> actualResponse = manager.findById(ClassesToPersist.AIRPORT, 22);
        PowerMock.verifyAll();

        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(false, "Find failed - ID doesn't exist"), actualResponse.getFirst());
        Assert.assertNull(actualResponse.getSecond());
    }

    */
/**
     * Test where we find one airport with id that is accepted
     *//*

    @Test
    public void findAirportById_TestOK() {

        Airport airport = new Airport(22, "International", "Lagos");
        Pair<ResponseConnector, Airport> response = new Pair<>(ResponseConnectorFactory.createResponseConnector(true, "find airport, operation successfully"), airport);

        EasyMock.expect(PersistenceAirportProxy.getInstance()).andReturn(persistenceAirportProxyMock);
        EasyMock.expect(persistenceAirportProxyMock.findById(22)).andReturn(response);

        PowerMock.replayAll();
        Pair<ResponseConnector, Airport> actualResponse = manager.findById(ClassesToPersist.AIRPORT, 22);
        PowerMock.verifyAll();

        Airport expectedAirport = new Airport(22, "International", "Lagos");
        Assert.assertEquals(ResponseConnectorFactory.createResponseConnector(true, "find airport, operation successfully"), actualResponse.getFirst());
        Assert.assertEquals(expectedAirport, actualResponse.getSecond());
    }


    @After
    public void after() {
        manager = null;
    }

*/

}
