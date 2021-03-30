import adapter.controller.PersonController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ApplicationTest {

    @Autowired
    private PersonController personController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(personController).isNotNull();
    }

}