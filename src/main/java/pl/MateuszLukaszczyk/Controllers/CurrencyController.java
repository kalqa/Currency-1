package pl.MateuszLukaszczyk.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.MateuszLukaszczyk.service.CurrencyService;

@Controller
@RequestMapping("/currency")
public class CurrencyController {

    CurrencyService currencyService = new CurrencyService();

    @GetMapping("/{code:[A-Z]+}")
    @ResponseBody
    public ResponseEntity<Double> returnActualCurrency(@PathVariable String code) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(currencyService.getDoubleResponseEntity(code));
    }

    @ResponseBody
    @GetMapping
    public ResponseEntity<String> availableCurrency() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Available Currency: PLN, USD, EUR");
    }
}


/*
        Napisz usługę w Springu lub Java EE, tak by pod adresem /currency/{code} była dostępna na sztywno zwracana wartość podanej waluty w kodzie.
        Dostępne waluty:
        {code} = PLN, USD, EUR

        Czyli na przykład:
        - dla localhost:8080/currency/PLN powiedzmy niech zwróci wartość 3,55
        - dla localhost:8080/currency/USD zwróci wartość 5,55
        - dla localhost:8080/currency/EUR zwróci wartość 4,55

        Możesz sobie zrobić mapę na sztywno z tymi wartościami, celem tego zadania jest obsługa wyjątku.

        Jeśli wpiszę kod waluty, która nie istnieje w Twojej aplikacji na przykład:
        localhost:8080/currency/FFF lub localhost:8080/currency/GGG

        Wtedy powinien zostać obsłużony wyjątek i nie powinno zwrócić wartości tej waluty, a wiadomość, że taki {code} nie istnieje.
 */

