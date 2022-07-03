package com.example.demorestapinew.controller;
import com.example.demorestapinew.DemoRestapInewApplication;
import com.example.demorestapinew.pojo.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/*
 * Annotation @Controller: Tạo link trả ra giao diện HTML, JSP, ThymeLeaf
 * Annotation @ResController: (Là sự kết hợp của @Controller và @ResponseBody) Để xây dựng API
 * Annotation @RequestMapping: Tạo link tương ứng với class xử lý (giống với servlet)
 * Post Man
 * GET: truyền tham số dùng trên tab Param
 * POST: dùng tab Body
 * - form-data*: Dùng test dữ liệu có file hoặc không có file
 * - form-urlencoded: tham số sẽ thấy được ở link (không nhận file)
 * - raw*
 * */

@SpringBootApplication
@RestController
@RequestMapping("/account")
public class AccountController {

    public static void main(String[] args) {
        SpringApplication.run(AccountController.class, args);
    }

    // Khi gọi vào link thì user phải truyền 2 tham số (dạng key-value)
    @GetMapping("/create")
    public String createAccountTwo(@RequestParam("email") String email,
                                @RequestParam("password") String password) {
        System.out.println("Email: " + email);
        System.out.println("password: " + password);
        return email + " - " +  password;
    }

    // @RequestBody nhận tham số là Json/Text, dùng raw vì dữ liệu ghi trực tiếp và Request
    // Json sẽ được chuyển về một Object nếu đã được quy định kiểu Object tương ứng trong hàm
    @PostMapping(value = "/update")
    public String updateAccount(@RequestBody Account data) {
        System.out.println("Data: " + data.toString());
        return data.getPassword();
    }

    // Dấu tham số
    @DeleteMapping(value = "/delete/{email}/{password}")
    public String createAccount(@PathVariable("email") String email,
                                @PathVariable("password") String password) {
        System.out.println("Email: " + email);
        System.out.println("password: " + password);
        return email + " - " +  password;
    }

    // Quy định dữ liệu truyền vào buộc có content-type là application/x-www-form-urlencoded
    @PostMapping(value = "/update", consumes = "application/x-www-form-urlencoded")
    public String updateAccountV2(@RequestBody Account data) {
        System.out.println("Data: " + data.toString());
        return data.getPassword();
    }
}

