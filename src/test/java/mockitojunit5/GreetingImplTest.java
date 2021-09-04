package mockitojunit5;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GreetingImplTest {

	@Mock
	private GreetingService service;

	@InjectMocks // creates an instance of that class and injects the mocks that are created with @mock (or @spy)
	private GreetingImpl greeting;

	@Test
	public void greet_Should_Return_A_Valid_Output() {
		when(this.service.greet("Junit")).thenReturn("Hello Junit");
		String result = this.greeting.greet("Junit");
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Junit", result);
	}

	@Test
	public void greet_Should_Throw_An_Exception_For_NameIsNull() {
		doThrow(IllegalArgumentException.class).when(this.service).greet(null);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet(null);
		});
	}

	@Test
	public void greet_Should_Throw_An_Exception_For_Name_Is_Blank() {
		doThrow(IllegalArgumentException.class).when(service).greet("");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			greeting.greet("");
		});
	}

}
