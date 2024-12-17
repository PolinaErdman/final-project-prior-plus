package by.plus.priorbank.api;

import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    @BeforeEach
    void setUp() {
        by.plus.priorbank.api.UserLoginApiRequest.initRequestSpecification();
    }
}
