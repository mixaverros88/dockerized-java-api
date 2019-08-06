
import com.verros.messageModel.Message;
import com.verros.resources.MessagesResources;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;

import static org.junit.Assert.assertEquals;

public class MessageResourcesTest extends JerseyTest {


    @Override
    protected Application configure() {
        return new ResourceConfig(MessagesResources.class);
    }

    @Test
    public void getMessage(){

        Response response = target("/messages").request(MediaType.APPLICATION_JSON).get();

       // Map<Long, Message> messages  = target("/messages").request(MediaType.APPLICATION_JSON).get(new GenericType<Map<Long, Message>>(){});

        assertEquals("Http Response should be 200: ", Response.Status.OK.getStatusCode(), response.getStatus());
        assertEquals("Http Content-Type should be: ", MediaType.APPLICATION_JSON, response.getHeaderString(HttpHeaders.CONTENT_TYPE));

        //assertEquals("Content of ressponse is: ",messageService.getAllMessages()  , responseMessages);

    }

    @Test
    public void postMessage(){

        Response response = target("/messages").request()
                .post(Entity.json("{\"author\": \"Mike verros 3\",\"message\": \"hello 3 \"}"));

        Message message = response.readEntity(Message.class);

        assertEquals("Http Response should be 201 ", Response.Status.CREATED.getStatusCode(), response.getStatus());
        assertEquals("Message text", message.getMessage(), "hello 3 ");

    }
}
