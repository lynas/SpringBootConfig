package com.lynas.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

/**
* Created by lynas on 11/24/2016
*/

@Controller
class RootController{

    @RequestMapping("/")
    fun root():String {

        return "home"
    }
}