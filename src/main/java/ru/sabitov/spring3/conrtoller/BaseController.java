package ru.sabitov.spring3.conrtoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sabitov.spring3.models.Ill;
import ru.sabitov.spring3.repositories.AccountRepository;
import ru.sabitov.spring3.models.Account;
import ru.sabitov.spring3.repositories.IllRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class BaseController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private IllRepository illRepository;

    @GetMapping
    public String getBasePage(){
        Account byAccountId = accountRepository.findByAccountId(1L);
        System.out.println("Account: " + byAccountId);
        List<Ill> illness = List.of(illRepository.findById(1L).orElseThrow(IllegalArgumentException::new));
        byAccountId.setIllness(illness);
        accountRepository.saveAcc(byAccountId);
        accountRepository.doSomeShitWithModels(byAccountId, illness);
        System.err.println("saved");
        return "hello";
    }
}
