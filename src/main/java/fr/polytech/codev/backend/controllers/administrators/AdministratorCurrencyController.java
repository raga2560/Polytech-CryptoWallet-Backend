package fr.polytech.codev.backend.controllers.administrators;

import fr.polytech.codev.backend.controllers.AbstractController;
import fr.polytech.codev.backend.exceptions.*;
import fr.polytech.codev.backend.forms.CurrencyForm;
import fr.polytech.codev.backend.services.impl.CurrencyServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/cryptowallet/administrator/{token}/currency")
public class AdministratorCurrencyController extends AbstractController {

    @Autowired
    private CurrencyServices currencyServices;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity all(@PathVariable String token) throws InvalidTokenException, ExpiredTokenException, UnknownEntityException, UnauthorizedUserException {
        assertUserIsAdministrator(token);
        return serializeSuccessResponse(this.currencyServices.all());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity get(@PathVariable String token, @PathVariable int id) throws InvalidTokenException, ExpiredTokenException, UnknownEntityException, UnauthorizedUserException {
        assertUserIsAdministrator(token);
        return serializeSuccessResponse(this.currencyServices.get(id));
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity insert(@PathVariable String token, @RequestBody String data) throws InvalidTokenException, InvalidEntityException, ExpiredTokenException, UnknownEntityException, UnauthorizedUserException {
        assertUserIsAdministrator(token);
        return serializeSuccessResponse("The currency was successfully inserted!", this.currencyServices.insert(deserialize(data, CurrencyForm.class)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity update(@PathVariable String token, @PathVariable int id, @RequestBody String data) throws InvalidTokenException, InvalidEntityException, ExpiredTokenException, UnknownEntityException, UnauthorizedUserException {
        assertUserIsAdministrator(token);
        return serializeSuccessResponse("The currency was successfully updated!", this.currencyServices.update(id, deserialize(data, CurrencyForm.class)));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity delete(@PathVariable String token, @PathVariable int id) throws InvalidTokenException, ExpiredTokenException, UnknownEntityException, UnauthorizedUserException {
        assertUserIsAdministrator(token);
        this.currencyServices.delete(id);
        return serializeSuccessResponse("The currency was successfully deleted!");
    }
}