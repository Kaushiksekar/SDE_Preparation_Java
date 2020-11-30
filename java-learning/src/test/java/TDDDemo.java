import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

interface NumberSource{
    long fetchNumber();
}

class Calculator{
    private NumberSource numberSource;
    public Calculator(NumberSource numberSource) {
        this.numberSource = numberSource;
    }
    public long fetchAddAndTwo(){
        long num1 = numberSource.fetchNumber();
        long num2 = numberSource.fetchNumber();
        return num1+num2;
    }
}

@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class TDDDemo {
    private static final long FIRST_NUMBER = 12345678L;
    private static final long SECOND_NUMBER = 876543L;
    @Mock
    NumberSource numberSource;
    @BeforeAll
    void setup(){
        MockitoAnnotations.initMocks(this);
        Mockito.when(numberSource.fetchNumber()).thenReturn(FIRST_NUMBER, SECOND_NUMBER);
    }
    @Test
    public void addsTwoNumberSource(){
        Calculator calculator = new Calculator(numberSource);
        long actual = calculator.fetchAddAndTwo();
        Assertions.assertEquals(actual, FIRST_NUMBER+SECOND_NUMBER);
    }
}
