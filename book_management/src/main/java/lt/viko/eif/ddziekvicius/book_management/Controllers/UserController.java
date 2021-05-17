package lt.viko.eif.ddziekvicius.book_management.Controllers;

import lt.viko.eif.ddziekvicius.book_management.Library.UserRepo;
import lt.viko.eif.ddziekvicius.book_management.models.User;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserController {
    private final UserRepo repository= new UserRepo();

    /**
     *
     * @param name to login we use name
     * @param password to login we use password
     * @return returns logged user
     * @throws Exception
     */
    @RequestMapping(path = "/books/login/{name}/{password}", method = RequestMethod.GET)
    public String  LogIn(@PathVariable String name, @PathVariable int password) throws Exception {
                repository.Login(name,password);
                System.out.println(repository.GetLoggedInUser());
                return String.valueOf(repository.GetLoggedInUser());
    }

    /**
     *
     * @return returns profile of the user, shows chosen books
     */
    @RequestMapping(path = "/books/logged/profile", method = RequestMethod.GET)
    User ShowUserInfo(){

        return repository.GetLoggedInUser();
    }
}
