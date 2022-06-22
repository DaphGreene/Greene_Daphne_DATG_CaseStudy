// package com.controller;

// //import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.crossstore.ChangeSetPersister;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;
// import org.springframework.web.servlet.view.RedirectView;

// import com.entity.User;
// import com.service.UserService;

// import javax.validation.Valid;
// import java.util.List;

// @Controller
// public class UserController {

//     private final UserService userService;

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }


//     @RequestMapping(path = "/", method = RequestMethod.GET)
//     public String getUsers(Model model){
//         List<User> users = userService.getUsers();
//         model.addAttribute("users", users);
//         model.addAttribute("userEntity", new User());
//         return "users";
//     }

//     // @PostMapping(path="/")
//     // public String addUser(Model model, @Valid UserInfo userInfo, BindingResult result){
//     //         userService.addUser(userInfo);
//     //     return "redirect:/";
//     // }

//     @GetMapping(path="/{id}")
//     public String getUser(@PathVariable("id") Integer id, Model model) throws ChangeSetPersister.NotFoundException {
//         UserInfo userInfo = userService.getUser(id);
//         model.addAttribute("userInfo",userInfo);
//         return "edit";
//     }

//     @PostMapping(path="/{id}")
//     public RedirectView updateUser(RedirectAttributes redirectAttributes, @PathVariable("id") Integer id, @ModelAttribute UserInfo userInfo) throws ChangeSetPersister.NotFoundException {
//         userService.updateUser(id, userInfo);
//         String message=(userInfo.isActive() ? "Updated " : "Deleted ")+" <b>"+userInfo.getUsername()+"</b>**";
//         RedirectView redirectView = new RedirectView("/",true);
//         redirectAttributes.addFlashAttribute("userMessage",message);
//         return redirectView;
//     }

//     @PostMapping("/signup")
//     public String registerUserAccount(@ModelAttribute("user")@Valid UserInfo userDto, BindingResult result){

//         UserInfo existing = userService.findByEmail(userDto.getEmail());
//         if (existing != null){
//             result.rejectValue("email", null, "There is already an account registered with that email");
//         }
//         if (result.hasErrors()){
//             return "signup";
//         }
//         userService.addUser(userDto);
//         return "redirect:/signup?success";
//     }

//     // @ModelAttribute("user")
//     // public UserInfo userRegistrationDto() {
//     //     return new UserRegistrationDto();
//     // }

//     @GetMapping("/signup")
//     public String showRegistrationForm(Model model) {
//         return "signup";
//     }


// }








