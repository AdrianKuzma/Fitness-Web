package sk.fitness.fitnessweb.user;


import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.fitness.fitnessweb.dto.RegisterDto;
import sk.fitness.fitnessweb.favourite.FavouriteService;


@RestController
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final FavouriteService favouriteService;

    public UserController(UserService userService, PasswordEncoder passwordEncoder, FavouriteService favouriteService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.favouriteService = favouriteService;

    }

    @PostMapping()
    public void updateUser(@RequestBody User user) {
        this.userService.updateUser(user);
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @NotNull RegisterDto registerDto){
        String username = registerDto.getUsername();
        String encodedPassword = passwordEncoder.encode(registerDto.getPassword());

        if(userService.existsByUsername(username)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        this.favouriteService.createNewFavouriteList(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/login")
    public void login() { }
}
