package org.devnull.zuul.web

import org.devnull.security.service.SecurityService
import org.devnull.zuul.service.ZuulService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class SystemAdminController {

    @Autowired
    SecurityService securityService

    @Autowired
    ZuulService zuulService


    @RequestMapping("/system/users")
    ModelAndView listUsers() {
        def model = [:]
        model.users = securityService.listUsers()
        model.roles = securityService.listRoles()
        return new ModelAndView("/system/users", model)
    }


}
