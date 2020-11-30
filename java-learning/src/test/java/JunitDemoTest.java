import org.junit.jupiter.api.*;

import java.util.stream.Stream;

public class JunitDemoTest {

    @BeforeAll
    public static void setup(){
        System.out.println("Setting up Junit");
    }

    @AfterAll
    public static void tearDown(){
        System.out.println("Tearing down Junit");
    }

    @Test
    public void lambdaTest(){
        Assertions.assertTrue(Stream.of(1, 2, 3)
        .mapToInt(value -> value*value)
        .sum() == 14, "Sum should be 14"
        );

    }

    @Test
    @DisplayName("Alternative testing")
    public void lambdaTest1(){
        Assertions.assertEquals(Stream.of(1, 2, 3)
                .mapToInt(value -> value * value)
                .sum(), 14, "Sum should be 14");
    }

    @Test
    @Tag("production")
    public void lambdaTest2(){
        String someString = "test";
        Assumptions.assumingThat(someString.equals("test1"),
                () -> Assertions.assertEquals(Stream.of(1, 2, 3)
                .mapToInt(value -> value*value)
                .sum(), 14, "Sum should be 14"
                ));
    }

    @Test
    public void lambdaTest3(){
        String someString = "test";
        Assumptions.assumeTrue(someString.equals("test1"));
        Assertions.assertEquals(Stream.of(1, 2, 3)
                        .mapToInt(value -> value*value)
                        .sum(), 14, "Sum should be 14"
        );
    }

}
