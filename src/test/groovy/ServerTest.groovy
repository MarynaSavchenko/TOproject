import model.Server.Server
import spock.lang.Specification

class ServerTest  extends Specification{

    def "two calls to function getInstance of server should return the same object"(){
        given:
        Server server1 = Server.getInstance()
        Server server2 = Server.getInstance()

        expect:
        server1 == server2
    }
}
