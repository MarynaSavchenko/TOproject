import model.Tasks.BigFactorial
import spock.lang.Specification
import spock.lang.Unroll

class BigFactorialTest extends Specification{
    @Unroll
    def "Factorial"(){
        given:
        BigFactorial bigFactorial = new BigFactorial()

        when:
        def result = bigFactorial.factorial((BigInteger)number)

        then:
        result == res

        where:
        number | res
        0 | 1
        1 | 1
        2 | 2
        5 | 120
        10 | 3628800

    }
}
