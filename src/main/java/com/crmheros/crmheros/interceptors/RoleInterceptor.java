package com.crmheros.crmheros.interceptors;

import com.crmheros.crmheros.models.Civil;
import com.crmheros.crmheros.models.Role;
import com.crmheros.crmheros.models.RoleStatus;
import com.crmheros.crmheros.repositories.CivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@ComponentScan
public class RoleInterceptor implements HandlerInterceptor {

    @Autowired
    private CivilRepository civilRepository;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        var userMail = request.getHeader(HttpHeaders.AUTHORIZATION);

        Civil civil = civilRepository.findByMail(userMail)
                .orElseThrow(() -> new Exception("Civil inexistant dans la base de données !"));
        for (Role role : civil.roles) {
            if (role.getRole().equals(RoleStatus.maitresupreme) & !role.getRole().equals(RoleStatus.supervilain)) {
                return true;
            }
        }
        throw new Exception("Civil non autorisé ici !");
    }
}