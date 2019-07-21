
import com.verros.messageModel.Message;
import com.verros.resources.MessagesResources;
import com.verros.service.MessageService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MessageResourcesTest extends JerseyTest {

    MessageService messageService = new MessageService();


    @Override
    protected Application configure() {
        return new ResourceConfig(MessagesResources.class);
    }

    @Test
    public void givenGetHiGreeting_whenCorrectRequest_thenResponseIsOkAndContainsHi(){

        Response response = target("/messages").request(MediaType.APPLICATION_JSON).get();

       // Map<Long, Message> messages  = target("/messages").request(MediaType.APPLICATION_JSON).get(new GenericType<Map<Long, Message>>(){});

        assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        //assertEquals("Content of ressponse is: ",messageService.getAllMessages()  , responseMessages);

    }
}
