package vallegrande.edu.pe.msorder;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.format.annotation.DateTimeFormat;
import reactor.core.publisher.Mono;
import vallegrande.edu.pe.msorder.dto.OrderDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

@SpringBootTest
class MsOrderApplicationTests {

	@Test
	void contextLoads() {

	}

}
